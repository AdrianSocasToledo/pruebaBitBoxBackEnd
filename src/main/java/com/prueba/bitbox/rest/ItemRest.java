package com.prueba.bitbox.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.bitbox.dto.DesactivationDTO;
import com.prueba.bitbox.dto.ItemDTO;
import com.prueba.bitbox.model.Item;
import com.prueba.bitbox.service.IItemService;

@RestController
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("items")
public class ItemRest {
	
	@Autowired
	private IItemService itemService;
	
	@GetMapping("/getItems")
	public List<Item> getItems(){
		return itemService.getItems();
	}
	
	@GetMapping("/getItemById/{id}")
	public Item getItemById(@PathVariable String id) {
		System.out.println("Este es el ID -->"+id);
		return itemService.getItemById(Integer.parseInt(id));
	}
	
	@PostMapping("/createItem")
	public void createItem(@RequestBody ItemDTO item) {
		itemService.createItem(item);
	}
	
	@PutMapping("/desactivateItem")
	public void desactivateItem(@RequestBody DesactivationDTO desactivation) {
		itemService.desactivateItem(desactivation);
	}
	
	@PutMapping("/editItem")
	public void editItem(@RequestBody ItemDTO item) {
		itemService.updateItem(item);
	}
	
}
