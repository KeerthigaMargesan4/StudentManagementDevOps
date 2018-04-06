package com;

import java.sql.SQLException;

public interface StudentDAO 
{
	String addStudent(StudentRegister student) throws ClassNotFoundException, SQLException;
	String signinStudent(StudentRegister student) throws ClassNotFoundException, SQLException;
}
