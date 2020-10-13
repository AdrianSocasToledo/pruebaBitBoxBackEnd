package com.prueba.bitbox.service;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<SupplierDTO> getSuppliers() {
		
		List<Supplier> suppliers = supplierRepository.findAll();
		List<SupplierDTO> suppliersDTO = new ArrayList<>();
		suppliers.forEach( supplier -> {
			suppliersDTO.add(new SupplierDTO(supplier.getIdSupplier(),supplier.getName(),supplier.getCountry()));
		});
		return suppliersDTO ;
	}

}
