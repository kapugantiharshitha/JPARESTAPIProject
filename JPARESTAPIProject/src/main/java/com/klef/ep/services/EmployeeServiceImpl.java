package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.Employee;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class EmployeeServiceImpl  implements EmployeeService
{
	public String addEmployee(Employee emp) 
	{
	  EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
   	  EntityManager em = emf.createEntityManager();
   	  
   	  em.getTransaction().begin();
   	  em.persist(emp);     // insert operation
   	  em.getTransaction().commit();
   	  
   	  em.close();
   	  emf.close();
   	  
   	  return "Record Inserted Successfully";
	}

	
	public String updateEmployee(Employee emp) 
	{
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    	  EntityManager em = emf.createEntityManager();
    	  
    	  em.getTransaction().begin();
    	  Employee e = em.find(Employee.class, emp.getId()); // fetching object based on ID
    	  e.setGender(emp.getGender());
    	  e.setSalary(emp.getSalary());
    	  e.setPassword(emp.getPassword());
          em.getTransaction().commit();
    	  
    	  em.close();
    	  emf.close();
    	  
    	  return "Record Updated Successfully";
    	  
	}

	@Override
	public String deleteEmployee(int eid) 
	{
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	   	  EntityManager em = emf.createEntityManager();
	   	  
	   	  em.getTransaction().begin();
		  Employee e = em.find(Employee.class, eid); // fetching object based on ID
	   	  em.remove(e);
	   	  em.getTransaction().commit();
	   	  
	   	  em.close();
		  emf.close();
		  
		  return "Record Deleted Successfully";
	}

	public List<Employee> viewAllEmployees() 
	{
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
      	 EntityManager em = emf.createEntityManager();
      	  
         em.getTransaction().begin();
         
         Query qry = em.createQuery("   select e from Employee e "); // e is an alias of Employee class
         List<Employee> emplist = qry.getResultList();
         
         em.close();
   	    emf.close();
   	    
   	    return emplist;
	}

	public Employee viewEmployeebyId(int eid) 
	{
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
       	  EntityManager em = emf.createEntityManager();
       	  
       	  em.getTransaction().begin();
    	  Employee e = em.find(Employee.class, eid); // fetching object based on ID
    	  em.getTransaction().commit();
    	  
    	  em.close();
    	  emf.close();
    	  
    	  return e;
	}

}
