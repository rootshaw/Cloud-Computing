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

import com.csye6225.courseservice.datamodel.Student;
import com.csye6225.courseservice.service.StudentService;

@Path("/students")
public class StudentResource {

	private StudentService studentService = new StudentService();

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

//	@GET
//	@Path("/{courseId}/all")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Student> getStudentsByCourse(@QueryParam("courseId") long courseId) {
//		return studentService.getStudentsByCourse(courseId);
//	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student addStudent(Student student) {
		return studentService.addStudent(student);
	}

	@GET
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student searchStudentbyId(@PathParam("studentId") long id) {
		return studentService.getStudent(id);
	}

	@DELETE
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student deleteStudentbyId(@PathParam("studentId") long id) {
		return studentService.deleteStudent(id);
	}

	@PUT
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student updateStudentId(@PathParam("studentId") long id, Student student) {
		return studentService.updateStudentId(id, student);
	}

}
