package hello.springexercise02.mapper.item;

import hello.springexercise02.domain.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {

    List<Item> selectAllItem();

    void saveItem(Item item);

    Item selectByIdItem(Long id);

    void updateItem(Item item);

}
