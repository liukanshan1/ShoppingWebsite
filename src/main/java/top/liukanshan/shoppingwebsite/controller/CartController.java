package top.liukanshan.shoppingwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.liukanshan.shoppingwebsite.dto.Result;
import top.liukanshan.shoppingwebsite.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/{itemId}")
    public Result addCart(@CookieValue("user") Long userId, @PathVariable Long itemId){
        return cartService.addCart(userId, itemId);
    }

    @GetMapping()
    public Result getAllCart(@CookieValue("user") Long userId){
        return cartService.getAllCart(userId);
    }


}
