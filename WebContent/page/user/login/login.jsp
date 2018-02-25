<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<!DOCTYPE html>
<%@include file="../../../common/admin/jsp/head.jsp" %>
<html>

	<head>
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta charset='utf-8'>
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<title>登录</title>
		<meta name="viewport" content="width=device-width,initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta http-equiv="Cache-Control" content="no-siteapp">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link rel="stylesheet" type="text/css" href="${basePath}common/user/css/page.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}common/user/css/base.css" />
		<script src="${basePath}common/user/js/jquery-1.8.3.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="${basePath}common/user/js/jquery.SuperSlide.2.1.js"></script>
	</head>
	
	<body class="sign-bg">
		<div class="sign clearfix">
			<div class="top clearfix">
				<a href="${basePath }page/goodsServlet?method=home" class="fl fanhui">返回首页</a>
				<p class="fr">
					还没有商城账号？
					<a href="${basePath }page/user/login/reg.jsp" class="zhuce ra3">
						注册
					</a>
				</p>
			</div>
			<div class="bottom clearfix box-s ra10">
				<div class="sign-logo clearfix">
					<img src="${basePath}common/user/img/yuanlogo.png"/>
				</div>
				<div class="content clearfix">
				<form method ="post"  id = "form" action="${basePath}page/user/login/userServlet?method=login">
					 <div style="color: red;text-align: center;" id="message"><%=request.getAttribute("message")==null?"":request.getAttribute("message") %></div>
					<ul>
						<li>
							<span class="fl"></span>
							<input type="text" name="user_teloreamil" id="user_teloreamil" value="${user_teloreamil}" placeholder="手机号码/邮箱" class="fl shuru" />
						</li>
						<li>
							<span class="fl mima"></span>
							<input type="password" name="user_password" id="user_password" value="${user_password }" placeholder="密码" class="fl shuru" />
						</li>
						<li class="jizhu">
							<div class="radiothree fl"> 
							    <label>
							        <input type="checkbox" name="remember" id="remember" value="1">
							        <div class="option"></div>
							        <p class="opt-text fl ml20">记住密码</p>
							    </label>
							</div>
							<!-- <a href="#" class="wjmima fr">
								忘记密码？
							</a> -->
						</li>
					</ul>
					<a href="javascript:login();" class="sign-btn ra5">立即登录</a>
					<!-- <input type="submit" name="send" class="sign-btn ra5" value="立即登录"> -->
					</form>
				</div>				
			</div>
			<div class="xia clearfix">
				<p>Copyright © 2003-2015 椿龄文化(chunlingwenhua). All Rights Reserved.</p>
			</div>
		</div>
		<script src="http://localhost:8080/cl/common/admin/js/check.js"></script>
	<script type="text/javascript">
	function login() {
		var teloremail =isteloremailNull();
		if(teloremail){
			var password = ispasswordNull(); 
			if(password){
				document.getElementById("form").submit();
			}
		}
	}
	function isteloremailNull() {
		var user_teloreamil =document.getElementById("user_teloreamil");
		if(isNull(user_teloreamil.value)){
			document.getElementById("message").innerHTML="用户名不能为空"
			return false;
		}
		return true;
	}
	function ispasswordNull() {
		var user_teloreamil =document.getElementById("user_password");
		if(isNull(user_teloreamil.value)){
			document.getElementById("message").innerHTML="密码不能为空"
			return false;
		}
		return true;
	}
	</script>
	</body>
</html>
