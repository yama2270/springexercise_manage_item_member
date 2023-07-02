package hello.springexercise02.controller.item;

import hello.springexercise02.domain.Item;
import hello.springexercise02.service.item.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private final ItemService itemService;

    @GetMapping
    public String items(Model model){
        model.addAttribute("items", itemService.selectAllItem());
        return "index";
    }

    @GetMapping("/addForm")
    public String addForm(Model model){
        model.addAttribute("item", new Item());
        return "item/addForm";
    }

    @PostMapping("/addForm")
    public String addItem(Item item, Model model) {
        Item saveItem = itemService.saveAndGetItem(item);
        model.addAttribute("item", saveItem);
        return "redirect:/items/"+item.getId();
    }

    @GetMapping("/{itemId}/editForm")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemService.selectByIdItem(itemId);
        model.addAttribute("item", item);
        return "item/editForm";
    }

    @PostMapping("/{itemId}/editForm")
    public String editItem(Item item, Model model) {
        Item updateItem = itemService.updateAndGetItem(item);
        model.addAttribute("item", item);
        return "redirect:/items/"+item.getId();
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable Long itemId,Model model) {
        model.addAttribute("item",itemService.selectByIdItem(itemId));
        return "item/item";
    }

}
