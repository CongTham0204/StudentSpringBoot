package com.student.manager.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.student.manager.entity.User;
import com.student.manager.entity.UserRole;




public interface RoleRepository extends JpaRepository<UserRole, String> {
	
	List<UserRole> findByUser(User user);
	
	
	@Query(
			  value = "SELECT USER_ROLE FROM USER_ROLES   WHERE USERNAME =?", 
			  nativeQuery = true)
	List<String> findRolesByUserName(String userName);
	
	
	

}
