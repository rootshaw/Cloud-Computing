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

import com.csye6225.courseservice.datamodel.Professor;
import com.csye6225.courseservice.service.ProfessorsService;

//.. /webapi/myresource
@Path("professors")
public class ProfessorsResource {

	private ProfessorsService profService = new ProfessorsService();

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Professor> getProfessors() {
		return profService.getAllProfessors();
	}

	@GET
	@Path("/{department}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Professor> getProfessorsByDeparment(@QueryParam("department") String department) {
		if (department == null) {
			return profService.getAllProfessors();
		}
		return profService.getProfessorsByDepartment(department);
	}

	@GET
	@Path("/professor/{professorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Professor getProfessor(@PathParam("professorId") String profId) {
		System.out.println("Professor Resource: Looking for: " + profId);
		return profService.getProfessor(profId);
	}

	@DELETE
	@Path("/professor/{professorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Professor deleteProfessor(@PathParam("professorId") long profId) {
		return profService.deleteProfessor(profId);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Professor addProfessor(Professor prof) {
		return profService.addProfessor(prof.getFirstName(), prof.getLastName(), prof.getDepartment(),
				prof.getJoiningDate());
	}

	@PUT
	@Path("/{professorId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Professor updateProfessor(@PathParam("professorId") long profId, Professor prof) {
		return profService.updateProfessorInformation(profId + "", prof);
	}
}
