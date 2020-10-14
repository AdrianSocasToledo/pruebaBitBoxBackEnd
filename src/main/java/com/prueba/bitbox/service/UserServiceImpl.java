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
		return userRepository.findById(id).get();
	}

	@Override
	public User getUserByUserName(String userName) {
	
		return userRepository.findByUserName(userName).get();
	}

	@Override
	public boolean existsByUserName(String userName) {
		return userRepository.existsByUserName(userName);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
		
	}
	
	public void delete(String name) {
		User user = userRepository.findByUserName(name).get();
		userRepository.delete(user);
	}
	
}
