package com.student.manager.dto;

import java.util.Collection;

import com.student.manager.entity.Subject;


public class StudentDto {
	private String name;
	private String sex;
	private int number;
	private int idStudent;
	private Collection<Subject> idSubject;

	private String idFaculty;


	public String getIdFaculty() {
		return idFaculty;
	}

	public void setIdFaculty(String idFaculty) {
		this.idFaculty = idFaculty;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public Collection<Subject> getIdSubject() {
		return idSubject;
	}

	public void setIdSubject(Collection<Subject> idSubject) {
		this.idSubject = idSubject;
	}

	
}
