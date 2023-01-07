<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">  
 // 该js 不需要引用，当该页面中所有的内容执行完后自动执行
    onload=function(){
        setInterval(go, 1000);    
       //js 中时间以毫秒计时
    };
    var x=3; //利用了全局变量来执行
    function go(){
        x--;
        if(x>0){
            document.getElementById("sp").innerHTML=x+"秒后跳转页面！！！";  //每次设置的x的值都不一样了
        }else{
            location.href='http://localhost:8081/homework2/index.jsp';
        }
    }
</script>
<div align="center">
    <h1>注册成功！！！</h1><br>
    <span id="sp"> 3秒后跳转页面！！！</span><br>
    <a href="http://localhost:8081/homework2/index.jsp">若没有跳转，请点击此处！！！</a>
</div>
</body>
</html>