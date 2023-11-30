package top.liukanshan.shoppingwebsite;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.liukanshan.shoppingwebsite.mapper.OrderItemMapper;

@SpringBootTest
public class OrderItemTest {
    @Autowired
    OrderItemMapper orderItemMapper;
    @Test
    public void test(){
        System.out.println(orderItemMapper.selectCountByItemId(5L));
    }
}
