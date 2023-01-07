package com.qut.entity;

public class Class {
	
	private int classid;
	private String classname;
	
	
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	@Override
	public String toString() {
		return "Class [classid=" + classid + ", classname=" + classname + "]";
	}
	
	
	
}
