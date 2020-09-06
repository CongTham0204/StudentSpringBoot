package com.student.manager.service;

import java.util.List;

import com.student.manager.dto.SubjectDto;
import com.student.manager.dto.SubjectDtoPage;

public interface SubjectService {
	List<SubjectDto> searchName(String name);

	SubjectDto createSubject(SubjectDto subjectDto);

	SubjectDtoPage getListSubject(int pageNumber, int pageSize);

}
