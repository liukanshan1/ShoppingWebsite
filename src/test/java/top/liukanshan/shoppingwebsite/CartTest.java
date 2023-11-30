package top.liukanshan.shoppingwebsite;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.liukanshan.shoppingwebsite.mapper.CartMapper;
import top.liukanshan.shoppingwebsite.mapper.OrderItemMapper;

@SpringBootTest
public class CartTest {
    @Autowired
    CartMapper cartMapper;
    @Test
    public void test(){
        System.out.println(cartMapper.selectCountByItemId(7L));
    }
}
