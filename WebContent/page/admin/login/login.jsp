<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../../../common/admin/jsp/head.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>用户登录</title>
<link href="http://localhost:8080/cl/common/admin/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();
	String email="";
	String pwd = "";
	if(cookies!=null){
	for(Cookie cookie :cookies){
		if("email".equals(cookie.getName())){
			email = cookie.getValue();
		}
		if("pwd".equals(cookie.getName())){
			pwd = cookie.getValue();
		}
		
	}
		if(!"".equals(email)&&!"".equals(pwd)){
			response.sendRedirect(request.getContextPath()+"/page/admin/login/adminServlet?method=login&email="+email+"&pwd="+pwd);
		}
	}
	
%>
    <div id="login">
	     <div id="top">
		      <div id="top_left"><img src="http://localhost:8080/cl/common/admin/images/login_03.gif" /></div>
			  <div id="top_center"></div>
		 </div>
		 
		 <div id="center">
		      <div id="center_left"></div>
			  <div id="center_middle" style="height: 230px">
			  
			  <form action="http://localhost:8080/cl/page/admin/login/adminServlet?method=login" method ="post"  id = "form">
			  <div style="color: red;text-align: center;" id="message"><%=request.getAttribute("message")==null?"":request.getAttribute("message") %></div>
			       <div id="user">手机或邮箱:
			         <input type="text" autocomplete="off" name="teloremail" id="teloremail"/>
			       </div>
				   <div id="password">&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;码：
				     <input type="password" name="pwd" id="pwd"/>
				   </div>
				   <div id="code">验&nbsp;&nbsp;证&nbsp;&nbsp;码：
				     <input type="text" autocomplete="off" name="code" id="cod" onFocus="showCode();" onclick="showCode()" />
				   </div>
						<!-- <input type="checkbox" name="remember" id="remember" value="1">自动登录 -->
				   <div id="btn">
						<img
							src="${basePath}page/admin/login/codeUtil" onclick="this.src=this.src+'?time'+Math.random();" />
						<a href="javascript:login();">登录</a>
						
				   </div>
			 </form>
					  
			  </div>
			  <div id="center_right"></div>		 
		 </div>
		 <div id="down">
		      <div id="down_left">
			      <div id="inf">
                       <span class="inf_text">版本信息</span>
					   <span class="copyright">椿龄后台管理系统 2018 v1.0</span>
			      </div>
			  </div>
		 </div>
	</div>
	<script src="http://localhost:8080/cl/common/admin/js/check.js"></script>
	<script type="text/javascript">
	function login() {
		var email =isemailNull();
		if(email){
			var password = ispasswordNull(); 
			if(password){
				document.getElementById("form").submit();
			}
		}
	}
	function isemailNull() {
		var teloremail =document.getElementById("teloremail");
		if(isNull(teloremail.value)){
			document.getElementById("message").innerHTML="用户名不能为空"
			return false;
		}
		
		
		return true;
	}
	function ispasswordNull() {
		var pwd =document.getElementById("pwd");
		if(isNull(pwd.value)){
			document.getElementById("message").innerHTML="密码不能为空"
			return false;
		}
		return true;
	}
	</script>
</body>
</html>
