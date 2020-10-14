package com.prueba.bitbox.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.bitbox.converters.PriceReductionConverter;
import com.prueba.bitbox.converters.SupplierConverter;
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
	
	@Autowired
	private SupplierConverter supplierConverter;
	
	@Autowired
	private PriceReductionConverter priceReductionConverter;
	
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
		Integer idUser = requestItem.getCreator().getIdUser();
		User creator = userRepository.findByUserName(requestItem.getCreator().getUserName()).get();
		
		
		item.setItemCode(requestItem.getItemCode());
		item.setDescription(requestItem.getDescription());
		item.setPrice(requestItem.getPrice());
		item.setState("Active");
		item.setCreationDate(currentDate);
		item.setCreator(creator);
		
		if(requestItem.getSuppliers() != null) {
			item.setSuppliers(supplierConverter.supplierDTOToSupplier(requestItem.getSuppliers()));
		}
		
		if(requestItem.getPriceReduction() != null) {
			item.setPriceReduction(priceReductionConverter.priceReductionDTOToPriceReduction(requestItem.getPriceReduction()));
		}
		
		
		itemRepository.save(item);	
	}

	@Override
	public void desactivateItem(DesactivationDTO desactivation) {
		
		desactivationService.createDesactivation(desactivation);
		
		Item desactivatedItem = itemRepository.getOne(desactivation.getIdItem());
		desactivatedItem.setState("Discontinued");
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
			editedItem.setPriceReduction(priceReductionConverter.priceReductionDTOToPriceReduction(item.getPriceReduction()));
		}else {
			List<PriceReduction> empty = new ArrayList<>();
			editedItem.setPriceReduction(empty);
		}
		
		
		if(item.getSuppliers() != null) {
			editedItem.setSuppliers(supplierConverter.supplierDTOToSupplier(item.getSuppliers()));
		}else {
			List<Supplier> empty = new ArrayList<>();
			editedItem.setSuppliers(empty);
		}
		
		editedItem.setDescription(item.getDescription());
		editedItem.setPrice(item.getPrice());
		
		itemRepository.save(editedItem);
	}

	@Override
	public void deleteItem(Integer id) {
		Item item = itemRepository.findById(id).get();
		itemRepository.delete(item);
		
	}

	
}
