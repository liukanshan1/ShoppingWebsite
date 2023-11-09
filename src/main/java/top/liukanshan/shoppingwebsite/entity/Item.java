package top.liukanshan.shoppingwebsite.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private long id;
    private String name;
    private BigDecimal price;
    private String imgPath;
    private int count;

}
