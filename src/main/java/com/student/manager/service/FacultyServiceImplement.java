package com.student.manager.service;

import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.manager.dto.FacultyDto;
import com.student.manager.entity.Faculty;
import com.student.manager.repository.FacultyRepository;

@Service
public class FacultyServiceImplement implements FacultyService {

	@Autowired
	FacultyRepository facultyRepository;

	public FacultyDto addFaculty(FacultyDto facultyDto) throws Exception {

		Faculty facultyid = facultyRepository.findByIdF(facultyDto.getIdFaculty());
		if (facultyid == null) {
			Faculty faculty = new Faculty();
			faculty.setIdF(facultyDto.getIdFaculty());
			faculty.setNameF(facultyDto.getNameF());
			facultyRepository.save(faculty);

			facultyDto = new FacultyDto();
			facultyDto.setIdFaculty(faculty.getIdF());
			facultyDto.setNameF(faculty.getNameF());
				return facultyDto;
		}
		return null;

	}

	public FacultyDto getFaculty(String MaKhoa) throws SQLException {
		Faculty faculty = facultyRepository.findByIdF(MaKhoa);
		FacultyDto facultyDto = new FacultyDto();
		facultyDto.setIdFaculty(faculty.getIdF());
		facultyDto.setNameF(faculty.getNameF());

		return facultyDto;
	}

}
