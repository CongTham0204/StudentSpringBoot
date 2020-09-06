package com.student.manager.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.student.manager.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	Student findById(int id);
	
}
