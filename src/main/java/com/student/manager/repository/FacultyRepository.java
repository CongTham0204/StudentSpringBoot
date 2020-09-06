package com.student.manager.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.student.manager.entity.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, String>{
	Faculty findByIdF(String id);
}