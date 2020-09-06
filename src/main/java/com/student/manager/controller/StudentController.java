package com.student.manager.controller;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.manager.dto.StudentDto;
import com.student.manager.dto.SubjectDto;
import com.student.manager.service.StudentService;
import com.student.manager.service.SubjectService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SubjectService subjectService;

	@RequestMapping(value = "/students", method = RequestMethod.POST)
	@ResponseBody
	public StudentDto create(@RequestBody StudentDto studentDto) throws SQLException {

		return studentService.create(studentDto);

	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	@ResponseBody
	public List<StudentDto> getListStudent() {
		return studentService.getListStudent();

	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteStudent(@PathVariable(value = "id") int id) {

		return studentService.delete(id);

	}

	@RequestMapping(value = "/students", method = RequestMethod.PUT)
	@ResponseBody
	public StudentDto update(@RequestBody StudentDto studentDto) {
		return studentService.update(studentDto);
	}
	
	@RequestMapping(value = "/regisSubjects", method = RequestMethod.GET)
	@ResponseBody
	public List<SubjectDto> getRegisSubjects() {
		return studentService.getRegisterSubject();
		
	}
	@RequestMapping(value = "/registerSubject/{id}", method = RequestMethod.POST)
	@ResponseBody
	public boolean registerSubject(@PathVariable("id") String id ) {
		return studentService.registerSubject(id);
		
	}
	

}
