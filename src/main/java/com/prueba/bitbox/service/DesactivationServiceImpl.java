package com.prueba.bitbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.bitbox.dto.DesactivationDTO;
import com.prueba.bitbox.model.Desactivation;
import com.prueba.bitbox.model.Item;
import com.prueba.bitbox.model.User;
import com.prueba.bitbox.repository.DesactivationRepository;
import com.prueba.bitbox.repository.ItemRepository;
import com.prueba.bitbox.repository.UserRepository;

@Service
public class DesactivationServiceImpl implements IDesactivationService {
	
	@Autowired
	DesactivationRepository desactivationRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void createDesactivation(DesactivationDTO desactivationDTO) {
	
		User user = userRepository.getOne(desactivationDTO.getIdUser());
		Item item = itemRepository.getOne(desactivationDTO.getIdItem());
		
		Desactivation desactivation = new Desactivation();
		desactivation.setReason(desactivationDTO.getReason());
		desactivation.setItem(item);
		desactivation.setUser(user);
		
		desactivationRepository.save(desactivation);
	}


}
