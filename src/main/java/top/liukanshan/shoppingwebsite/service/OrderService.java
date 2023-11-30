package top.liukanshan.shoppingwebsite.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.liukanshan.shoppingwebsite.dto.Result;
import top.liukanshan.shoppingwebsite.entity.Order;

public interface OrderService extends IService<Order> {
    Result newOrder(Long userId);

    Result finishOrder(Long id);

    Result getReport();

    Result getAllOrder();
}
