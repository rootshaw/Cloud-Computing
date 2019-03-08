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

import com.csye6225.courseservice.datamodel.Lecture;
import com.csye6225.courseservice.service.LectureService;

@Path("lectures")
public class LectureResource {
	private LectureService lectureService = new LectureService();

	@GET
	@Path("/courses/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Lecture> getLecturesByCourse(@QueryParam("courseId") long courseId) {
		return lectureService.getLecturesByCourse(courseId);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Lecture addLecture(Lecture lecture) {
		return lectureService.addLecture(lecture);
	}

	@GET
	@Path("/{lectureId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Lecture getLecture(@PathParam("lectureId") long lectureId) {
		return lectureService.getLecture(lectureId);
	}

	@PUT
	@Path("/{lectureId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Lecture updateCourse(@PathParam("lectureId") long id, Lecture lecture) {
		return lectureService.updateLectureInformation(id, lecture);
	}

	@DELETE
	@Path("/{lectureId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Lecture deleteLecture(@PathParam("lectureId") long lectureId) {
		return lectureService.deleteLecture(lectureId);
	}
}
