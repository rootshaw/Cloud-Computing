package com.csye6225.courseservice.datamodel;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Lecture {
	private long id;
	private List<String> notes;
	private List<String> materials;

	@JsonCreator
	public Lecture(@JsonProperty("id")long id) {
		this.id = id;
		this.notes = new ArrayList<>();
		this.materials = new ArrayList<>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<String> getNotes() {
		return notes;
	}

	public void setNotes(List<String> notes) {
		this.notes = notes;
	}

	public List<String> getMaterials() {
		return materials;
	}

	public void setMaterials(List<String> materials) {
		this.materials = materials;
	}

	@Override
	public String toString() {
		return "Id :" + getId();
	}
}
