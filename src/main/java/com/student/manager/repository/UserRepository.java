package com.student.manager.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.student.manager.entity.User;




public interface UserRepository extends JpaRepository<User, String> {
 
  
    User findByUsername(String username);
 
}