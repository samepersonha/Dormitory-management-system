package com.qut.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qut.dao.IUserDao;
import com.qut.dao.UserDaoImpl;
import com.qut.service.IUserService;
import com.qut.service.UserServiceImpl;

/**
 * Servlet implementation class changerecord
 */
@WebServlet("/changerecord")
public class changerecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changerecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		String memberid1 = request.getParameter("memberid");
		int memberid= Integer.parseInt(memberid1);
		System.out.println(type);
		IUserService ud = new UserServiceImpl();
		if(type.equals("kaoqin")) {
			ud.kaoqin(memberid);
		}else if(type.equals("queqin")) {
			ud.queqin(memberid);
		}
		request.getRequestDispatcher("checkinList").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
