package top.liukanshan.shoppingwebsite.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.liukanshan.shoppingwebsite.entity.User;
import top.liukanshan.shoppingwebsite.mapper.UserMapper;
import top.liukanshan.shoppingwebsite.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
