package top.liukanshan.shoppingwebsite.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.liukanshan.shoppingwebsite.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User selectUserByName(String userName);
}
