package com.prueba.bitbox.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.bitbox.dto.PriceReductionDTO;
import com.prueba.bitbox.service.PriceReductionServiceImpl;


@RestController
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("priceReductions")
public class PriceReductionRest {
	
	@Autowired
	PriceReductionServiceImpl priceReductionService;
	
	@GetMapping("/getPriceReductions")
	public ResponseEntity<List<PriceReductionDTO>> getItems(){
		HttpHeaders headers = new HttpHeaders();
		List<PriceReductionDTO> priceReductions = priceReductionService.getPricesReductions();
		return ResponseEntity.accepted().headers(headers).body(priceReductions);
	}

}
