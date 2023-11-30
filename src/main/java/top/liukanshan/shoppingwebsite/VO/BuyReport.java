package top.liukanshan.shoppingwebsite.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyReport {
    private String name;
    private Long orderId;
    private BigDecimal amount;
    private String state;
}
