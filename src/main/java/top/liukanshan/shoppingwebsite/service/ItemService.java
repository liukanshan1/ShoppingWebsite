package top.liukanshan.shoppingwebsite.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.liukanshan.shoppingwebsite.dto.Result;
import top.liukanshan.shoppingwebsite.entity.Item;

public interface ItemService extends IService<Item> {

    public Result getAllItem();

    Result insertItem(Item item);

    Result deleteItem(long id);

    Result modifyItem(Item item);

    Result getItem(String name);
}
