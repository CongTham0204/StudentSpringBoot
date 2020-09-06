package com.student.manager.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.Base64;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.student.manager.authentication.CurrentUser;
import com.student.manager.authentication.PrincipalService;
import com.student.manager.entity.Student;
import com.student.manager.repository.RoleRepository;
import com.student.manager.repository.StudentRepository;
import com.student.manager.service.ImageService;

@Controller
@Transactional
public class MainController {
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PrincipalService principalService;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	ImageService imageService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "This is welcome page!");
		return "loginPage";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model) {
		return "adminPage";
	}

	@RequestMapping(value = "/facultys", method = RequestMethod.GET)
	public String Faculty(Model model) {

		return "facultys";
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		return "loginPage";
	}

	@RequestMapping(value = "/buttons", method = RequestMethod.GET)
	public String addStudent(Model model) {

		return "buttonsAddStudent";
	}

	@RequestMapping(value = "/buttonsSubject", method = RequestMethod.GET)
	public String addSubject(Model model) {

		return "buttonSubject";
	}

	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal) {

		// Sau khi user login thanh cong se co principal
//		String userName = principal.getName();
//		List<String> userRoles = roleRepository.findRolesByUserName(userName);
//		boolean hasRolesAdmin = checkRoleAdmin(userRoles);
//		System.out.println("User Name: " + userName);

		Object currentUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (currentUser instanceof User) {
			currentUser = (User) currentUser;
			Set<GrantedAuthority> authorities = (Set<GrantedAuthority>) ((User) currentUser).getAuthorities();
			for (GrantedAuthority authority : authorities) {
				if ("ROLE_ADMIN".equals(authority.getAuthority())) {
					model.addAttribute("currentUser", ((User) currentUser));
					return "adminPage";

				}

			}

		}

		List<String> aaaa = ((CurrentUser) currentUser).getUserRoles();
		for (String bbb : aaaa) {
			if ("ROLE_ADMIN".equals(bbb)) {
				return "adminPage";
			}
		}

		int idStudent = principalService.getCurrentUser().getIdStudent();
		Student student = studentRepository.findById(idStudent);
		model.addAttribute("student", student);

		return "userInfoPage";

	}
//		

//		if (currentUser.checkRole("ROLE_ADMIN")) {
//			return "adminPage";
//		} else {
//			return "userInfoPage";
//		}
//
//	}

//	private boolean checkRoleAdmin(List<String> userRoles) {
//		for (String userRole : userRoles) {
//			if ("ADMIN".equalsIgnoreCase(userRole))
//				return true;
//
//		}
//		return false;
//	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			model.addAttribute("message",
					"Hi " + principal.getName() + "<br> You do not have permission to access this page!");
		} else {
			model.addAttribute("msg", "You do not have permission to access this page!");
		}
		return "403page";
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public String submit(@RequestParam("file") MultipartFile filep) throws IOException {

		imageService.saveImage(filep.getBytes());

		return Base64.getEncoder().encodeToString(filep.getBytes());
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
	@ResponseBody
	public String getImage() {
		return imageService.loadById();

	}

}