package com.qut.entity;

public class User {

	private int userid;
	private String userpwd;
	private String username;
	private String usergender;
	private int usernumber;
	private int role;
	
	
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsergender() {
		return usergender;
	}
	public void setUsergender(String usergender) {
		this.usergender = usergender;
	}
	public int getUsernumber() {
		return usernumber;
	}
	public void setUsernumber(int usernumber) {
		this.usernumber = usernumber;
	}
	
	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", userpwd=" + userpwd + ", username=" + username + ", usergender="
				+ usergender + ", usernumber=" + usernumber + ", role=" + role + "]";
	}
	
}
