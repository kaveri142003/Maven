package com.jbk;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class classroom {
	@Id
	private int clsid;
	private String clsname;
	private int clscapacity;
	public int getClsid() {
		return clsid;
	}
	public void setClsid(int clsid) {
		this.clsid = clsid;
	}
	public String getClsname() {
		return clsname;
	}
	public void setClsname(String clsname) {
		this.clsname = clsname;
	}
	public int getClscapacity() {
		return clscapacity;
	}
	public void setClscapacity(int clscapacity) {
		this.clscapacity = clscapacity;
	}
	@Override
	public String toString() {
		return "classroom [clsid=" + clsid + ", clsname=" + clsname + ", clscapacity=" + clscapacity + "]";
	}
	public classroom() {
		super();
	}
	public classroom(int clsid) {
		super();
		this.clsid = clsid;
	}
	
	
}
