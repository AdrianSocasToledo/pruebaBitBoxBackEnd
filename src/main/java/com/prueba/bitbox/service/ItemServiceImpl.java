package com.prueba.bitbox.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.bitbox.dto.DesactivationDTO;
import com.prueba.bitbox.dto.ItemDTO;
import com.prueba.bitbox.model.Item;
import com.prueba.bitbox.model.PriceReduction;
import com.prueba.bitbox.model.Supplier;
import com.prueba.bitbox.model.User;
import com.prueba.bitbox.repository.ItemRepository;
import com.prueba.bitbox.repository.PriceReductionRepository;
import com.prueba.bitbox.repository.SupplierRepository;
import com.prueba.bitbox.repository.UserRepository;

@Service
public class ItemServiceImpl implements IItemService{
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SupplierRepository supplierRepository;
	
	@Autowired
	PriceReductionRepository priceReductionRepository;
	
	@Autowired
	IDesactivationService desactivationService;
	
	@Override
	public List<Item> getItems() {
		return itemRepository.findAll();
	}
    
	@Override
	public Item getItemById(Integer id) {
		Optional<Item> item = itemRepository.findById(id);
		return item.get();
	}

	@Override
	public void createItem(ItemDTO requestItem) {
		
		LocalDate currentDate = LocalDate.now();
		Item item = new Item();
		Integer idUser = requestItem.getCreator();
		User creator = userRepository.getOne(idUser);
		
		item.setItemCode(requestItem.getItemCode());
		item.setDescription(requestItem.getDescription());
		item.setPrice(requestItem.getPrice());
		item.setState("Active");
		item.setCreationDate(currentDate);
		item.setCreator(creator);
		
		itemRepository.save(item);	
	}

	@Override
	public void desactivateItem(DesactivationDTO desactivation) {
		
		desactivationService.createDesactivation(desactivation);
		
		Item desactivatedItem = itemRepository.getOne(desactivation.getIdItem());
		desactivatedItem.setState(" Discontinued");
		itemRepository.save(desactivatedItem);
		
	}
	
	@Override
	public void activateItem(Integer id) {
		Item activatedItem = itemRepository.getOne(id);
		activatedItem.setState("Active");
		itemRepository.save(activatedItem);	
	}

	@Override
	public void updateItem(ItemDTO item) {
		
		Item editedItem = itemRepository.getOne(item.getIdItem());
		
		if(item.getPriceReduction() != null) {
			List<PriceReduction> pricesReductions = editedItem.getPriceReduction();
			PriceReduction addedPriceReduction = priceReductionRepository.getOne(item.getPriceReduction());
			pricesReductions.add(addedPriceReduction);
			editedItem.setPriceReduction(pricesReductions);
			
		}
		if(item.getSupplier() != null) {
			List<Supplier> suppliers = editedItem.getSuppliers();
			Supplier addedSupplier = supplierRepository.getOne(item.getSupplier());
			suppliers.add(addedSupplier);
			editedItem.setSuppliers(suppliers);
		}
		
		editedItem.setDescription(item.getDescription());
		editedItem.setPrice(item.getPrice());
		
		itemRepository.save(editedItem);
	}

	
}
