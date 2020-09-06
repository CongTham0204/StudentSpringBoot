package com.student.manager.controller;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.manager.dto.SubjectDto;
import com.student.manager.dto.SubjectDtoPage;
import com.student.manager.service.SubjectService;

@RestController
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public List<SubjectDto> search(@RequestBody SubjectDto subjectDto) throws SQLException {

		return subjectService.searchName(subjectDto.getNameSubject());

	}

	@RequestMapping(value = "/createSubject", method = RequestMethod.POST)
	
	public SubjectDto createSubject(@RequestBody SubjectDto subjectDto) throws SQLException {

		return subjectService.createSubject(subjectDto);

	}

	@RequestMapping(value = "/getListSubject", method = RequestMethod.GET)
	
	public SubjectDtoPage getListSubject(@RequestParam(name = "pageNumber") int pageNumber,
			@RequestParam(name = "pageSize") int pageSize) throws SQLException {

		return subjectService.getListSubject(pageNumber, pageSize);

	}

}