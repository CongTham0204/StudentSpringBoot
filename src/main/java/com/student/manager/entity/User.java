package com.student.manager.entity;
 

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
@Entity
@Table(name = "users")
public class User {
 
    private String username;
    private String password;
    
    @OneToMany( mappedBy="user",fetch = FetchType.EAGER , cascade = CascadeType.ALL )
    public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	private boolean enabled;
    private Student student;
    private List<UserRole> userRoles = new ArrayList<UserRole>();
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_Id")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Id
    @Column(name = "Username", length = 36, nullable = false)
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    @Column(name = "Password", nullable = false)
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    @Column(name = "enabled", nullable = false)
    public boolean isEnabled() {
        return enabled;
    }
 
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
 
}