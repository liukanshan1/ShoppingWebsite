package top.liukanshan.shoppingwebsite.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.liukanshan.shoppingwebsite.dto.Result;
import top.liukanshan.shoppingwebsite.entity.Item;
import top.liukanshan.shoppingwebsite.mapper.ItemMapper;
import top.liukanshan.shoppingwebsite.service.ItemService;

import java.util.List;

@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public Result getAllItem() {
        List<Item> allItem = itemMapper.selectAll();
        return Result.ok(allItem, (long) allItem.size());
    }

    @Override
    public Result getItem(String name) {
        List<Item> allItem = itemMapper.selectByName(name);
        return Result.ok(allItem, (long) allItem.size());
    }

    @Override
    public Result insertItem(Item item) {
        if (save(item)){
            return Result.ok("插入成功");
        } else {
            return Result.fail("插入失败");
        }
    }

    @Override
    public Result deleteItem(long id) {
        if (removeById(id)) {
            return Result.ok("删除成功");
        } else {
            return Result.fail("删除失败");
        }
    }

    @Override
    public Result modifyItem(Item item) {
        if (updateById(item)) {
            return Result.ok("修改成功");
        } else {
            return Result.fail("修改失败");
        }
    }
}
