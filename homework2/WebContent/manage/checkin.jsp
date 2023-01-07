<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.qut.utils.DbUtils" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.qut.entity.*" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>考勤管理</title>
<link href="css/manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">考勤管理</a></li>
  </ul>
</div>
<div class="rightinfo">
  <div class="tools">
    <ul class="toolbar">
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
        <th>宿舍号</th>
        <th>考勤状态（0为缺勤，1为考勤）</th>
        <th>操作</th>
      </tr>
    </thead>
    <c:forEach items="${dormember.pageData}" var="x">
    	<tbody>
      <tr height="50px">
        <td ><input name="" type="checkbox" value="" /></td>
        <td>${x.memberid}</td>
        <td>${x.membername}</td>
        <td>${x.dormitoryid}</td>
        <td>${x.record}</td>
        <td><a href="changerecord?type=kaoqin&memberid=${x.memberid}" class="tablelink">考勤</a> &nbsp;&nbsp;<a href="changerecord?type=queqin&memberid=${x.memberid}" class="tablelink"> 缺勤</a></td>
      </tr>
    </c:forEach>
    
    </tbody>
  </table>
  
  <div class="pagin">
    <div class="message">共<i class="blue">${dormember.totalPage}</i>页，当前显示第&nbsp;<i class="blue">${dormember.currentPage}&nbsp;</i>页</div>
    <ul class="paginList">
      <li class="paginItem"><a href="UserListServlet?page=1">首页</a></li>
      <li class="paginItem"><a href="UserListServlet?page=${dormember.currentPage-1}">上一页<span class="pagepre"></span></a></li>
      <li class="paginItem"><a href="UserListServlet?page=${dormember.currentPage+1}">下一页<span class="pagenxt"></span></a></li>
       <li class="paginItem"><a href="UserListServlet?page=${dormember.totalPage}">尾页</a></li>
    </ul>
  </div>
</div>
</body>
</html>