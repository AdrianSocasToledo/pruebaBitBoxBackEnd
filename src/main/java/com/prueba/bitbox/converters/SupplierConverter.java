package com.prueba.bitbox.converters;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.bitbox.dto.SupplierDTO;
import com.prueba.bitbox.model.Supplier;
import com.prueba.bitbox.repository.SupplierRepository;

@Service 
public class SupplierConverter {
	
	@Autowired
	SupplierRepository supplierRepository;
	
	public List<Supplier> supplierDTOToSupplier(Set<SupplierDTO> set){
		List<Supplier> suppliers = new ArrayList();
		set.forEach( supplierDTO -> {
			suppliers.add(supplierRepository.findById(supplierDTO.getIdSupplier()).get());
		});
		return suppliers;
	}
	
	public List<SupplierDTO> supplierToSupplierDTO(List<Supplier> suppliers){
		List<SupplierDTO> suppliersDTO = new ArrayList();
		suppliers.forEach(supplier -> {
			suppliersDTO.add(new SupplierDTO(supplier.getIdSupplier(), supplier.getName(), supplier.getCountry()));
		});
		return suppliersDTO;
	}
}
