package hello.springexercise02.service.item;

import hello.springexercise02.domain.Item;
import hello.springexercise02.mapper.item.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemMapper itemMapper;

    public List<Item> selectAllItem(){
        return itemMapper.selectAllItem();
    }

    public Item saveAndGetItem(Item item){
        itemMapper.saveItem(item);
        return itemMapper.selectByIdItem(item.getId());
    }

    public Item updateAndGetItem(Item item) {
        itemMapper.updateItem(item);
        return itemMapper.selectByIdItem(item.getId());
    }

    public Item selectByIdItem(Long id) {
        return itemMapper.selectByIdItem(id);
    }

}
