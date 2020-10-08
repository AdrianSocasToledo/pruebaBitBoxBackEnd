package com.prueba.bitbox.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prueba.bitbox.model.User;
import com.prueba.bitbox.security.entity.MainUser;
import com.prueba.bitbox.service.UserServiceImpl;

@Service
public class UserDetailsServiceImpls implements IUserDetailsService {
	
	@Autowired
	UserServiceImpl userService;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		 User user = userService.getUserByUserName(userName);
	        return MainUser.build(user);
	}

}
