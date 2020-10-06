package com.prueba.bitbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.bitbox.model.User;
import com.prueba.bitbox.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getUserById(Integer id) {
		return userRepository.getOne(id);
	}
	
}
