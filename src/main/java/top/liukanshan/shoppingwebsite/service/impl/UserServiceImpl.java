package top.liukanshan.shoppingwebsite.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.liukanshan.shoppingwebsite.dto.Result;
import top.liukanshan.shoppingwebsite.entity.User;
import top.liukanshan.shoppingwebsite.mapper.UserMapper;
import top.liukanshan.shoppingwebsite.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result login(User user) {
        User u = userMapper.selectUserByName(user.getUsername());
        if (u != null) {
            if (u.getPassword().equals(user.getPassword())) {
                return Result.ok("登录成功");
            } else {
                return Result.fail("密码错误");
            }
        } else {
            return Result.fail("用户不存在");
        }
    }

    @Override
    public Result register(User user) {
        User u = userMapper.selectUserByName(user.getUsername());
        if (u != null) {
            return Result.fail("用户已存在");
        } else {
            boolean b = save(user);
            if (b) {
                return Result.ok("注册成功");
            } else {
                return Result.fail("注册失败");
            }
        }
    }
}
