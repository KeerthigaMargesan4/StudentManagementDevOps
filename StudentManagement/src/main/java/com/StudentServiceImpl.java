package com;

import java.sql.SQLException;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceImpl implements StudentService
{
	@Resource
	StudentDAO studentDAO;	
	@Override
	public String addStudent(StudentRegister student) throws ClassNotFoundException, SQLException 
	{
		return studentDAO.addStudent(student);
	}
	@Override
	public String signinStudent(StudentRegister student) throws ClassNotFoundException, SQLException 
	{		
		return studentDAO.signinStudent(student);
	}
}
