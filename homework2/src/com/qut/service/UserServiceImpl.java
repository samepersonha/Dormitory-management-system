package com.qut.service;

import java.util.List;

import com.qut.dao.IUserDao;
import com.qut.dao.UserDaoImpl;
import com.qut.entity.DorMember;
import com.qut.entity.PageBean;
import com.qut.entity.User;

public class UserServiceImpl implements IUserService {

	IUserDao iu = new UserDaoImpl();
	
	@Override
	public boolean addUser(User u) {

		return iu.addUser(u);
	}

	@Override
	public boolean del(int userid) {

		return iu.del(userid);
	}

	@Override
	public User queryByIdPwd(int userid, String userpwd) {

		return iu.queryByIdPwd(userid, userpwd);
	}

	@Override
	public User queryByIdNameNumber(int userid, String username, int usernumber) {

		return iu.queryByIdNameNumber(userid, username, usernumber);
	}

	@Override
	public boolean changePwd(User u) {

		return iu.changePwd(u);
	}

	@Override
	public PageBean<User> queryAll(String pageNo) {

		return iu.queryAll(pageNo);
	}

	@Override
	public boolean update(User u) {

		return iu.update(u);
	}

	@Override
	public PageBean<DorMember> checkinqueryAll(String pageNo) {

		return iu.checkinqueryAll(pageNo);
	}

	@Override
	public boolean kaoqin(int memberid) {

		return iu.kaoqin(memberid);
	}

	@Override
	public boolean queqin(int memberid) {

		return iu.queqin(memberid);
	}

	@Override
	public DorMember checkrecord(int memberid) {

		return iu.checkrecord(memberid);
	}

	@Override
	public List<DorMember> queryrecord(int memberid) {

		return iu.queryrecord(memberid);
	}

}
