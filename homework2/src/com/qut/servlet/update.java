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
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String userid1 = (String)request.getSession().getAttribute("userid");
		int userid= Integer.parseInt(userid1);
		String userpwd = request.getParameter("userpwd");
		System.out.println(userpwd);
		String repwd = request.getParameter("repwd");
		String username = request.getParameter("username");
		String usergender = request.getParameter("usergender");
		String role1 = request.getParameter("role");
		String usernumber1 = request.getParameter("usernumber");
		int usernumber= Integer.parseInt(usernumber1);
		int role= 0;
		
		IUserService ud = new UserServiceImpl();
		
		if(userpwd.equals(repwd)) {
			User u = null;
			u = new User();
			u.setUserid(userid);
			u.setUserpwd(userpwd);
			u.setUsername(username);
			u.setUsergender(usergender);
			u.setUsernumber(usernumber);
			if(role1.equals("舍员")) {
				role=0;
			}else if(role1.equals("舍长")){
				role=1;
			}else if(role1.equals("管理员")){
				role=2;
			}else {
				role=0;
			}
			u.setRole(role);
			ud.update(u);
			response.getWriter().write("成功！");
			}else {
				response.getWriter().write("两次密码不一致");
				request.getRequestDispatcher("reg.jsp").forward(request,response);
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
