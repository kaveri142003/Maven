package com.jbk;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class user {
	@Id
	private int id;
	private String name;
	private long salary;
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
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	public user() {
		super();
	}
	public user(int id) {
		super();
		this.id = id;
	}
	
	
}
