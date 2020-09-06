package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.student.manager.entity.Student;
import com.student.manager.repository.StudentRepository;
import com.student.manager.service.StudentService;

@SpringBootTest
public class TestStudentService {

	@Autowired
	StudentService studentService;

	@Autowired
	StudentRepository studentRepository;

	@BeforeEach
	public void setUp() {
		
		
	}

	@AfterEach
	public void destroy() {
		studentRepository.deleteAll();
	}

	

	@Test
	public void testFindById() {
		

	}

}
