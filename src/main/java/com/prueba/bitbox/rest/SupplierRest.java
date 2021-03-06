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

import com.prueba.bitbox.dto.SupplierDTO;
import com.prueba.bitbox.service.SupplierServiceImpl;

@RestController
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("suppliers")
public class SupplierRest {
	
	@Autowired
	SupplierServiceImpl supplierService;
	
	@GetMapping("/getSuppliers")
	public ResponseEntity<List<SupplierDTO>> getSuppliers(){
		HttpHeaders headers = new HttpHeaders();
		List<SupplierDTO> suppliers = supplierService.getSuppliers();
		return ResponseEntity.accepted().headers(headers).body(suppliers);
	}

}
