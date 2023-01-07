package com.qut.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qut.dao.IUserDao;
import com.qut.dao.UserDaoImpl;
import com.qut.entity.DorMember;
import com.qut.service.IUserService;
import com.qut.service.UserServiceImpl;

/**
 * Servlet implementation class checkrecord
 */
@WebServlet("/checkrecord")
public class checkrecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkrecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Object userid1 = request.getSession().getAttribute("userid");
		int userid= Integer.parseInt(String.valueOf(userid1));
		
		System.out.println(userid);
		IUserService is = new UserServiceImpl();
		List<DorMember> l = is.queryrecord(userid);
		request.setAttribute("l",l);
		request.getRequestDispatcher("manage/checkRecord.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
