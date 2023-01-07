package com.qut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qut.entity.DorMember;
import com.qut.entity.PageBean;
import com.qut.entity.User;
import com.qut.utils.DbUtils;
import com.qut.utils.DbcpUtils;

public class UserDaoImpl implements IUserDao {

	private Connection con;
	private PreparedStatement pstm;
	ResultSet rs;
	
	@Override
	public boolean addUser(User u) {

		try {
			boolean flag = false;
			con = DbUtils.getCon();
			con.setAutoCommit(false);
			String str = "insert into 用户信息表(userid,userpwd,username,usergender,usernumber,role) values(?,?,?,?,?,?)";
			pstm = con.prepareStatement(str);
			pstm.setObject(1,u.getUserid());
			pstm.setObject(2,u.getUserpwd());
			pstm.setObject(3,u.getUsername());
			pstm.setObject(4,u.getUsergender());
			pstm.setObject(5,u.getUsernumber());
			pstm.setObject(6,u.getRole());
			boolean f1 = pstm.executeUpdate()>0;
			
			str ="insert into 宿舍成员表(memberid,membername,dormitoryid,record) values(?,?,?,?)";
			pstm = con.prepareStatement(str);
			pstm.setObject(1,u.getUserid());
			pstm.setObject(2,u.getUsername());
			pstm.setObject(3,"612");
			pstm.setObject(4,"0");
			boolean f2 = pstm.executeUpdate()>0;
			flag = f1&&f2;
			if(flag)
				con.commit();
			return flag;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
	}

	@Override
	public boolean del(int userid) {
		try {
			con = DbUtils.getCon();
			String str = "delete from 用户信息表 where userid=?";
			pstm = con.prepareStatement(str);
			pstm.setObject(1,userid);
			int x = pstm.executeUpdate();
			pstm.close();
			con.close();
			
			return x>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User queryByIdPwd(int userid, String userpwd) {
		try {
			con = DbUtils.getCon();
			String str = "select * from 用户信息表 where userid = ? and userpwd = ? ";
			pstm = con.prepareStatement(str);
			pstm.setObject(1, userid);
			pstm.setObject(2, userpwd);
			
			User u = null;
			rs = pstm.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setUserid(userid);
				u.setUserpwd(userpwd);
				u.setUsername(rs.getString("username"));
				u.setUsergender(rs.getString("usergender"));
				u.setUsernumber(rs.getInt("usernumber"));
				u.setRole(rs.getInt("role"));
			}
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User queryByIdNameNumber(int userid, String username, int usernumber) {
		try {
			con = DbUtils.getCon();
			String str = "select * from 用户信息表 where userid = ? and username = ? and usernumber=?";
			pstm = con.prepareStatement(str);
			pstm.setObject(1, userid);
			pstm.setObject(2, username);
			pstm.setObject(3, usernumber);
			User u = null;
			rs = pstm.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setUserid(userid);
				u.setUsername(username);
				u.setUsernumber(usernumber);
			}
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean changePwd(User u) {
		try {
			con = DbUtils.getCon();
			String str = "update 用户信息表 set userpwd=?where userid = ? and username=? and usernumber=?";
			pstm = con.prepareStatement(str);
			pstm.setObject(1,u.getUserpwd() );
			pstm.setObject(2,u.getUserid() );
			pstm.setObject(3,u.getUsername() );
			pstm.setObject(4,u.getUsernumber() );
			int x = pstm.executeUpdate();
			pstm.close();
			con.close();
			
			return x>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PageBean<User> queryAll(String pageNo) {
		PageBean<User> pageBean = new PageBean<>();
		pageBean.setTotalCount(getTotalCount());
		int no = Integer.parseInt(pageNo);
		if(no<1)
			no = 1;
		else if(no>pageBean.getTotalPage())
			no = pageBean.getTotalPage();
		pageBean.setCurrentPage(no);

		try {
			con = DbUtils.getCon();
			String sql = " select * from 用户信息表 limit ?,? ";
			pstm = con.prepareStatement(sql);	
			pstm.setObject(1, pageBean.getStartNum());
			pstm.setObject(2, pageBean.getPageSize());			
			rs = pstm.executeQuery();			
			List<User> users = new ArrayList<>();
			while(rs.next()) {				
				User u = new User();
				u.setUserid(rs.getInt("userid"));
				u.setUsername(rs.getString("username"));
				u.setUserpwd(rs.getString("userpwd"));
				u.setUsername(rs.getString("username"));
				u.setUsernumber(rs.getInt("usernumber"));
				u.setRole(rs.getInt("role"));
				users.add(u);
			}
			pageBean.setPageData(users);
			
			con.close();
			pstm.close();
			rs.close();
			return pageBean;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getTotalCount(){
		try {
			con = DbUtils.getCon();
			String sql = " select count(*) from 用户信息表  " ;
			pstm = con.prepareStatement(sql);		
			int count = 0;
			rs = pstm.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);				
			}
			con.close();
			pstm.close();
			rs.close();
			return count;					
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean update(User u) {
		try {
			con = DbUtils.getCon();
			String str = "update 用户信息表 set userpwd=?,usernumber=?,username=?,usergender=?,role=? where userid = ?";
			pstm = con.prepareStatement(str);
			pstm.setObject(1,u.getUserpwd() );
			pstm.setObject(2,u.getUsernumber() );
			pstm.setObject(3,u.getUsername() );
			pstm.setObject(4,u.getUsergender() );
			pstm.setObject(5,u.getRole() );
			pstm.setObject(6,u.getUserid() );
			int x = pstm.executeUpdate();
			pstm.close();
			con.close();
			
			return x>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PageBean<DorMember> checkinqueryAll(String pageNo) {
		PageBean<DorMember> pageBean = new PageBean<>();
		pageBean.setTotalCount(getCount());
		int no = Integer.parseInt(pageNo);
		if(no<1)
			no = 1;
		else if(no>pageBean.getTotalPage())
			no = pageBean.getTotalPage();
		pageBean.setCurrentPage(no);

		try {
			con = DbUtils.getCon();
			String sql = " select * from 宿舍成员表 limit ?,? ";
			pstm = con.prepareStatement(sql);	
			pstm.setObject(1, pageBean.getStartNum());
			pstm.setObject(2, pageBean.getPageSize());			
			rs = pstm.executeQuery();			
			List<DorMember> dormember = new ArrayList<>();
			while(rs.next()) {				
				DorMember d = new DorMember();
				d.setMemberid(rs.getInt("memberid"));
				d.setMembername(rs.getString("membername"));
				d.setDormitoryid(rs.getInt("dormitoryid"));
				d.setRecord(rs.getInt("record"));
				dormember.add(d);
			}
			pageBean.setPageData(dormember);
			
			con.close();
			pstm.close();
			rs.close();
			return pageBean;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int getCount(){
		try {
			con = DbUtils.getCon();
			String sql = " select count(*) from 宿舍成员表  " ;
			pstm = con.prepareStatement(sql);		
			int count = 0;
			rs = pstm.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);				
			}
			con.close();
			pstm.close();
			rs.close();
			return count;					
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean kaoqin(int memberid) {
		try {
			con = DbUtils.getCon();
			String str = "update 宿舍成员表 set record=? where memberid = ?";
			pstm = con.prepareStatement(str);
			pstm.setObject(1,"1");
			pstm.setObject(2,memberid);
			int x = pstm.executeUpdate();
			pstm.close();
			con.close();
			
			return x>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean queqin(int memberid) {
		try {
			con = DbUtils.getCon();
			String str = "update 宿舍成员表 set record=? where memberid = ?";
			pstm = con.prepareStatement(str);
			pstm.setObject(1,"0");
			pstm.setObject(2,memberid);
			int x = pstm.executeUpdate();
			pstm.close();
			con.close();
			
			return x>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public DorMember checkrecord(int memberid) {
		try {
			con = DbUtils.getCon();
			String str = "select * from 宿舍成员表 where memberid = ?";
			pstm = con.prepareStatement(str);
			pstm.setObject(1, memberid);
			DorMember d = null;
			rs = pstm.executeQuery();
			while(rs.next()) {
				d = new DorMember();
				d.setMemberid(memberid);
				d.setDormitoryid(rs.getInt("dormitoryid"));
				d.setMembername(rs.getString("membername"));
				d.setRecord(rs.getInt("record"));
			}
			return d;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<DorMember> queryrecord(int memberid) {
		try {
			con = DbUtils.getCon();
			String str = "select * from 宿舍成员表 where memberid = ?";
			pstm = con.prepareStatement(str);
			pstm.setObject(1, memberid);
			DorMember d = null;
			rs = pstm.executeQuery();
			List<DorMember> l = new ArrayList<>();
			while(rs.next()) {				 
				 d = new DorMember();
				 d.setMemberid(rs.getInt("memberid"));
				 d.setMembername(rs.getString("membername"));
				 d.setDormitoryid(rs.getInt("dormitoryid"));
				 d.setRecord(rs.getInt("record"));
				 l.add(d);
			}
			
			rs.close();
		 	pstm.close();
		 	con.close();
		 	
			return l;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
}
