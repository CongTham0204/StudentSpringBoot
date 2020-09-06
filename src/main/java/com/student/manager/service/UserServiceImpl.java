package com.student.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.manager.entity.User;
import com.student.manager.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	public User findUserInfo(String username) {
		
		return userRepository.findByUsername(username);
		
	}
	

}
