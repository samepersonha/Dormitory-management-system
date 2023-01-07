<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.qut.utils.DbUtils" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.qut.entity.User" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>用户列表</title>
<link href="css/manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">用户列表</a></li>
  </ul>
</div>
<div class="rightinfo">
  <div class="tools">
    <ul class="toolbar">
      <li class="click"><span></span><a href="manage/reg.html">添加</a></li>
      <li class="click"><span></span><a href="#">修改</a></li>
      <li><span></span><a href="#">删除</a></li>
    </ul>
  </div>
  <table class="imgtable">
    <thead>
      <tr>
        <th ><input name="" type="checkbox" value=""/></th>
        <th>用户学号</th>
        <th>用户姓名</th>
        <th>用户身份证号</th>
        <th>用户身份（0为学生，1为舍管，2为管理员）</th>
      </tr>
    </thead>
    <c:forEach items="${users.pageData}" var="x">
    	<tbody>
      <tr height="50px">
        <td ><input name="" type="checkbox" value="" /></td>
        <td>${x.userid}</td>
        <td>${x.username}</td>
        <td>${x.usernumber}</td>
        <td>${x.role}</td>
      </tr>
    </c:forEach>
    
    </tbody>
  </table>
  
  <div class="pagin">
    <div class="message">共<i class="blue">${users.totalPage}</i>页，当前显示第&nbsp;<i class="blue">${users.currentPage}&nbsp;</i>页</div>
    <ul class="paginList">
      <li class="paginItem"><a href="UserListServlet?page=1">首页</a></li>
      <li class="paginItem"><a href="UserListServlet?page=${users.currentPage-1}">上一页<span class="pagepre"></span></a></li>
      <li class="paginItem"><a href="UserListServlet?page=${users.currentPage+1}">下一页<span class="pagenxt"></span></a></li>
       <li class="paginItem"><a href="UserListServlet?page=${users.totalPage}">尾页</a></li>
    </ul>
  </div>
</div>
</body>
</html>
