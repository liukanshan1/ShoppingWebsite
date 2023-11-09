package top.liukanshan.shoppingwebsite.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    private long id;
    private long orderId;
    private long itemId;
    private int count;
}
