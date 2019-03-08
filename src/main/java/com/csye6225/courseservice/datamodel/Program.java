package com.csye6225.courseservice.datamodel;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Program {
	private String programName;
	private List<Course> courses;

	@JsonCreator
	public Program(@JsonProperty("programName")String programName) {
		this.programName = programName;
		courses = new ArrayList<>();
	}

	public Program(String programName, List<Course> courses) {
		this.programName = programName;
		this.courses = courses;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "ProgramName = " + getProgramName();
	}
}
