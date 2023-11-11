package top.liukanshan.shoppingwebsite.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.liukanshan.shoppingwebsite.dto.Result;
import top.liukanshan.shoppingwebsite.entity.Cart;
import top.liukanshan.shoppingwebsite.mapper.CartMapper;
import top.liukanshan.shoppingwebsite.service.CartService;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    @Autowired
    private CartMapper cartMapper;

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
    public Result getAllCart(Long userId) {
        return null;
    }
}
