package com.csye6225.courseservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.csye6225.courseservice.datamodel.Course;
import com.csye6225.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.courseservice.datamodel.Program;

public class ProgramService {
	static private HashMap<String, Program> pro_Map = InMemoryDatabase.getProgramDB();

	// get all programs
	public List<Program> getAllPrograms() {
		List<Program> list = new ArrayList<>();
		list.addAll(pro_Map.values());
		return list;
	}

	// get all courses of a program
	public List<Course> getCoursesByProgram(String programName) {
		if (pro_Map.get(programName) == null)
			return null;
		return pro_Map.get(programName).getCourses();
	}

	// add a program
	public Program addProgram(Program program) {
		if (pro_Map.containsKey(program.getProgramName()))
			return null;
		String name = program.getProgramName();
		pro_Map.put(name, program);
		return program;
	}

	// add a course to program
	public void addCourseToProgram(Course course, String programName) {
		if (!pro_Map.containsKey(programName))
			return;
		pro_Map.get(programName).getCourses().add(course);
	}

	// get a program by name
	public Program getProgram(String name) {
		return pro_Map.get(name);
	}

	// delete a program
	public Program deleteProgram(String name) {
		Program deletedProgram = pro_Map.get(name);
		if (deletedProgram == null)
			return null;
		pro_Map.remove(name);
		return deletedProgram;
	}

	// delete a course in a program
	public Program deleteCourse(long courseId, String programName) {
		Program program = pro_Map.get(programName);
		if (program == null)
			return null;
		List<Course> courses = program.getCourses();
		Course toRemove = InMemoryDatabase.getCourseDB().get(courseId);
		if (toRemove == null)
			return null;
		courses.remove(toRemove);
		return program;
	}

	// update a program
	public Program updateProgramInformation(String name, Program program) {
		Program oldProgram = pro_Map.get(name);
		if (oldProgram == null)
			return null;
		pro_Map.put(name, program);
		program.setProgramName(name);
		return program;
	}
}
