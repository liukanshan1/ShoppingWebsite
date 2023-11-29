package top.liukanshan.shoppingwebsite.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.liukanshan.shoppingwebsite.entity.Cart;

import java.util.List;

@Mapper
public interface CartMapper extends BaseMapper<Cart> {
    public Cart selectByUserItem(long userId, long itemId);

    public List<Cart> selectByUserId(long userId);

    public int deleteByUserItem(long userId, long itemId);
}
