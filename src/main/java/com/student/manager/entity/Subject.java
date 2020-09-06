package com.student.manager.entity;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "subjects")
public class Subject {
	@Id
	@Column(name = "idSubject", length = 10)
	private String idSubject;

	@ManyToMany(mappedBy = "subjects" ,fetch=FetchType.EAGER)
	private Set<Student> students= new HashSet<Student>();

	public String getIdSubject() {
		return idSubject;
	}

	public void setIdSubject(String idSubject) {
		this.idSubject = idSubject;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
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

	@Column(name = "nameSubject")
	private String nameSubject;

	@Column(name = "stopTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date stopTime;

	public Date getStopTime() {
		return stopTime;
	}

	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Column(name = "nameTeacher")
	private String nameTeacher;

	@Column(name = "startTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;

	@Column(name = "numberSeats")
	private int numberSeats;

}
