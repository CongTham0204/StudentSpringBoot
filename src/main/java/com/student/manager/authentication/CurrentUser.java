package com.student.manager.authentication;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User {
	public CurrentUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	private List<String> userRoles;
	private Integer idStudent;

	public Integer getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Integer idStudent) {
		this.idStudent = idStudent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<String> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<String> userRoles) {
		this.userRoles = userRoles;
	}

	public boolean checkRole(String role) {
		for (String userRole : userRoles) {
			if (role.equals(userRole)) {
				return true;
			}

		}

		return false;

	}

}
