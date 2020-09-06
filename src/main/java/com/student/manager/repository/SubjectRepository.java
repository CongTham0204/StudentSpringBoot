package com.student.manager.repository;




import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.student.manager.entity.Subject;

public interface SubjectRepository extends PagingAndSortingRepository<Subject, String>{
	List<Subject> findByNameSubjectContainingIgnoreCase(String name);
	
	Subject findByIdSubject(String idSubject);
	
	
	Page<Subject> findAll(Pageable pageable);

}
