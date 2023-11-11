package top.liukanshan.shoppingwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.liukanshan.shoppingwebsite.dto.Result;
import top.liukanshan.shoppingwebsite.entity.Item;
import top.liukanshan.shoppingwebsite.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping()
    public Result getAll(){
        return itemService.getAllItem();
    }

    @GetMapping("/{name}")
    public Result getItem(@PathVariable String name){
        return itemService.getItem(name);
    }

    @PostMapping()
    public Result insertItem(@RequestBody Item item){
        return itemService.insertItem(item);
    }

    @DeleteMapping()
    public Result deleteItem(@RequestBody Item item){
        return itemService.deleteItem(item.getId());
    }

    @PutMapping()
    public Result modifyItem(@RequestBody Item item){
        return itemService.modifyItem(item);
    }


}
