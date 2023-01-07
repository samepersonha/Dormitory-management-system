<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
request.setCharacterEncoding("utf-8");
request.getSession().getAttribute("list");
String userid = new String (request.getParameter("userid").getBytes("ISO-8859-1"),"UTF-8");
session.setAttribute("userid",userid);
String username = new String (request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
String userpwd = new String (request.getParameter("userpwd").getBytes("ISO-8859-1"),"UTF-8");
String usernumber = new String (request.getParameter("usernumber").getBytes("ISO-8859-1"),"UTF-8");
session.setAttribute("username",username);
session.setAttribute("usernumber",usernumber);
session.setAttribute("userpwd",userpwd);
%>
<body>
	<h3 style="position:relative;left:20%">注册信息</h3><hr>
	<label style="position:relative;left:20%">注：标有<span style="color:red">*</span>处，均为必填项</label><br>
	<div style="position:relative;left:30%">
	<form action="../update" method="post">
		<h4 style="color:#F80">登录信息</h4><br>
			*学号：<input type="text" name="userid" value="${userid}"><br><br>
			*密码：<input type ="password" name="userpwd" value="${userpwd}">
			<label>不少于6位字符</label><br><br>
			*确认密码：<input type ="password" name="repwd">
			<label>请再次输入密码</label><br><br>			
	</div>
	<div style="position:relative;left:30%">
		<h4 style="color:#F80">详细信息</h4><br>
			*真实姓名：<input type="text" name="username" value="${username}"><br><br>
			*性别：<select name="usergender">
				<option>男</option>
				<option>女</option>
				</select><br><br>
			*证件类型：<select>
				<option>二代身份证</option>
				</select><br><br>
			*证件号码：<input type="text" name="usernumber" value="${usernumber}"><br><br>
			*身份<select name="role">
				<option>舍员</option>
				<option>舍长</option>
				<option>管理员</option>
				</select><br><br>
			<input type="checkbox">我已阅读并同意遵守<a href="">《青软实训网站服务条款》</a><br><br>
			<input type = "submit">
			<input type="reset">
	</form>
	</div>
</body>
</html>