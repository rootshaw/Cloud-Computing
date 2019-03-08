package com.csye6225.courseservice.datamodel;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Course {
	private String courseName;
	private long courseId;
	private Student teachingAssistant;
	private Professor professor;
	private String board;
	private String roster;
	private List<Lecture> lectures;
	private List<Student> students;
	
	@JsonCreator
	public Course(@JsonProperty("courseName")String courseName, @JsonProperty("id")long id) {
		this.courseName = courseName;
		this.courseId = id;
		this.teachingAssistant = null;
		this.professor = null;
		this.board = "";
		this.roster = "";
		this.lectures = new ArrayList<>();
		this.students = new ArrayList<>();
	}

	public Course(String courseName, long id, Student teachingAssistant, Professor professor) {
		this.courseName = courseName;
		this.courseId = id;
		this.teachingAssistant = teachingAssistant;
		this.professor = professor;
		this.board = "";
		this.roster = "";
		this.lectures = new ArrayList<>();
		this.students = new ArrayList<>();
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(long id) {
		this.courseId = id;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Student teachingAssistant() {
		return teachingAssistant;
	}

	public void setTeachingAssistant(Student teachingAssistant) {
		this.teachingAssistant = teachingAssistant;
	}

	public List<Lecture> getLectures() {
		return lectures;
	}

	public void addLectures(Lecture lecture) {
		lectures.add(lecture);
	}

	public void setLectures(List<Lecture> lectures) {
		this.lectures = lectures;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getRoster() {
		return roster;
	}

	public void setRoster(String roster) {
		this.roster = roster;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course Name:" + getCourseName() + " ,Course Id " + getCourseId();
	}
}
