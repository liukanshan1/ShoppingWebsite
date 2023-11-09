package top.liukanshan.shoppingwebsite.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.liukanshan.shoppingwebsite.entity.OrderItem;
import top.liukanshan.shoppingwebsite.mapper.OrderItemMapper;
import top.liukanshan.shoppingwebsite.service.OrderItemService;

@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {
}
