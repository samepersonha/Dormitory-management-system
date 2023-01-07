<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="../changePwd" method="post">
		学号：<input type="text" name="userid"><br><br>
		姓名：<input type="text" name="username"><br><br>
		身份证号：<input type="text" name="usernumber"><br><br>
		新密码：<input type="password" name="userpwd"><br><br>
		确认密码：<input type="password" name="repwd"><br><br>
		<input type="submit" value="更改">
	</form>
</body>
</html>