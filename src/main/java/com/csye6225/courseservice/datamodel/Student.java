package com.csye6225.courseservice.datamodel;

import java.util.List;

public class Student {
    String name;
    long id;
    String image;
    List<Course> enrolledCourses;
    String programName;

    public Student(){

    }

    public Student(String name, String image, List<Course> enrolledCourses, String programName) {
        this.name = name;
        this.id = Math.abs((name + image).hashCode());
        this.image = image;
        this.enrolledCourses = enrolledCourses;
        this.programName = programName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    @Override
	public String toString() {
		return "Name :" + getName() + ",id : " + getId() + ", programName" + getProgramName();
	}
}
