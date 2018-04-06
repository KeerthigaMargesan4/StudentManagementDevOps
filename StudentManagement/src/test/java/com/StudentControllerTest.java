package com;

import java.sql.Connection;
import java.sql.SQLException;

import static org.mockito.Mockito.*; 
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest 
{	 
	 @Spy 
	 @InjectMocks
	 StudentDAOImpl studentDAOImplTest;	 
	 StudentRegister student;
	 String db_file_name_prefix;
	 
	 @Before
	 public void setUp()
	 {					
		student = new StudentRegister("Kirthi", "M", 24, "ECE", "4","kirthi@gmail.com", "1234", "1234");		
		db_file_name_prefix="C:\\Users\\886758\\Documents\\M&S\\BP Align Workspace\\StudentManagement\\src\\main\\resources\\DataBase\\StudentDB\\database\\StudentDB.odb";		
	 }	 
	 @Test
	 public void testCreateConnection()
	 {
	  try{
		  	Connection con=studentDAOImplTest.createConnection(db_file_name_prefix);
			Assert.assertNotNull(con);
			if(con != null)
			{
				con.close();
			}
			verify(studentDAOImplTest).createConnection(db_file_name_prefix);						
		 }
	  catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
	 }
	 @Test
	 public void testRegisterStudent()
	 {
	  try{
			String status=studentDAOImplTest.addStudent(student);			
			Assert.assertEquals(status,"Success");	      
		    verify(studentDAOImplTest).addStudent(student);
		 }
	  catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}	      
	 }
	 @Test
	 public void testLoginStudent()
	 {
	  try{
			String status=studentDAOImplTest.signinStudent(student);			
			Assert.assertEquals(status,"Success");	      
		    verify(studentDAOImplTest).signinStudent(student);
		 }
	  catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}	      
	 }
}
