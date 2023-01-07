<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
<style>
body {
	font: 12px/30px microsoft yahei;
}
.login_content {
	background: url(images/login.png) no-repeat;
	width: 737px;
	height: 396px;
	margin: 150px auto 0px;
}

.login_name {
	float: left;
	margin: 50px 0px 0px 400px;
	color: black;
	font-size: 14px;
	line-height: 35px;
}

.login_name h3 {
	font-size: 16px;
	border-bottom: 1px dotted #02356f;
}

.login_input {
	padding: 5px;
	height: 20px;
	line-height: 20px;
	color: gray;
	width: 200px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
}

.yzm_input {
	width: 100px;
	padding: 5px;
	height: 20px;
	line-height: 20px;
	color: gray;
	border: 1px solid #ccc;
	margin-right: 5px;
}
.login_button{background:#008ffd;border-radius:5px;width:80px;height:35px;line-heihgt:35px;display:block; margin-top:10px; color:white; border:none; font-family:microsoft yahei;cursor:pointer;}
.login_button:hover{ background:#00b8e6;color:yellow; }
</style>
<script type="text/javascript">
  function reCode()
  {
	  document.getElementById("chkcode").src= "../ChkcodeServlet?x="+new Date();
  }
</script>
</head>
<body>
<div style="align: center; font-size: 20pt; margin-top: 150px; position:relative;left:40%">
	<form action="../mylogin" method="post">
		学号：<input type="text" name="userid" class="login_input" value =${cookie.userid.value}><br><br>
		密码：<input type="password" name="userpwd" class="login_input" value =${cookie.userpwd.value}>
		<a href="changePwd.jsp">忘记密码</a><br><br>
		验证码<input type="text" name="chkcode" class="yzm_input">
		<img id="chkcode" onclick="reCode()" src="../ChkcodeServlet" >
		<a onclick="reCode()">刷新</a><br><br>
		<input type="checkbox" name="autolog" checked="checked">自动登录<br><br>
		<input type="submit" value="登录" class="login_button">
	</form>
</div>

</body>
</html>