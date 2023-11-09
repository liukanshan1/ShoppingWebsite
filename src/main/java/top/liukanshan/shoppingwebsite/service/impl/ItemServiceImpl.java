package top.liukanshan.shoppingwebsite.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.liukanshan.shoppingwebsite.entity.Item;
import top.liukanshan.shoppingwebsite.mapper.ItemMapper;
import top.liukanshan.shoppingwebsite.service.ItemService;

@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements ItemService {
}
