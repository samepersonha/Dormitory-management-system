package com.qut.service;

import java.util.List;

import com.qut.entity.DorMember;
import com.qut.entity.PageBean;
import com.qut.entity.User;

public interface IUserService {
	
	boolean addUser(User u);
	
	boolean del(int userid);
	
	User queryByIdPwd(int userid, String userpwd);
	
	User queryByIdNameNumber(int userid, String username,int usernumber);
	
	boolean changePwd(User u);
	
	public PageBean<User> queryAll(String pageNo);

	boolean update(User u);
	
	public PageBean<DorMember> checkinqueryAll(String pageNo);
	
	boolean kaoqin(int memberid);
	
	boolean queqin(int memberid);
	
	DorMember checkrecord(int memberid);
	
	List<DorMember> queryrecord(int memberid);
}
