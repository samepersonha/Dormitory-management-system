package com.qut.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qut.dao.IUserDao;
import com.qut.dao.UserDaoImpl;
import com.qut.entity.DorMember;
import com.qut.entity.PageBean;
import com.qut.entity.User;
import com.qut.service.IUserService;
import com.qut.service.UserServiceImpl;

/**
 * Servlet implementation class checkinList
 */
@WebServlet("/checkinList")
public class checkinList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkinList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		IUserService is = new UserServiceImpl();
		
		String page = request.getParameter("page");
		if(page==null || page.equals("")) page="1";	
		PageBean<DorMember> dormember = is.checkinqueryAll(page);
		request.setAttribute("dormember", dormember);
//		List<User> list = is.queryUser();
//		System.out.println(list);
//		request.getSession().setAttribute("list", list);
		request.getRequestDispatcher("manage/checkin.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
