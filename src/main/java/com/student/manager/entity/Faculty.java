package com.student.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty {
	@Id
	@Column(name = "id", length = 10)
	private String idF;
	@Column(name = "name")
	private String nameF;
	

	public String getIdF() {
		return idF;
	}
	
	public void setIdF(String idF) {
		this.idF = idF;
	}

	public String getNameF() {
		return nameF;
	}

	public void setNameF(String nameF) {
		this.nameF = nameF;
	}

}
