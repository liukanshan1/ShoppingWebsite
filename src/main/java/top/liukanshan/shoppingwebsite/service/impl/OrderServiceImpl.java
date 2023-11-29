package top.liukanshan.shoppingwebsite.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.liukanshan.shoppingwebsite.dto.Result;
import top.liukanshan.shoppingwebsite.entity.*;
import top.liukanshan.shoppingwebsite.mapper.*;
import top.liukanshan.shoppingwebsite.service.CartService;
import top.liukanshan.shoppingwebsite.service.MailService;
import top.liukanshan.shoppingwebsite.service.OrderItemService;
import top.liukanshan.shoppingwebsite.service.OrderService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    MailService mailService;

    @Override
    public Result newOrder(Long userId) {
        List<Cart> carts = cartMapper.selectByUserId(userId);
        if (carts.isEmpty()) {
            return Result.fail("购物车为空");
        }
        List<OrderItem> orderItems = new ArrayList<>();
        BigDecimal total = new BigDecimal(0);
        for (Cart cart : carts) {
            Item item = itemMapper.selectById(cart.getItemId());
            OrderItem orderItem = new OrderItem();
            orderItem.setItemId(item.getId());
            orderItem.setCount(cart.getCount());
            orderItems.add(orderItem);
            total = total.add(item.getPrice().multiply(new BigDecimal(cart.getCount())));
        }
        User user = userMapper.selectById(userId);
        if (user.getBalance().compareTo(total) < 0) {
            return Result.fail("余额不足");
        }
        user.setBalance(user.getBalance().subtract(total));
        userMapper.updateById(user);
        Order order = new Order();
        order.setUserId(userId);
        order.setAmount(total);
        orderMapper.insert(order);
        for(OrderItem orderItem:orderItems){
            orderItem.setOrderId(order.getId());
            orderItemMapper.insert(orderItem);
        }
        for(Cart cart : carts) {
            cartMapper.deleteById(cart.getId());
        }
        mailService.sendMail(user.getEmail(),
                "完成订单：" + order.getId(),
                "点击链接完成订单：http://localhost:18080/order/" + order.getId());
        return Result.ok("下单成功");
    }

    @Override
    public Result finishOrder(Long id) {
        Order order = orderMapper.selectById(id);
        if (order == null) {
            return Result.fail("订单不存在");
        }
        if (order.isFinish()) {
            return Result.fail("订单已完成");
        }
        order.setFinish(true);
        orderMapper.updateById(order);
        return Result.ok("订单完成");
    }
}
