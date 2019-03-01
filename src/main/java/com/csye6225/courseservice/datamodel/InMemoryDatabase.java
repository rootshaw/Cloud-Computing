package com.csye6225.courseservice.datamodel;

import java.util.HashMap;

public class InMemoryDatabase {

	private static HashMap<Long, Professor> professorDB = new HashMap<>();
	private static HashMap<Long, Student> studentDB = new HashMap<>();
	private static HashMap<String, Course> courseDB = new HashMap<>();
	private static HashMap<Integer, Lecture> lectureDB = new HashMap<>();
	private static HashMap<String, Program> programDB = new HashMap<>();

	public static HashMap<Long, Professor> getProfessorDB() {
		return professorDB;
	}

	public static HashMap<Long, Student> getStudentDB() {
		return studentDB;
	}

	public static HashMap<String, Course> getCourseDB() {
		return courseDB;
	}

	public static HashMap<Integer, Lecture> getLectureDB() {
		return lectureDB;
	}

	public static HashMap<String, Program> getProgramDB() {
		return programDB;
	}

}
