<%@page import="com.tsy.cl.main.admin.bean.AdminBean"%>
<%@page import="com.tsy.cl.main.admin.bean.AdminBean"%>
<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>TOP</title>
<link href="http://localhost:8080/cl/common/admin/css/main.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%AdminBean  adminBean =  (AdminBean)session.getAttribute("adminBean"); %>
<div id="top">
	      <div id="logo"></div>
		  <div id="user">【欢迎您】：<%=adminBean.getAdmin_tel() %>【IP】：admin【今天】：<span id="time"></span></div>	 
	 </div>
	<script type="text/javascript">
		
		window.setInterval(function(){
			
			var date = new Date();
			
			document.getElementById("time").innerHTML=date.toLocaleString();
			
		},1000);
	
	</script>
</body>
</html>
