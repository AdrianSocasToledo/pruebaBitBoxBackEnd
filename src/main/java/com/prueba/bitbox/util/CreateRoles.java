package com.prueba.bitbox.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.prueba.bitbox.model.Role;
import com.prueba.bitbox.security.enums.RoleName;
import com.prueba.bitbox.service.RoleServiceImpl;

@Component
public class CreateRoles implements CommandLineRunner {
	
	@Autowired
	RoleServiceImpl roleService;
	
	@Override
	public void run(String... args) throws Exception {
		/**Role rolAdmin = new Role(RoleName.ROLE_ADMIN);
        Role rolUser = new Role(RoleName.ROLE_USER);
        roleService.save(rolAdmin);
        roleService.save(rolUser);
		**/
	}

}
