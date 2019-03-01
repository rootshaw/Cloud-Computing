package com.csye6225.courseservice.datamodel;

import java.util.List;

public class Course {
	String name;
	String id;
	List<Lecture> lectures;
	String board;
	List<Long> roster;
	List<Student> students;
	Long taId;
	Long professorId;

	public Course() {

	}

	public Course(String id) {
		this.id = id;
	}

	public Course(String name, String id, List<Lecture> lectures, String board, List<Long> roster, List<Student> students,
			Long taId, Long professorId) {
		this.name = name;
		this.id = id;
		this.lectures = lectures;
		this.board = board;
		this.roster = roster;
		this.students = students;
		this.taId = taId;
		this.professorId = professorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
	}

	public Long getTaId() {
		return taId;
	}

	public void setTaId(Long taId) {
		this.taId = taId;
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

	public List<Long> getRoster() {
		return roster;
	}

	public void setRoster(List<Long> roster) {
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
		return "Course Name:" + getName() + " ,Course Id " + getId() + ",TA Id " + getTaId() + ",professor Id " + getProfessorId();
	}
}
