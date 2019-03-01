package com.csye6225.courseservice.datamodel;

public class Note {
	String note;

	public Note(String note) {
		this.note = note;
	}

	public void updateNote(String newNote) {
		this.note = newNote;
	}

	public String getNote() {
		return this.note;
	}

	@Override
	public String toString() {
		return "Note :" + getNote();
	}
}