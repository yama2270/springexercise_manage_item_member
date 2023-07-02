package hello.springexercise02.domain;

import lombok.Data;

@Data
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item(){

    }

    public Item(String itemName,Integer price,Integer quantity){
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(Long id ,String itemName,Integer price,Integer quantity){
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

}
