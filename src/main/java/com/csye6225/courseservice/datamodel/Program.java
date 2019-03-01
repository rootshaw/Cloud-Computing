package com.csye6225.courseservice.datamodel;

import java.util.ArrayList;
import java.util.List;

public class Program {
	String name;
	List<Course> courses;

	public Program() {

	}

	public Program(String name) {
		this.name = name;
		courses = new ArrayList<>();
	}

	public Program(String name, List<Course> courses) {
		this.name = name;
		this.courses = courses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		String str = "ProgramName = " + getName() + " : ";
		if (courses.isEmpty()) {
			for (Course course : courses) {
				str += course.getName() + " ";
			}
		}
		return str;
	}
}
