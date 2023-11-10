package top.liukanshan.shoppingwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.liukanshan.shoppingwebsite.dto.Result;
import top.liukanshan.shoppingwebsite.entity.User;
import top.liukanshan.shoppingwebsite.service.UserService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public Result login(@RequestBody User user) {
        return userService.login(user);
    }

    @PutMapping
    public Result register(@RequestBody User user) {
        user.setBalance(new BigDecimal(0));
        return userService.register(user);
    }
}
