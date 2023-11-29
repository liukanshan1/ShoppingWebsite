package top.liukanshan.shoppingwebsite.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.liukanshan.shoppingwebsite.dto.Result;
import top.liukanshan.shoppingwebsite.entity.Cart;

public interface CartService extends IService<Cart> {
    Result addCart(Long userId, Long itemId);

    Result getCart(Long userId);

    Result deleteCart(Long userId, Long itemId);
}
