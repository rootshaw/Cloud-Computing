package com.csye6225.courseservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.csye6225.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.courseservice.datamodel.Professor;

public class ProfessorsService {
	static private HashMap<Long, Professor> prof_Map = InMemoryDatabase.getProfessorDB();

	public ProfessorsService() {
	}

	// Getting a list of all professor
	// GET "/webapi/professors"
	public List<Professor> getAllProfessors() {
		// Getting the list
		ArrayList<Professor> list = new ArrayList<>();
		for (Professor prof : prof_Map.values()) {
			list.add(prof);
		}
		return list;
	}

	// Adding a professor
	public Professor addProfessor(String firstName, String lastName, String department, String joiningDate) {
		// Next Id
		long nextAvailableId = prof_Map.size() + 1;

		// Create a Professor Object
		Professor prof = new Professor(firstName + lastName, firstName, lastName, department, joiningDate,
				nextAvailableId);

		prof_Map.put(nextAvailableId, prof);
		return prof;
	}

	// Getting One Professor
	public Professor getProfessor(Long profId) {
		// Simple HashKey Load
		Professor prof = prof_Map.get(profId);
		if (prof == null) return null;
		return prof;
	}

	// Deleting a professor
	public Professor deleteProfessor(Long id) {
		Professor deletedProfDetails = prof_Map.get(id);
		prof_Map.remove(id);
		return deletedProfDetails;
	}

	// Updating Professor Info
	public Professor updateProfessorInformation(Long id, Professor prof) {
		Professor oldProfObject = prof_Map.get(id);
		if (oldProfObject == null) return null;
		prof_Map.put(id, prof);
		prof.setId(id);
		prof.setProfessorId(prof.getFirstName() + prof.getLastName());
		return prof;
	}

	// Get professors in a department
	public List<Professor> getProfessorsByDepartment(String department) {
		// Getting the list
		ArrayList<Professor> list = new ArrayList<>();
		for (Professor prof : prof_Map.values()) {
			if (prof.getDepartment().equals(department)) {
				list.add(prof);
			}
		}
		return list;
	}

}
