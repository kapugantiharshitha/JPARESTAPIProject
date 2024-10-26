package com.klef.ep.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id //primary key = unique + not null
	@Column(name = "dept_id")
	private int id;
	@Column(name = "dept_name", length = 30, nullable = false)
	private String name;
	@Column(name = "dept_location", length = 30, nullable = false)
	private String location;
	@Column(name = "dept_hod", length = 30, nullable = false)
	private String hod;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getHod() {
		return hod;
	}
	public void setHod(String hod) {
		this.hod = hod;
	}
}
