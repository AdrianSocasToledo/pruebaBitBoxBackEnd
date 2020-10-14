package com.prueba.bitbox.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public ResponseEntity<List<Item>> getItems(){
		return ResponseEntity.accepted().body(itemService.getItems());
	}
	
	@GetMapping("/getItemById/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable String id) {
		return ResponseEntity.accepted().body(itemService.getItemById(Integer.parseInt(id)));
	}
	
	@PostMapping("/createItem")
	public ResponseEntity<String> createItem(@RequestBody ItemDTO item) {
		
		itemService.createItem(item);
		return ResponseEntity.accepted().body(" Item was created");
	}
	
	@PutMapping("/desactivateItem")
	public ResponseEntity<String> desactivateItem(@RequestBody DesactivationDTO desactivation) {
		itemService.desactivateItem(desactivation);
		return ResponseEntity.accepted().body(" item was desactivated");
	}
	

	@PutMapping("/activateItem/{id}")
	public ResponseEntity<String> activateItem(@PathVariable String id) {
		itemService.activateItem(Integer.parseInt(id));
		return ResponseEntity.accepted().body(" item was activated");
	}
	
	@PutMapping("/editItem")
	public ResponseEntity<String> editItem(@RequestBody ItemDTO item) {
		itemService.updateItem(item);
		return ResponseEntity.accepted().body("item was edited");
	}
	
	@PreAuthorize("hasRole('Admin')")
	@DeleteMapping("/deleteItem")
	public ResponseEntity<String> deleteItem(@RequestBody String id){
		itemService.deleteItem(Integer.parseInt(id));
		return ResponseEntity.accepted().body(" item id:"+id+" was deleted");
	}
	
}
