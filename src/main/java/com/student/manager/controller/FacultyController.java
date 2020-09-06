package com.student.manager.controller;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.manager.dto.FacultyDto;
import com.student.manager.service.FacultyService;

@RestController
public class FacultyController {
	@Autowired
	FacultyService facultyService;

	@RequestMapping(value = "/facultys", method = RequestMethod.POST)
	@ResponseBody
	public FacultyDto addFaculty(@RequestBody FacultyDto facultyDto) throws Exception {

		return facultyService.addFaculty(facultyDto);

	}
	
	
	@RequestMapping(value = "/facultys/getFaculty", method = RequestMethod.POST)
	@ResponseBody
	public FacultyDto getFaculty( @RequestBody FacultyDto facultyDto) throws SQLException {
		return facultyService.getFaculty(facultyDto.getIdFaculty());
	}
	
	
}
