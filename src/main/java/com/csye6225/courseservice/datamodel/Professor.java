package com.csye6225.courseservice.datamodel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Professor {
	private long id;
	private String firstName;
	private String lastName;
	private String department;
	private String professorId;
	private String joiningDate;

	@JsonCreator
	public Professor(@JsonProperty("professorId") String professorId, @JsonProperty("firstName") String firstName,
			@JsonProperty("lastName") String lastName, @JsonProperty("department") String department,
			@JsonProperty("joiningDate") String joiningDate, @JsonProperty("id") long id) {
		this.professorId = professorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.joiningDate = joiningDate;
		this.id = id;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ProfId=" + getProfessorId() + ", firstName=" + getFirstName() + ", department=" + getDepartment()
				+ ", joiningDate=" + getJoiningDate();
	}
}
