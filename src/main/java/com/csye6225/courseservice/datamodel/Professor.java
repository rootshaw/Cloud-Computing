package com.csye6225.courseservice.datamodel;

public class Professor {
	private String id;
	private String firstName;
	private String lastName;
	private String department;
	private String professorId;
	private String joiningDate;

	public Professor() {

	}

	public Professor(String professorId, String firstName, String lastName, String department, String joiningDate) {
		this.professorId = professorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.joiningDate = joiningDate;
		this.id = Math.abs((professorId + joiningDate).hashCode()) + "";
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getProfessorId() {
		return professorId;
	}

	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ProfId=" + getProfessorId() + ", firstName=" + getFirstName() + ", department=" + getDepartment()
				+ ", joiningDate=" + getJoiningDate();
	}
}
