package com.csye6225.courseservice.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.csye6225.courseservice.datamodel.Course;
import com.csye6225.courseservice.datamodel.Lecture;
import com.csye6225.courseservice.datamodel.Program;
import com.csye6225.courseservice.datamodel.Student;
import com.csye6225.courseservice.service.CourseService;

@Path("courses")
public class CourseResource {
	private CourseService courseService = new CourseService();

	@GET
	@Path("/{courseId}/program")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getCoursesByProgram(@QueryParam("program") Program program) {
		if (program == null) {
			return courseService.getAllCourses();
		} else {
			return courseService.getCoursesByProgram(program);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Course addCourse(Course course) {
		return courseService.addCourse(course);
	}

	@GET
	@Path("/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course getCourse(@PathParam("courseId") String courseId) {
		return courseService.getCourse(courseId);
	}

	@PUT
	@Path("/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course updateCourse(@PathParam("courseId") String courseId, Course course) {
		return courseService.updateCourseInformation(courseId, course);
	}

	@DELETE
	@Path("/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course deleteCourse(@PathParam("courseId") String courseId) {
		return courseService.deleteCourse(courseId);
	}

	@DELETE
	@Path("/{courseId}/student")
	@Produces(MediaType.APPLICATION_JSON)
	public Student deleteStudent(@PathParam("courseId") String courseId, @QueryParam("studentId") long studentId) {
		return courseService.deleteStudent(courseId, studentId);
	}

	@DELETE
	@Path("/{courseId}/lecture")
	@Produces(MediaType.APPLICATION_JSON)
	public Lecture deleteLecture(@PathParam("courseId") String courseId, @QueryParam("lecId") int lecId) {
		return courseService.deleteLecture(courseId, lecId);
	}
}
