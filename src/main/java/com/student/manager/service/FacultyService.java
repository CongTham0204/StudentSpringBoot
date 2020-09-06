package com.student.manager.service;

import java.sql.SQLException;

import com.student.manager.dto.FacultyDto;


public interface FacultyService {
	FacultyDto  addFaculty(FacultyDto facultyDto) throws SQLException, Exception;

	FacultyDto getFaculty(String MaKhoa) throws SQLException;
}
