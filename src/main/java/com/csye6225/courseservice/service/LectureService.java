package com.csye6225.courseservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.csye6225.courseservice.datamodel.Course;
import com.csye6225.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.courseservice.datamodel.Lecture;

public class LectureService {
	static private HashMap<Long, Lecture> lectures_Map = InMemoryDatabase.getLectureDB();

	// get all lectures
	public List<Lecture> getAllLectures() {
		List<Lecture> list = new ArrayList<>();
		list.addAll(lectures_Map.values());
		return list;
	}

	// get all lectures by course Id
	public List<Lecture> getLecturesByCourse(long courseId) {
		Course course = InMemoryDatabase.getCourseDB().get(courseId);
		if (course == null) return null;
		List<Lecture> list = new ArrayList<>();
		List<Lecture> lecListByCourse = course.getLectures();
		for (Lecture lec : lecListByCourse) {
			list.add(lec);
		}
		return list;
	}

	// add a new lecture
	public void addLecture() {
		long id = lectures_Map.size() + 1;
		Lecture lecture = new Lecture(id);
		lectures_Map.put(id, lecture);
	}

	public Lecture addLecture(Lecture lecture) {
		long nextId = lectures_Map.size() + 1;
		lecture.setId(nextId);
		lectures_Map.put(nextId, lecture);
		return lecture;
	}

	// add lecture material
	public List<String> addMaterailToLecture(long lectureId, String content) {
		Lecture lecture = lectures_Map.get(lectureId);
		if (lecture == null) return null;
		lecture.getMaterials().add(content);
		return lecture.getMaterials();
	}

	// get specific lecture
	public Lecture getLecture(long id) {
		return lectures_Map.get(id);
	}

	// delete specific lecture
	public Lecture deleteLecture(long id) {
		Lecture lecture = lectures_Map.get(id);
		if (lecture == null) return null;
		lectures_Map.remove(id);
		return lecture;
	}

	// update specific lecture
	public Lecture updateLectureInformation(long id, Lecture lecture) {
		if (lectures_Map.containsKey(lecture.getId())) lectures_Map.remove(lecture.getId());
		lecture.setId(id);
		lectures_Map.put(id, lecture);
		return lecture;
	}
}
