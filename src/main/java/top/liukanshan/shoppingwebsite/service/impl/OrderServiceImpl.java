package top.liukanshan.shoppingwebsite.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.liukanshan.shoppingwebsite.entity.Order;
import top.liukanshan.shoppingwebsite.mapper.OrderMapper;
import top.liukanshan.shoppingwebsite.service.OrderService;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}
