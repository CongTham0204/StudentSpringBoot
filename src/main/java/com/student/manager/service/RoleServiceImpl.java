package com.student.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.manager.entity.User;
import com.student.manager.entity.UserRole;
import com.student.manager.repository.RoleRepository;


@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepository;
	public List<UserRole> findByUser(User user) {
		
		return roleRepository.findByUser(user);
	}

}
