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
      </tr>
    </thead>
    <c:forEach items="${l}" var="x">
    	<tbody>
      <tr height="50px">
        <td ><input name="" type="checkbox" value="" /></td>
        <td>${x.memberid}</td>
        <td>${x.membername}</td>
        <td>${x.dormitoryid}</td>
        <td>${x.record}</td>
      </tr>
    </c:forEach>
    
    </tbody>
  </table>
</div>
</body>
</html>