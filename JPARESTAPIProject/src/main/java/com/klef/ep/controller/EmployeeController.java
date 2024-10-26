package com.klef.ep.controller;

import java.util.List;

import javax.ejb.EJB;
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

import com.klef.ep.models.Employee;
import com.klef.ep.services.EmployeeService;

@Path("empcrud")
public class EmployeeController 
{
	@EJB(lookup = "java:global/JPARESTAPIProject/EmployeeServiceImpl!com.klef.ep.services.EmployeeService")
	EmployeeService employeeService;
	
	@Path("insertemp")
	@POST // to add the data
	@Consumes(MediaType.APPLICATION_JSON) //input
	@Produces(MediaType.TEXT_PLAIN) //output
    public String addemp(Employee emp)
    {
    	return employeeService.addEmployee(emp);
    }
	

	@Path("updateemp")
	@PUT // to update the data
	@Consumes(MediaType.APPLICATION_JSON) //input
	@Produces(MediaType.TEXT_PLAIN) //output
	public String updateemp(Employee emp)
    {
    	return employeeService.updateEmployee(emp);
    }
	
	@Path("deleteemp/{id}")
	@DELETE  // to delete the data
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteemp(@PathParam("id") int eid)
	{
		return employeeService.deleteEmployee(eid);
	}
	
	@Path("viewallemps")
	@GET  // to display the data
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> viewallemp()
	{
		return employeeService.viewAllEmployees();
	}
	
	@Path("viewempbyid")
	@GET  // to display the data
	@Produces(MediaType.APPLICATION_JSON)
	public Employee viewempbyid(@QueryParam("id") int eid)
	{
		return employeeService.viewEmployeebyId(eid);
	}
}
