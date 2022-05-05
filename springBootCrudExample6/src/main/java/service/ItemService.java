package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Item;
import repository.ItemRepository;

@Service
public class ItemService {
	@Autowired
	private ItemRepository repo;
	
	public Item saveItem(Item item) {
		return repo.save(item);
	}
	
	public List<Item> saveItems(List<Item> items) {
		return repo.saveAll(items);
	}
  
	public List<Item> getItems() {
		return repo.findAll();
	}
	public Item getItemById(int id) {
		return repo.findById(id).orElse(null);
	}
	/*
	public Item getItemByName(String name) {
		return repo.findByName(name);
	}
   */
	public String deleteById(int id) {
		 repo.deleteById(id);
		 return "product removed"+id;
	}
	public Item updateItem(Item item) {
		Item ExistingItem=repo.findById(item.getId()).orElse(null);
		ExistingItem.setName(item.getName());
		ExistingItem.setPrice(item.getPrice());
		ExistingItem.setQuantity(item.getQuantity());
		return repo.save(ExistingItem);
	}
	
}
