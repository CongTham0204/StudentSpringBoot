package com.student.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.manager.entity.Image;

public interface ImageRepository extends JpaRepository<Image,Integer> {
	
	

	
}
