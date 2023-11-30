package top.liukanshan.shoppingwebsite.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewReport {
    private String name;
    private String itemName;
    private Integer viewCount;
    private BigDecimal price;
}
