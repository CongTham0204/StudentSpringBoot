package com.student.manager.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.manager.authentication.PrincipalService;
import com.student.manager.dto.StudentDto;
import com.student.manager.dto.SubjectDto;
import com.student.manager.entity.Faculty;
import com.student.manager.entity.Image;
import com.student.manager.entity.Student;
import com.student.manager.entity.Subject;
import com.student.manager.entity.User;
import com.student.manager.entity.UserRole;
import com.student.manager.repository.FacultyRepository;
import com.student.manager.repository.ImageRepository;
import com.student.manager.repository.RoleRepository;
import com.student.manager.repository.StudentRepository;
import com.student.manager.repository.SubjectRepository;
import com.student.manager.repository.UserRepository;

@Service
public class StudentServiceImplement implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	FacultyRepository facultyRepository;
	
	@Autowired
	ImageRepository imageRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	SubjectRepository subjectRepository;

	@Autowired
	private PrincipalService principalService;

	public StudentDto create(StudentDto studentDto) throws SQLException {
		Faculty faculty = facultyRepository.findByIdF(studentDto.getIdFaculty());
		Student studentid = studentRepository.findById(studentDto.getIdStudent());

		if (faculty != null && studentid == null) {
			Student student = new Student();
			student.setName(studentDto.getName());
			student.setId(studentDto.getIdStudent());
			student.setSex(studentDto.getSex());
			student.setFaculty(faculty);

			student = studentRepository.save(student);

			// creat user
			User user = new User();
			user.setUsername(student.getName());
			user.setPassword(String.valueOf(student.getId()));
			user.setStudent(student);

			UserRole userRole = new UserRole(); // cascad
			userRole.setUser(user);
			userRole.setUserRole("USER");

			List<UserRole> listUserRole = new ArrayList<UserRole>();
			listUserRole.add(userRole);

			user.setUserRoles(listUserRole);

			userRepository.save(user);

			studentDto = new StudentDto();
			studentDto.setIdStudent(student.getId());
			studentDto.setName(student.getName());
			studentDto.setSex(student.getSex());
			studentDto.setIdFaculty(faculty.getIdF());

			return studentDto;
		}

		return null;

	}

	public StudentDto update(StudentDto studentDto) {
		Student student = studentRepository.findById(studentDto.getIdStudent());
		
		if (student != null) {
			student.setId(studentDto.getIdStudent());
			student.setName(studentDto.getName());
			student.setSex(studentDto.getSex());
			studentRepository.save(student);

			studentDto = new StudentDto();
			studentDto.setIdStudent(student.getId());
			studentDto.setName(student.getName());
			studentDto.setSex(student.getSex());

			return studentDto;
		}
		return null;

	}

	public boolean delete(int id) {

		Student student = studentRepository.findById(id);
		if (student != null) {
			User user = student.getUser();
			
			if(user!=null) {
				List<UserRole> userRole = user.getUserRoles();
				for (UserRole userRoleDelete : userRole) {
					roleRepository.delete(userRoleDelete);
				}
				userRepository.delete(user);
			}
			
			
			
			
			Optional<Image> image = imageRepository.findById(id);
			if(image.isPresent()) {
			imageRepository.deleteById(image.get().getMSV());
			}
			
			studentRepository.delete(student);
			
			
			

			return true;
		}
		return false;

	}

	public StudentDto get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StudentDto> getListStudent() {

		List<StudentDto> listStudentDtos = new ArrayList<StudentDto>();

		List<Student> students = studentRepository.findAll();

		for (Student student : students) {
			StudentDto studentDto = new StudentDto();
			studentDto.setIdStudent(student.getId());
			studentDto.setName(student.getName());
			studentDto.setSex(student.getSex());
			studentDto.setIdFaculty(student.getFaculty().getIdF());
			listStudentDtos.add(studentDto);

		}
		return listStudentDtos;

	}

	@Transactional
	public boolean registerSubject(String idSubject) {
		int idStudent = principalService.getCurrentUser().getIdStudent();
		Student student = studentRepository.findById(idStudent);
		Subject subject = subjectRepository.findByIdSubject(idSubject);

		if (student != null && subject != null) {

			if (subject.getNumberSeats() == 0) {
				return false;
			}

			Set<Subject> setSubject = student.getSubjects();
			boolean checkIdSubject = setSubject.add(subject);
			if (!checkIdSubject) {
				return false;
			}
			subject.setNumberSeats(subject.getNumberSeats() - 1);
			subjectRepository.save(subject);
			studentRepository.save(student);

			return true;

		}

		return false;
	}

	public List<SubjectDto> getRegisterSubject() {
		int idSubjet = principalService.getCurrentUser().getIdStudent();
		Student student = studentRepository.findById(idSubjet);
		Set<Subject> listSubject = student.getSubjects();

		List<SubjectDto> listSubjectDto = new ArrayList<SubjectDto>();
		SubjectDto subjectDto;
		for (Subject subject : listSubject) {
			subjectDto = new SubjectDto();
			subjectDto.setIdSubject(subject.getIdSubject());
			subjectDto.setNameSubject(subject.getNameSubject());
			subjectDto.setNameTeacher(subject.getNameTeacher());
			subjectDto.setStartTime(subject.getStartTime());
			subjectDto.setStopTime(subject.getStopTime());
			subjectDto.setNumberSeats(subject.getNumberSeats());
			listSubjectDto.add(subjectDto);

		}
		return listSubjectDto;
	}

}
