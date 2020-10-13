package com.prueba.bitbox.service;

import java.util.List;

import com.prueba.bitbox.dto.SupplierDTO;

public interface ISupplierService {
	
	void createSupplier(SupplierDTO supplier);
	
	List<SupplierDTO> getSuppliers();
}
