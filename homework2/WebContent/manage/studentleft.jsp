<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/left.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="../js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>
<title>Insert title here</title>
</head>
<body style="background:#f0f9fd;">
		<div class="lefttop"><span></span>功能菜单</div>
<dl class="leftmenu">
  <dd>
    <div class="title"> <span></span>考勤管理</div>
    <ul class="menuson">
      <li><cite></cite><a href="../checkrecord" target="rightFrame">考勤查询</a><i></i></li>
    </ul>
  </dd>
</dl>
</body>
</html>