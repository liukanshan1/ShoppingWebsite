package top.liukanshan.shoppingwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.liukanshan.shoppingwebsite.dto.Result;
import top.liukanshan.shoppingwebsite.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping()
    public Result getCart(@CookieValue("user") Long userId){
        return cartService.getCart(userId);
    }

    @GetMapping("/{itemId}")
    public Result addCart(@CookieValue("user") Long userId, @PathVariable Long itemId){
        return cartService.addCart(userId, itemId);
    }

    @GetMapping("/all")
    public Result getViewReport(){
        return cartService.getViewReport();
    }

    @DeleteMapping("/{itemId}")
    public Result deleteCart(@CookieValue("user") Long userId, @PathVariable Long itemId){
        return cartService.deleteCart(userId, itemId);
    }

}
