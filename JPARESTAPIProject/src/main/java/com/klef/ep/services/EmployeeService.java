package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.Employee;

@Remote
public interface EmployeeService
{
	public String addEmployee(Employee emp);
	public String updateEmployee(Employee emp);
	public String deleteEmployee(int eid);
	public List<Employee> viewAllEmployees();
	public Employee viewEmployeebyId(int eid);
}
