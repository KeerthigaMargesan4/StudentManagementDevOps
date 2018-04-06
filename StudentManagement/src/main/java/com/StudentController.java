package com;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController 
{
	public static final String SUCCESS="Success";	
	
	@Resource
	StudentService studentService; 
	@RequestMapping("/")
	public String home() 
	{
		return "home";
	}	
	@RequestMapping("/login")
	public String login() 
	{
		return "login";
	}
	@RequestMapping("/register")
	public String register() 
	{
		return "register";
	}
	
	@RequestMapping("/registerStudent")
	public String registerStudent(StudentRegister student,Model model) throws ClassNotFoundException, SQLException
	{
		String status=studentService.addStudent(student);
		String viewPage="registerFailed";
		if(status.equals(SUCCESS))
		{	
		model.addAttribute("stud",student);
		viewPage="registerSuccess";
		}
		return viewPage;
	}
	
	@RequestMapping("/loginStudent")
	public String loginStudent(StudentRegister student,Model model) throws ClassNotFoundException, SQLException
	{
		String status=studentService.signinStudent(student);
		String viewPage="loginFailed";
		if(status.equals(SUCCESS))
		{	
			model.addAttribute("stud",student);
			viewPage="loginSuccess";
		}
		return viewPage;		
	}
}
