package com.qut.entity;

public class Dormitory {

	private int classid;
	private int dormitoryid;
	private int leaderid;
	
	
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public int getDormitoryid() {
		return dormitoryid;
	}
	public void setDormitoryid(int dormitoryid) {
		this.dormitoryid = dormitoryid;
	}
	public int getLeaderid() {
		return leaderid;
	}
	public void setLeaderid(int leaderid) {
		this.leaderid = leaderid;
	}
	
	@Override
	public String toString() {
		return "Dormitory [classid=" + classid + ", dormitoryid=" + dormitoryid + ", leaderid=" + leaderid + "]";
	}
	
}
