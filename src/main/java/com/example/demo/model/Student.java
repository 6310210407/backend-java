package com.example.demo.model;

public class Student {

	private Integer studentID;
	private String Name;
	private String Email;
	public Integer getStudentID() {
		return studentID;
	}
	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Student(Integer studentID, String name, String email) {
		super();
		this.studentID = studentID;
		Name = name;
		Email = email;
	}
}
	
	