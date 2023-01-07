package com.qut.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qut.dao.IUserDao;
import com.qut.dao.UserDaoImpl;
import com.qut.entity.User;
import com.qut.service.IUserService;
import com.qut.service.UserServiceImpl;


/**
 * Servlet implementation class Myservlet1
 */
@WebServlet("/mylogin")
public class Myservlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Myservlet1() {
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
		String userpwd = request.getParameter("userpwd");
		String checkcode1 = request.getParameter("chkcode");
		
		int userid= Integer.parseInt(userid1);
		
		String checkcode2 = (String)request.getSession().getAttribute("checkcode");

		if(checkcode1.equals(checkcode2)) {
			IUserService as = new UserServiceImpl();
			User u = as.queryByIdPwd(userid, userpwd);
			
			if(u==null) {
				response.getWriter().write("用户名密码错误！");
			}else {
				String autolog = request.getParameter("autolog");
				
				Cookie c1 = new Cookie("userid", userid1);
				Cookie c2 = new Cookie("userpwd", userpwd);
//				System.out.println(autolog);
				if(autolog.equals("on")) {
					c1.setMaxAge(60*60*24*30);
					c2.setMaxAge(60*60*24*30);
				}else{
					c1.setMaxAge(0);
					c2.setMaxAge(0);
				}
				response.addCookie(c1);
				response.addCookie(c2);
				request.getSession().setAttribute("userid", userid);
//				System.out.println(u.getRole());
//				System.out.println(u.getUsername());
				if(u.getRole()==0) {
					request.getRequestDispatcher("WEB-INF/StudentMain.jsp").forward(request, response);
				}else if(u.getRole()==1) {
					request.getRequestDispatcher("WEB-INF/LeaderMain.jsp").forward(request, response);
				}else if(u.getRole()==2) {
					request.getRequestDispatcher("WEB-INF/AdminMain.jsp").forward(request, response);
				}
			}
		}else {
			response.getWriter().write("验证码错误！");
			
		}
		
//		System.out.println(a);
		
//		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
