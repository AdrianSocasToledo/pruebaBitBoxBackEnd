package com.prueba.bitbox.service;

import java.util.List;

import com.prueba.bitbox.dto.DesactivationDTO;
import com.prueba.bitbox.dto.ItemDTO;
import com.prueba.bitbox.model.Item;

public interface IItemService {
	
	List<Item> getItems();
	
	void createItem(ItemDTO item);
	
	Item getItemById(Integer id);
	
	void desactivateItem(DesactivationDTO desactivationDTO);
	
	void activateItem(Integer id);
	
	void updateItem(ItemDTO item);
	
	void deleteItem(Integer id);
}
