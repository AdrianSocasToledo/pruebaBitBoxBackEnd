package com.prueba.bitbox.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.bitbox.dto.PriceReductionDTO;
import com.prueba.bitbox.model.PriceReduction;
import com.prueba.bitbox.repository.PriceReductionRepository;

@Service
public class PriceReductionServiceImpl implements IPriceReductionService{
	
	@Autowired
	PriceReductionRepository priceReductionRepository;
	
	@Override
	public List<PriceReductionDTO> getPricesReductions() {

		List<PriceReductionDTO> priceReductionsDTO = new ArrayList();
		List<PriceReduction> priceReductions = priceReductionRepository.findAll();
		priceReductions.forEach( element -> {
			priceReductionsDTO.add(new PriceReductionDTO(element.getIdPriceReduction(),element.getReducedPrice(),element.getStartDate(),element.getEndDate()));
		});
		return priceReductionsDTO;
	}

}
