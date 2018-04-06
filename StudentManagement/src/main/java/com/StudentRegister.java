package com;

public class StudentRegister 
{
	public String firstName;
	public String lastName;
	public int age;
	public String department;
	public String year;
	public String email;
	public String password;
	public String confirmPassword;	
					
	public StudentRegister() {
		super();
	}
	public StudentRegister(String firstName, String lastName, int age, String department, String year, String email,
			String password, String confirmPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.department = department;
		this.year = year;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "'"+firstName+"','"+lastName+"',"+age+",'"+department+"','"+year+"','"+email+"','"+password+"','"+confirmPassword+"'";
		 
	}
}
