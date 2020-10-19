package com.prueba.bitbox.util;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import com.prueba.bitbox.model.Role;

import com.prueba.bitbox.model.User;
import com.prueba.bitbox.repository.PriceReductionRepository;

import com.prueba.bitbox.repository.UserRepository;
import com.prueba.bitbox.security.enums.RoleName;
import com.prueba.bitbox.service.RoleServiceImpl;

@Component
public class CreateAdminUser implements CommandLineRunner {
	
	@Autowired
	RoleServiceImpl roleService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PriceReductionRepository priceReductionRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		if(userRepository.existsByUserName("admin")) {
			System.out.println("No es necesario insertar usuario de prueba.");
		}else {
			Role rolAdmin = new Role(RoleName.ROLE_ADMIN);
			Role rolUser = new Role(RoleName.ROLE_USER);
			roleService.save(rolAdmin);
			roleService.save(rolUser);
			
			User user =  new User("admin", passwordEncoder.encode("admin"));
			Set<Role> roles = new HashSet<>();
			roles.add(roleService.getByRoleName(RoleName.ROLE_USER));
			roles.add(roleService.getByRoleName(RoleName.ROLE_ADMIN));
			user.setRoles(roles);
			userRepository.save(user);
	     }
		
		
	}

}
