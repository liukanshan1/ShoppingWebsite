package top.liukanshan.shoppingwebsite.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.liukanshan.shoppingwebsite.entity.OrderItem;

@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {

    Integer selectCountByItemId(Long itemId);
}
