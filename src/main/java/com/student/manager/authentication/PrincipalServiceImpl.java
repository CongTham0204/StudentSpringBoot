package com.student.manager.authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class PrincipalServiceImpl implements PrincipalService {

	public CurrentUser getCurrentUser() {
		return (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	}

}
