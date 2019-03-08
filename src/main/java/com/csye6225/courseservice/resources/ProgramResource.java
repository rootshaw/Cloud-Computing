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
import javax.ws.rs.core.MediaType;

import com.csye6225.courseservice.datamodel.Program;
import com.csye6225.courseservice.service.ProgramService;

@Path("programs")
public class ProgramResource {

	private ProgramService programService = new ProgramService();

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Program> getAllPrograms() {
		return programService.getAllPrograms();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Program addProgram(Program program) {
		return programService.addProgram(program);
	}

	@GET
	@Path("/{programName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Program searchProgram(@PathParam("programName") String name) {
		return programService.getProgram(name);
	}

	@PUT
	@Path("/{programName}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Program updateProgram(@PathParam("programName") String name, Program program) {
		return programService.updateProgramInformation(name, program);
	}

	@DELETE
	@Path("/{programName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Program deleteProgram(@PathParam("programName") String name) {
		return programService.deleteProgram(name);
	}

//	@GET
//	@Path("/{programName}/courses")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Course> getCoursesByProgram(@QueryParam("programName") String programName) {
//		return programService.getCoursesByProgram(programName);
//	}
//
//	@DELETE
//	@Path("/{programName}/{courseId}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Program deleteCourseInProgram(@PathParam("courseId") long courseId,
//			@PathParam("programName") String programName) {
//		return programService.deleteCourse(courseId, programName);
//	}
}
