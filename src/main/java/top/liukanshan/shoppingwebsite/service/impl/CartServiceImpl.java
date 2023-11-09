package top.liukanshan.shoppingwebsite.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.liukanshan.shoppingwebsite.entity.Cart;
import top.liukanshan.shoppingwebsite.mapper.CartMapper;
import top.liukanshan.shoppingwebsite.service.CartService;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {
}
