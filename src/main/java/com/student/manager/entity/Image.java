package com.student.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;







@Entity
@Table(name = "image")
public class Image {
	
	private int MSV;
	
	private byte[] bytes;
	
	
	
	

	@Id
	@Column(name = "student_Id")
	public int getMSV() {
		return MSV;
	}
	
	public void setMSV(int mSV) {
		MSV = mSV;
	}
	@Lob
	@Column(name ="bytes", columnDefinition = "BLOB")
	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
	

}
