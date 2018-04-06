package com;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class StudentManagementTester
{
	 public static void main(String[] args) 
	 {		 
		 studentManagementApplicationTester(JUnitCore.runClasses(StudentApplicationTest.class));
		 studentManagementApplicationTester(JUnitCore.runClasses(StudentControllerTest.class));
	 }

	 private static void studentManagementApplicationTester(Result runClasses) 
	 {
	     Result result = runClasses;	      
	      for (Failure failure : result.getFailures()) 
	      {
	         System.out.println(failure.toString());
	      }
	      System.out.println(result.wasSuccessful());	
	 }
}
