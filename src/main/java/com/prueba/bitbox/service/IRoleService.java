package com.prueba.bitbox.service;

import com.prueba.bitbox.model.Role;
import com.prueba.bitbox.security.enums.RoleName;

public interface IRoleService {
	
	Role getByRoleName(RoleName roleName);
	void save(Role role);
}
