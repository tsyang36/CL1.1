<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../../../common/admin/jsp/head.jsp" %>
<html>

	<head>
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta charset='utf-8'>
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<title>注册</title>
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
					已有商城账号？
					<a href="login.jsp" class="zhuce ra3">
						登录
					</a>
				</p>
			</div>
			<div class="bottom clearfix box-s ra10">
				<div class="sign-logo clearfix">
					<img src="${basePath}common/user/img/yuanlogo.png"/>
				</div>
				<div class="content clearfix">
				<form action="${basePath}page/user/login/userServlet?method=add" method="post"  id="form">
				<div style="color: red;text-align: center;" id="message1"><%=request.getAttribute("message1")==null?"":request.getAttribute("message1") %></div>
					<ul>
						<li>
							<span class="fl"></span>
							<input type="text" name="user_tel" id="user_tel" value="" placeholder="手机号码" class="fl shuru" /><span style="color:red" id="user_telmessage"></span>
						</li>
						<li>
							<span class="fl"></span>
							<input type="text" name="user_email" id="user_email" value="" placeholder="邮箱" class="fl shuru" /><span style="color:red" id="user_emailmessage"></span>
						</li>
						<!-- <li class="yanzhengma">
							<span class="fl hudun"></span>
							<input type="text" name="yanzhengma" id="yanzhengma" value="" placeholder="请输入验证码" class="fl shuru yzma" />
							<samp class="fr"><img src="upload/yanzhengma.jpg"/></samp>
						</li>
						<li class="yanzhengma">
							<span class="fl hudun"></span>
							<input type="text" name="" id="" value="" placeholder="请输入验证码" class="fl shuru yzma" />
							<samp class="fr">获取验证码</samp>
						</li> -->
						<li>
							<span class="fl mima"></span>
							<input type="password" name="user_password" id="user_password" value="" placeholder="密码" class="fl shuru" /><span style="color:red" id="user_passwordmessage"></span>
						</li>
						<li>
							<span class="fl mima"></span>
							<input type="password" name="user_password2" id="user_password2" value="" placeholder="请再次输入密码" class="fl shuru" /><span style="color:red" id="user_password2message"></span>
						</li>
						<li class="jizhu">
							<div class="radiothree fl"> 
							    <label>
							        <input type="checkbox" name="zcxy" id="zcxy" value="" >
							        <div class="option"></div>
							        <p class="opt-text fl ml20">我已阅读并同意<a href="zcxy.html">《椿龄艺术用户注册协议》</a></p>
							    </label>
							</div>
						</li>
					</ul>
					<a href="javascript:reg();" class="sign-btn zhuce-btn ra5">立即注册</a>
					</form>
				</div>				
			</div>
			<div class="xia clearfix">
				<p>Copyright © 2003-2015 椿龄文化(chunlingwenhua). All Rights Reserved.</p>
			</div>
		</div>
		<script src="${basePath}common/admin/js/check.js"></script>
	<script type="text/javascript">
	function reg() {
		if(isuser_telNull() && isuser_emailNull() && ispasswordNull() && ispassword2Null() && iszcxyNull()){
			if(istel() && isemail() && ismorethansix()){
				document.getElementById("form").submit();
			}
		}
	}
	function iszcxyNull() {
		
		var zcxy =document.getElementById("zcxy");
		if(!zcxy.checked){
			document.getElementById("message1").innerHTML="请同意《椿龄艺术用户注册协议》"
			return false;
		}
		return true;
	}
	function isuser_telNull() {
		var user_tel =document.getElementById("user_tel");
		if(isNull(user_tel.value)){
			document.getElementById("message1").innerHTML="手机号不能为空"
			return false;
		}
		return true;
	}
	function isuser_emailNull() {
		var user_email =document.getElementById("user_email");
		if(isNull(user_email.value)){
			document.getElementById("message1").innerHTML="邮箱不能为空"
			return false;
		}
		return true;
	}
	function ispasswordNull() {
		var user_password =document.getElementById("user_password");
		if(isNull(user_password.value)){
			document.getElementById("message1").innerHTML="密码不能为空"
			return false;
		}
		return true;
	}
	function ispassword2Null() {
		var user_password2 =document.getElementById("user_password2");
		var user_password =document.getElementById("user_password");
		
		if(isNull(user_password2.value)){
			document.getElementById("message1").innerHTML="请确认密码"
			return false;
		}else if(user_password.value != user_password2.value ){
			document.getElementById("message1").innerHTML="两次密码不一致"
			return false;
		}
		return true;
	}
	function istel() {
		var user_tel =document.getElementById("user_tel");
		if(!checkMobile(user_tel.value)){
			document.getElementById("message1").innerHTML="手机号格式不正确"
			return false;
		}
		return true;
	}
	function isemail() {
		var user_email =document.getElementById("user_email");
		if(!isEmail(user_email.value)){
			document.getElementById("message1").innerHTML="邮箱格式不正确"
			return false;
		}
		return true;
	}
	function ismorethansix() {
		var user_password =document.getElementById("user_password");
		if((user_password.value).length<6){
			document.getElementById("message1").innerHTML="密码必须大于等于6位"
			return false;
		}
		return true;
	}
	</script>
	</body>
</html>
