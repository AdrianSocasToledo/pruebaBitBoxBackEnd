package com.prueba.bitbox.service;

import com.prueba.bitbox.model.User;

public interface IUserService {
	
	User getUserById(Integer id);
	User getUserByUserName( String userName);
	boolean existsByUserName(String userName);
	void save(User user);
	
	

}
