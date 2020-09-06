package com.student.manager.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SubjectDto {
	private String idSubject;
	private String nameSubject;
	private String nameTeacher;
	private Date startTime;
	private Date stopTime;
	
	
	private int numberSeats;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
	public Date getStopTime() {
		return stopTime;
	}

	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

	public String getIdSubject() {
		return idSubject;
	}

	public void setIdSubject(String idSubject) {
		this.idSubject = idSubject;
	}

	public String getNameSubject() {
		return nameSubject;
	}

	public void setNameSubject(String nameSubject) {
		this.nameSubject = nameSubject;
	}

	public String getNameTeacher() {
		return nameTeacher;
	}

	public void setNameTeacher(String nameTeacher) {
		this.nameTeacher = nameTeacher;
	}

	

	public int getNumberSeats() {
		return numberSeats;
	}

	public void setNumberSeats(int numberSeats) {
		this.numberSeats = numberSeats;
	}

}
