package com.csye6225.courseservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.csye6225.courseservice.datamodel.Course;
import com.csye6225.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.courseservice.datamodel.Lecture;
import com.csye6225.courseservice.datamodel.Student;

public class CourseService {
	static private HashMap<Long, Course> course_Map = InMemoryDatabase.getCourseDB();

	// get all courses
	public List<Course> getAllCourses() {
		List<Course> list = new ArrayList<>();
		list.addAll(course_Map.values());
		return list;
	}

	// add a new course
	public Course addCourse(Course course) {
		if (course_Map.get(course.getCourseId()) != null)
			return null;
		course_Map.put(course.getCourseId(), course);
		return course;
	}

	// update course id
	public Course updateCourseId(long courseId, Course course) {
		if (course_Map.get(course.getCourseId()) == null)
			return null;
		course_Map.remove(course.getCourseId());
		course.setCourseId(courseId);
		course_Map.put(courseId, course);
		return course;
	}

	// search a course by Id
	public Course searchCourse(long courseId) {
		return course_Map.get(courseId);
	}

	// add a student to course by id
	public Student addStudentToCourse(long courseId, Student student) {
		Course course = course_Map.get(courseId);
		if (course.getStudents().contains(student))
			return null;
		course_Map.get(courseId).getStudents().add(student);
		course_Map.put(courseId, course);
		return student;
	}

	// add a lecture to course
	public Lecture addLectureToCourse(long courseId, Lecture lecture) {
		Course course = course_Map.get(courseId);
		if (course.getLectures().contains(lecture))
			return null;
		course.addLectures(lecture);
		course_Map.put(courseId, course);
		return lecture;
	}

	// delete a course by id
	public Course deleteCourse(long courseId) {
		Course deletedCourse = course_Map.get(courseId);
		if (deletedCourse == null)
			return null;
		course_Map.remove(courseId);
		return deletedCourse;
	}

	// delete a student in a course by id
	public Student deleteStudent(long courseId, long studentId) {
		Student student = InMemoryDatabase.getStudentDB().get(studentId);
		Course course = course_Map.get(courseId);
		if (course == null)
			return null;
		if (!course.getStudents().contains(student))
			return null;
		course.getStudents().remove(student);
		course_Map.put(courseId, course);
		return student;
	}

	// delete a lecture in a course by id
	public Lecture deleteLecture(long courseId, long lectureId) {
		Lecture lecture = InMemoryDatabase.getLectureDB().get(lectureId);
		Course course = course_Map.get(courseId);
		if (course == null)
			return null;
		if (course.getLectures().contains(lecture)) {
			course.getLectures().remove(lecture);
			course_Map.put(courseId, course);
			return lecture;
		}
		return null;
	}

}
