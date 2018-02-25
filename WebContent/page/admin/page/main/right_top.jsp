<%@page import="com.tsy.cl.main.admin.bean.AdminBean"%>
<%@page import="com.tsy.cl.main.admin.bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="http://localhost:8080/cl/common/admin/css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%AdminBean adminBean =  (AdminBean)session.getAttribute("adminBean"); %>
	<div id="right_top">
		<div id="img" onclick="openc()">
			<img src="http://localhost:8080/cl/common/admin/images/close.gif" />
		</div>
		<span id="spanco" class="imgtext" onclick="openc()">关闭左栏</span>
		
		<span class="imgtext2"></span>
		<div class="weather">
			<marquee id="weather_marquee" direction="left" scrollamount="3" onmouseover="this.stop()" onmouseout="this.start()">
				欢迎登录<%=adminBean.getAdmin_tel() %>
			</marquee>			
		</div>
		
		
		<div id="loginout">
			<div id="loginoutimg">
				<img src="http://localhost:8080/cl/common/admin/images/loginout.gif" />
			</div>
			<span class="logintext" onclick="top.location.href='../../login/adminServlet?method=exit'">退出系统</span>
		</div>
	</div>
	
</body>
</html>
<script type="text/javascript">
	var menu=window.parent.parent.document.getElementsByTagName("frameset")[1]; 
	var spanco = document.getElementById("spanco");
	var img = document.getElementById("img");
	
	function openc(){
		if (spanco.innerHTML =="关闭左栏"){
			menu.cols="0,*";
			spanco.innerHTML = "打开左栏";
			img.innerHTML = "<img src=\"http://localhost:8080/cl/common/admin/images/open.gif\" />";
		}else{
			menu.cols="188,*";
			spanco.innerHTML = "关闭左栏";
			img.innerHTML = "<img src=\"http://localhost:8080/cl/common/admin/images/close.gif\" />";
		}
		
	}
</script>

