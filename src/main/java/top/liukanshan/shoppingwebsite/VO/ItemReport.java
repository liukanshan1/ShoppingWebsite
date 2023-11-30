package top.liukanshan.shoppingwebsite.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemReport {
    private String name;
    private Integer count;
    private BigDecimal price;
    private Integer sell_count; // 销量
    private BigDecimal sell_amount; // 销售额
    private Integer cart_sell_count; // 购物车 + 销量
}
