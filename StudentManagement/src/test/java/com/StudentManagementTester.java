package com;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class StudentManagementTester
{
	 public static void main(String[] args) 
	 {		 
		 studentManagementApplicationTester(JUnitCore.runClasses(StudentApplicationTest.class),"StudentApplicationTest");
		 studentManagementApplicationTester(JUnitCore.runClasses(StudentControllerTest.class),"StudentControllerTest");
	 }

	 private static void studentManagementApplicationTester(Result runClasses,String testClassName) 
	 {
	     Result result = runClasses;
	     System.out.println("Testing status for Class: "+testClassName);
	      for (Failure failure : result.getFailures()) 
	      {
	         System.out.println(failure.toString());
	      }
	      System.out.println(result.wasSuccessful());	
	 }
}
