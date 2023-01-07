package com.qut.entity;

public class DorMember {

	private int memberid;
	private String membername;
	private int dormitoryid;
	private int record;
	
	
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public int getDormitoryid() {
		return dormitoryid;
	}
	public void setDormitoryid(int dormitoryid) {
		this.dormitoryid = dormitoryid;
	}
	public int getRecord() {
		return record;
	}
	public void setRecord(int record) {
		this.record = record;
	}
	
	@Override
	public String toString() {
		return "DorMember [memberid=" + memberid + ", membername=" + membername + ", dormitoryid=" + dormitoryid
				+ ", record=" + record + "]";
	}
	
}
