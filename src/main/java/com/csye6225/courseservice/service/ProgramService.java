package com.csye6225.courseservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.csye6225.courseservice.datamodel.Course;
import com.csye6225.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.courseservice.datamodel.Program;

public class ProgramService {
	private HashMap<String, Program> pro_Map = InMemoryDatabase.getProgramDB();

	// get all programs
	public List<Program> getAllPrograms() {
		List<Program> list = new ArrayList<>();
		list.addAll(pro_Map.values());
		return list;
	}

	// add a program
	public void addProgram(String name, List<Course> courses) {
		Program program = new Program(name, courses);
		pro_Map.put(name, program);
	}

	public Program addProgram(Program program) {
		String name = program.getName();
		pro_Map.put(name, program);
		return program;
	}

	// add a course to program
	public void addCourseToProgram(String courseId, String programName) {
		pro_Map.get(programName).getCourses().add(new Course(courseId));
	}

	// get a program by name
	public Program getProgram(String name) {
		return pro_Map.get(name);
	}

	// delete a program
	public Program deleteProgram(String name) {
		Program deletedProgram = pro_Map.get(name);
		pro_Map.remove(name);
		return deletedProgram;
	}

	// delete a course in a program
	public Program deleteCourseInProgram(String courseId, String programName) {
		Program program = pro_Map.get(programName);
		List<Course> courses = program.getCourses();
		courses.remove(InMemoryDatabase.getCourseDB().get(courseId));
		pro_Map.put(programName, program);
		return program;
	}

	// update a program
	public Program updateProgramInformation(String name, Program program) {
		program.setName(name);
		pro_Map.put(name, program);
		return program;
	}
}
