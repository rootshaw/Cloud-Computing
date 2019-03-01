package com.csye6225.courseservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.csye6225.courseservice.datamodel.Course;
import com.csye6225.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.courseservice.datamodel.Lecture;

public class LectureService {
	static HashMap<Integer, Lecture> lec_Map = InMemoryDatabase.getLectureDB();

	// get all lectures
	public List<Lecture> getAllLectures() {
		List<Lecture> list = new ArrayList<>();
		list.addAll(lec_Map.values());
		return list;
	}

	// get all lectures of a course
	public List<Lecture> getLecturesByCourse(String courseId) {
		Course course = CourseService.course_Map.get(courseId);
		List<Lecture> list = new ArrayList<>();
		List<Lecture> lecListByCourse = course.getLectures();
		for (Lecture lec : lecListByCourse) {
			list.add(lec);
		}
		return list;
	}

	// add a new lecture
	public void addLecture(String notes, List<String> materials) {
		int id = lec_Map.size() + 1;
		Lecture lecture = new Lecture(id, notes, materials);
		lec_Map.put(id, lecture);
	}

	public Lecture addLecture(Lecture lecture) {
		int nextId = lec_Map.size() + 1;
		lecture.setId(nextId);
		lec_Map.put(nextId, lecture);
		return lecture;
	}

	// add lecture material
	public List<String> addMaterailToLecture(int lecId, String content) {
		Lecture lecture = lec_Map.get(lecId);
		lecture.getMaterials().add(content);
		lec_Map.put(lecId, lecture);
		return lecture.getMaterials();
	}

	// get specific lecture
	public Lecture getLecture(int id) {
		return lec_Map.get(id);
	}

	// delete specific lecture
	public Lecture deleteLecture(int id) {
		Lecture lecture = lec_Map.get(id);
		lec_Map.remove(id);
		return lecture;
	}

	// update specific lecture
	public Lecture updateLectureInformation(int id, Lecture lecture) {
		lecture.setId(id);
		lec_Map.put(id, lecture);
		return lecture;
	}
}
