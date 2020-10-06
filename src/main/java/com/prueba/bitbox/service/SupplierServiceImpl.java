package com.prueba.bitbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.bitbox.dto.SupplierDTO;
import com.prueba.bitbox.model.Supplier;
import com.prueba.bitbox.repository.SupplierRepository;

@Service
public class SupplierServiceImpl implements ISupplierService {
	
	@Autowired
	SupplierRepository supplierRepository;
	
	@Override
	public void createSupplier(SupplierDTO supplierDTO) {
		
		Supplier supplier = new Supplier();
		supplier.setName(supplierDTO.getName());
		supplier.setCountry(supplierDTO.getCountry());
		supplierRepository.save(supplier);
	}

}
