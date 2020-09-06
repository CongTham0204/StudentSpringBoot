package com.student.manager.authentication;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.student.manager.entity.Student;
import com.student.manager.entity.User;
import com.student.manager.entity.UserRole;
import com.student.manager.service.UserService;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User userInfo = userService.findUserInfo(username);

		if (userInfo == null) {
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}

		List<UserRole> roles = userInfo.getUserRoles();
		List<String> userRoles = new ArrayList<String>();
		
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (roles != null) {
			for (UserRole role : roles) {
				// ROLE_USER, ROLE_ADMIN,..
				String userRole = "ROLE_" + role.getUserRole();
				GrantedAuthority authority = new SimpleGrantedAuthority(userRole);
				grantList.add(authority);
				
				userRoles.add(userRole);

			}
		}

		CurrentUser currentUser = new CurrentUser(userInfo.getUsername(), //
				userInfo.getPassword(), grantList);

		Student student = userInfo.getStudent();
		if (student == null) {
			throw new UsernameNotFoundException("User " + username + " did not connect to any student");
		}

		currentUser.setIdStudent(student.getId());

		currentUser.setUserRoles(userRoles);

		return currentUser;

	}



}