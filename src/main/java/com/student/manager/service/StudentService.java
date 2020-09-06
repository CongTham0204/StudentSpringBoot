package com.student.manager.service;

import java.sql.SQLException;

import java.util.List;

import com.student.manager.dto.StudentDto;
import com.student.manager.dto.SubjectDto;


public interface StudentService {
	StudentDto create(StudentDto studentDto) throws SQLException;

	StudentDto update(StudentDto studentDto);

	boolean delete(int id);

	StudentDto get(String name);

	List<StudentDto> getListStudent();

	boolean registerSubject(String idSubject);
	
	List<SubjectDto> getRegisterSubject();

}
