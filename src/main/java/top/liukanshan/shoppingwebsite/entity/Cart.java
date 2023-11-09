package top.liukanshan.shoppingwebsite.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    private long id;
    private long userId;
    private long itemId;
    private int count;
}
