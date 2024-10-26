package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.Department;

@Remote
public interface DepartmentService 
{
	public String addDepartmen(Department dept);
	public List<Department> viewAllDepartments();
}
