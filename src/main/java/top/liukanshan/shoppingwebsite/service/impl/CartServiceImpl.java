package top.liukanshan.shoppingwebsite.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.liukanshan.shoppingwebsite.dto.Result;
import top.liukanshan.shoppingwebsite.entity.Cart;
import top.liukanshan.shoppingwebsite.entity.Item;
import top.liukanshan.shoppingwebsite.mapper.CartMapper;
import top.liukanshan.shoppingwebsite.mapper.ItemMapper;
import top.liukanshan.shoppingwebsite.service.CartService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public Result addCart(Long userId, Long itemId) {
        Cart cart = cartMapper.selectByUserItem(userId, itemId);
        if (cart == null) {
            cart = new Cart();
            cart.setUserId(userId);
            cart.setItemId(itemId);
            cart.setCount(1);
            if (save(cart)) {
                return Result.ok("成功加入一件商品,商品数量：1");
            }
        } else {
            cart.setCount(cart.getCount() + 1);
            if (updateById(cart)) {
                return Result.ok("成功加入一件商品，商品数量：" + cart.getCount());
            }
        }
        return Result.fail("加入失败");
    }

    @Override
    public Result getCart(Long userId) {
        List<Cart> carts = cartMapper.selectByUserId(userId);
        List<Item> items = new ArrayList<>();
        for (Cart cart : carts) {
            Item item = itemMapper.selectById(cart.getItemId());
            item.setCount(cart.getCount());
            items.add(item);
        }
        return Result.ok(items, (long) items.size());
    }

    @Override
    public Result deleteCart(Long userId, Long itemId) {
        int i = cartMapper.deleteByUserItem(userId, itemId);
        if (i > 0) {
            return Result.ok("删除成功");
        } else {
            return Result.fail("删除失败");
        }
    }
}
