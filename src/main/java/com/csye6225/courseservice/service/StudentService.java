package com.csye6225.courseservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.csye6225.courseservice.datamodel.Course;
import com.csye6225.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.courseservice.datamodel.Student;

public class StudentService {

	static HashMap<Long, Student> student_Map = InMemoryDatabase.getStudentDB();

	// get all students
	public List<Student> getAllStudents() {
		List<Student> list = new ArrayList<>();
		list.addAll(student_Map.values());
		return list;
	}

	// get students in a program
	public List<Student> getStudentsByProgram(String programName) {
		ArrayList<Student> list = new ArrayList<>();
		for (Student stu : student_Map.values()) {
			if (stu.getProgramName().equals(programName)) {
				list.add(stu);
			}
		}
		return list;
	}

	// get students enrolled in a course
	public List<Student> getStudentsByCourse(long courseId) {
		List<Student> studentList = new ArrayList<>();
		Course course = InMemoryDatabase.getCourseDB().get(courseId);
		if (course == null)
			return studentList;
		for (Student student : course.getStudents()) {
			studentList.add(student);
		}
		return studentList;
	}

	public Student addStudent(Student student) {
		long nextAvailableId = student_Map.size() + 1;
		student.setId(nextAvailableId);
		student_Map.put(nextAvailableId, student);
		return student_Map.get(nextAvailableId);
	}

	// get a student by ID
	public Student getStudent(long id) {
		return student_Map.get(id);
	}

	// delete a student
	public Student deleteStudent(long id) {
		Student deletedStudent = student_Map.get(id);
		if (deletedStudent == null) return null;
		student_Map.remove(id);
		return deletedStudent;
	}

	// update a student
	public Student updateStudentId(long id, Student student) {
		student.setId(id);
		student_Map.put(id, student);
		return student;
	}

}
