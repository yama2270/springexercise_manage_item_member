package hello.springexercise02.service;

import hello.springexercise02.domain.Item;
import hello.springexercise02.mapper.item.ItemMapper;
import hello.springexercise02.service.item.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class ItemServiceTest {

    @Autowired
    ItemMapper itemMapper;

    @Test
    // 아이템 전체 조회
    public void selectAllItem(){
        List<Item> itemList = itemMapper.selectAllItem();
        for (Item item: itemList) {
            System.out.println("item = " + item);
        }
    }

    @Test
    public void saveAndGetItem(){
        Item item = new Item(1L, "itemA", 10, 10);
        itemMapper.saveItem(item);
        Item saveItem = itemMapper.selectByIdItem(item.getId());
        System.out.println(saveItem);
    }

    @Test
    public void updateAndGetItem(){
        Item item = new Item(1L, "itemA", 10, 10);
        itemMapper.saveItem(item);
        Item newItem = new Item(1L, "itemAA", 100, 100);
        itemMapper.updateItem(newItem);
        Item updateItem = itemMapper.selectByIdItem(newItem.getId());
        System.out.println("updateItem = " + updateItem);
    }

    @Test
    public void selectByIdItem(){
        Item item = new Item(1L, "itemA", 10, 10);
        itemMapper.saveItem(item);
        Item findItem = itemMapper.selectByIdItem(item.getId());
        System.out.println("findItem = " + findItem);
    }

}
