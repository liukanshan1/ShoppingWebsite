package top.liukanshan.shoppingwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.liukanshan.shoppingwebsite.dto.Result;
import top.liukanshan.shoppingwebsite.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping()
    public Result newOrder(@CookieValue("user") Long userId){
        return orderService.newOrder(userId);
    }

    @GetMapping("/{id}")
    public Result finishOrder(@PathVariable Long id){
        return orderService.finishOrder(id);
    }
}
