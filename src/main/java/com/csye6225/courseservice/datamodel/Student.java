package com.csye6225.courseservice.datamodel;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
	private String firstName;
	private String lastName;
	private long id;
	private String image;
	private List<Course> enrolledCourses;
	private String programName;

	@JsonCreator
	public Student(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName,
			@JsonProperty("id") long id, @JsonProperty("programName") String programName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.image = "";
		this.enrolledCourses = new ArrayList<>();
		this.programName = programName;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Course> getEnrolledCourses() {
		return enrolledCourses;
	}

	public void setEnrolledCourses(List<Course> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}
	
	public void enrollCourses(Course course) {
		this.enrolledCourses.add(course);
		course.getStudents().add(this);
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	@Override
	public String toString() {
		return "Name :" + getFirstName() + " " + getLastName() + ",id : " + getId() + ", programName"
				+ getProgramName();
	}
}
