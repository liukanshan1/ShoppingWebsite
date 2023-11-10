package top.liukanshan.shoppingwebsite.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.liukanshan.shoppingwebsite.dto.Result;
import top.liukanshan.shoppingwebsite.entity.User;

public interface UserService extends IService<User> {

    Result login(User user);
    Result register(User user);

}
