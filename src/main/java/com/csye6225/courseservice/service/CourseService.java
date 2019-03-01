package com.csye6225.courseservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.csye6225.courseservice.datamodel.Course;
import com.csye6225.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.courseservice.datamodel.Lecture;
import com.csye6225.courseservice.datamodel.Program;
import com.csye6225.courseservice.datamodel.Student;

public class CourseService {
	static HashMap<String, Course> course_Map = InMemoryDatabase.getCourseDB();

	// get all courses
	public List<Course> getAllCourses() {
		List<Course> list = new ArrayList<>();
		list.addAll(course_Map.values());
		return list;
	}

	// get all courses of a program
	public List<Course> getCoursesByProgram(Program program) {
		return program.getCourses();
	}

	// add a course
	public Course addCourse(Course course) {
		course_Map.put(course.getId(), course);
		return course;
	}

	// add a lecture to course
	public Lecture addLectureToCourse(String courseId, Lecture lecture) {
		Course course = course_Map.get(courseId);
		course.addLectures(lecture);
		course_Map.put(courseId, course);
		return lecture;
	}

	// add a student to course
	public Student addStudentToCourse(String courseId, Student student) {
		Course course = course_Map.get(courseId);
		course_Map.get(courseId).getStudents().add(student);
		course_Map.put(courseId, course);
		return student;
	}

	// get a course
	public Course getCourse(String courseId) {
		return course_Map.get(courseId);
	}

	// delete a course
	public Course deleteCourse(String courseId) {
		Course deletedCourse = course_Map.get(courseId);
		course_Map.remove(courseId);
		return deletedCourse;
	}

	// delete a student in a course
	public Student deleteStudent(String courseId, long studentId) {
		Student student = InMemoryDatabase.getStudentDB().get(studentId);
		Course course = course_Map.get(courseId);
		course.getStudents().remove(student);
		course_Map.put(courseId, course);
		return student;
	}

	// delete a lecture in a course
	public Lecture deleteLecture(String courseId, int lecId) {
		Lecture lecture = LectureService.lec_Map.get(lecId);
		Course course = course_Map.get(courseId);
		course.getLectures().remove(lecture);
		course_Map.put(courseId, course);
		return lecture;
	}

	// update a course
	public Course updateCourseInformation(String courseId, Course course) {
		course.setId(courseId);
		course_Map.put(courseId, course);
		return course;
	}
}
