package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Item;
import service.ItemService;

@RestController
public class ItemController {
    
	@Autowired
	private ItemService service;
	
	@PostMapping("/additem")
	public Item addItem(@RequestBody Item item) {
		return service.saveItem(item);
	}
	@PostMapping("/additems")
	public List<Item> addItem(@RequestBody List<Item> items) {
		return service.saveItems(items);
	}
	
	@GetMapping("/items")
	public List<Item> findAllItems(){
		return service.getItems();
	}
	@GetMapping("/items/{id}")
	public Item findItemById(@PathVariable int id){
		return service.getItemById(id);
	}

	@PutMapping("/update")
	public Item updateItem(@RequestBody Item item) {
		return service.updateItem(item);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteItem(@PathVariable int id) {
		return service.deleteById(id);
	}
}
