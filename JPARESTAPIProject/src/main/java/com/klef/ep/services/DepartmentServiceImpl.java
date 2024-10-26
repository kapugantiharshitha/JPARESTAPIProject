package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.Department;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class DepartmentServiceImpl implements DepartmentService
{
	public String addDepartmen(Department dept) 
	{
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	   	  EntityManager em = emf.createEntityManager();
	   	  
	   	  em.getTransaction().begin();
	   	  em.persist(dept);     // insert operation
	   	  em.getTransaction().commit();
	   	  
	   	  em.close();
	   	  emf.close();
	   	  
	   	  return "Department Added Successfully";
	}

	public List<Department> viewAllDepartments()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
      	EntityManager em = emf.createEntityManager();
      	  
        em.getTransaction().begin();
         
        Query qry = em.createQuery(" select d from Department d "); // d is an alias of Department class
        List<Department> deptlist = qry.getResultList();
        
         
        em.close();
   	    emf.close();
   	    
   	    return deptlist;
	}

}
