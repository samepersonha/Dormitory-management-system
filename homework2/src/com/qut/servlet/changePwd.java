package com.qut.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qut.dao.IUserDao;
import com.qut.dao.UserDaoImpl;
import com.qut.entity.User;
import com.qut.service.IUserService;
import com.qut.service.UserServiceImpl;

/**
 * Servlet implementation class changePwd
 */
@WebServlet("/changePwd")
public class changePwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changePwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String userid1 = request.getParameter("userid");
		String username = request.getParameter("username");
		String usernumber1 = request.getParameter("usernumber");
		String userpwd = request.getParameter("userpwd");
		String repwd = request.getParameter("repwd");
		int userid= Integer.parseInt(userid1);
		int usernumber= Integer.parseInt(usernumber1);
		
		if(userpwd.equals(repwd)) {
			IUserService as = new UserServiceImpl();
			User u = null;
			u = new User();
			u.setUserid(userid);
			u.setUsername(username);
			u.setUsernumber(usernumber);
			u.setUserpwd(userpwd);
			as.changePwd(u);
			response.getWriter().write("成功！");
		}else {
			response.getWriter().write("两次密码不一致");
			request.getRequestDispatcher("changePwd.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
