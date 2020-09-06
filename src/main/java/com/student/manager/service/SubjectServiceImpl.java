package com.student.manager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.student.manager.dto.SubjectDto;
import com.student.manager.dto.SubjectDtoPage;
import com.student.manager.entity.Subject;
import com.student.manager.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectRepository subjectRepository;

	public List<SubjectDto> searchName(String name) {
		List<Subject> subjects = subjectRepository.findByNameSubjectContainingIgnoreCase(name);
		List<SubjectDto> listSubject = new ArrayList<SubjectDto>();
		if (subjects != null) {
			for (Subject subject : subjects) {
				SubjectDto subjectDto = new SubjectDto();
				subjectDto.setIdSubject(subject.getIdSubject());
				subjectDto.setNameSubject(subject.getNameSubject());
				subjectDto.setNameTeacher(subject.getNameTeacher());
				subjectDto.setStartTime(subject.getStartTime());
				subjectDto.setStopTime(subject.getStopTime());
				subjectDto.setNumberSeats(subject.getNumberSeats());
				listSubject.add(subjectDto);

			}

		}
		return listSubject;
	}

	public SubjectDto createSubject(SubjectDto subjectDto) {

		Subject idSubject = subjectRepository.findByIdSubject(subjectDto.getIdSubject());
		if(subjectDto.getIdSubject()=="") return null;
		if (idSubject == null) {
			Subject subject = new Subject();
			subject.setIdSubject(subjectDto.getIdSubject());
			subject.setNameSubject(subjectDto.getNameSubject());
			subject.setNameTeacher(subjectDto.getNameTeacher());
			subject.setNumberSeats(subjectDto.getNumberSeats());
			subject.setStartTime(subjectDto.getStartTime());
			subject.setStopTime(subjectDto.getStopTime());

			subjectRepository.save(subject);

			SubjectDto subDto = new SubjectDto();
			subDto.setIdSubject(subject.getIdSubject());
			subDto.setNameSubject(subject.getNameSubject());
			subDto.setNameTeacher(subject.getNameTeacher());
			subDto.setStartTime(subject.getStartTime());
			subDto.setStopTime(subject.getStopTime());
			subDto.setNumberSeats(subject.getNumberSeats());

			return subDto;
		}
		return null;
	}

	public SubjectDtoPage getListSubject(int pageNumber, int pageSize) {
		
		SubjectDtoPage subjectDtoPage = new SubjectDtoPage();
		Pageable pageable = PageRequest.of(pageNumber, pageSize);

		List<SubjectDto> listSubjectDto = new ArrayList<SubjectDto>();
		Page<Subject> page = subjectRepository.findAll(pageable);

		
		for (Subject subject : page.getContent()) {
			SubjectDto subjectDto = new SubjectDto();
			subjectDto.setIdSubject(subject.getIdSubject());
			subjectDto.setNameSubject(subject.getNameSubject());
			subjectDto.setNameTeacher(subject.getNameTeacher());
			subjectDto.setStartTime(subject.getStartTime());
			subjectDto.setStopTime(subject.getStopTime());
			subjectDto.setNumberSeats(subject.getNumberSeats());
			listSubjectDto.add(subjectDto);
		}
		
		subjectDtoPage.setTotalPage(page.getTotalPages());
		subjectDtoPage.setSubjectDtos(listSubjectDto);
		
		

		return subjectDtoPage;
	}
}
