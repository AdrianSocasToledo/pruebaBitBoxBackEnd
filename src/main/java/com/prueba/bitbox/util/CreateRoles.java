package com.prueba.bitbox.util;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.prueba.bitbox.model.PriceReduction;
import com.prueba.bitbox.model.Role;
import com.prueba.bitbox.model.Supplier;
import com.prueba.bitbox.repository.PriceReductionRepository;
import com.prueba.bitbox.repository.SupplierRepository;
import com.prueba.bitbox.security.enums.RoleName;
import com.prueba.bitbox.service.RoleServiceImpl;

@Component
public class CreateRoles implements CommandLineRunner {
	
	@Autowired
	RoleServiceImpl roleService;
	
	@Autowired
	SupplierRepository supplierRepository;
	
	@Autowired
	PriceReductionRepository priceReductionRepository;
	
	@Override
	public void run(String... args) throws Exception {
		/**
		Role rolAdmin = new Role(RoleName.ROLE_ADMIN);
        Role rolUser = new Role(RoleName.ROLE_USER);
        roleService.save(rolAdmin);
        roleService.save(rolUser);
        
        Supplier supplier1 = new Supplier("supplier1","Spain");
        Supplier supplier2 = new Supplier("supplier2","Sweeden");
        supplierRepository.save(supplier1);
        supplierRepository.save(supplier2);
        
       PriceReduction pr1 = new PriceReduction(10,LocalDate.now(),LocalDate.now());
		priceReductionRepository.save(pr1);
		*/
	}

}
