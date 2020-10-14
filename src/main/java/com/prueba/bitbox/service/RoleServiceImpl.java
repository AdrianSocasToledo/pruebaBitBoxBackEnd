package com.prueba.bitbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.bitbox.model.Role;
import com.prueba.bitbox.repository.RoleRepository;
import com.prueba.bitbox.security.enums.RoleName;

@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	RoleRepository roleRepository;
	
	
	@Override
	public Role getByRoleName(RoleName roleName) {
		return roleRepository.findByRoleName(roleName).get();
	}

	@Override
	public void save(Role role) {
		roleRepository.save(role);

	}

}
