package com.student.manager.service;

import java.util.List;

import com.student.manager.entity.User;
import com.student.manager.entity.UserRole;




public interface RoleService {
     List<UserRole> findByUser(User user);
}
