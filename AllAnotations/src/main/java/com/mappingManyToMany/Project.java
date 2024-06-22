package com.mappingManyToMany;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	private int pid;
	@Column(name = "Project_Name")
	private String pname;

	// Here we use the set or list to assign the project
	// one project can assign to many employee
	@ManyToMany(mappedBy = "projects")
	private List<Employee> employee;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public Project(int pid, String pname, List<Employee> employee) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.employee = employee;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    
}
