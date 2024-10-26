package com.klef.ep.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.klef.ep.models.Department;
import com.klef.ep.services.DepartmentService;

@Path("dept")
public class DepartmentController 
{
	@EJB(lookup = "java:global/JPARESTAPIProject/DepartmentServiceImpl!com.klef.ep.services.DepartmentService")
	
    DepartmentService departmentService;
	
	@Path("insertdept")
	@POST // to add the data
	@Consumes(MediaType.APPLICATION_JSON) //input
	@Produces(MediaType.TEXT_PLAIN) //output
    public String adddept(Department dept)
    {
	   return departmentService.addDepartmen(dept);
    }
	
	@Path("viewalldepts")
	@GET // to display the data
	@Produces(MediaType.APPLICATION_JSON) //output
    public List<Department> viewalldepts()
    {
	   return departmentService.viewAllDepartments();
    }
}
