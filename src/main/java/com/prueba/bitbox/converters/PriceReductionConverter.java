package com.prueba.bitbox.converters;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.bitbox.dto.PriceReductionDTO;
import com.prueba.bitbox.model.PriceReduction;
import com.prueba.bitbox.model.Supplier;
import com.prueba.bitbox.repository.PriceReductionRepository;
@Service
public class PriceReductionConverter {
	@Autowired
	PriceReductionRepository priceReductionRepository;
	
	public List<PriceReduction> priceReductionDTOToPriceReduction(Set<PriceReductionDTO> set){
		List<PriceReduction> priceReductions = new ArrayList();
		set.forEach( priceReductionDTO -> {
			priceReductions.add(priceReductionRepository.findById(priceReductionDTO.getIdPriceReduction()).get());
		});
		return priceReductions;
	}

}
