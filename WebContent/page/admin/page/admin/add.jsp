<%@page import="com.tsy.cl.main.admin.bean.AdminBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../../../../common/admin/jsp/head.jsp" %>
<link rel="stylesheet" style="text/css"
	href="http://localhost:8080/cl/common/admin/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<ul class="breadcrumb">
					<li>权限管理</li>
					<li><a href="http://localhost:8080/cl/page/admin/login/adminServlet?method=getPage">管理员管理</a></li>
					<li class="active">${update==null?"添加":"修改"}管理员</li>
				</ul>
				<br />
				<%AdminBean adminBean = (AdminBean)request.getAttribute("adminBean");%>
				<form
					action="${basePath }page/admin/login/adminServlet?method=addOrupdate&update=${update}&admin_id=<%=request.getParameter("admin_id") %>"
					method="post" id="form">
					
					<table class="table table-bordered table-hover">
						<tr>
							<td>手机号<input type="text" name="admin_tel" value="${update==null?'':adminBean.admin_tel}" id="admin_tel" ${update==null?"":"disabled=disabled"} /><span style="color:red" id="telmessage"></span>
							</td> <span style="color:red" id="message"><%=request.getAttribute("message")==null?"":request.getAttribute("message") %></span>	
							<td>邮箱<input type="text" name="admin_email" value="${update==null?'':adminBean.admin_email}" id="admin_email" ${update==null?"":"disabled=disabled"} /><span style="color:red" id="emailmessage"></span>
							</td> <span style="color:red" id="message"><%=request.getAttribute("message")==null?"":request.getAttribute("message") %></span>	
							
						</tr>
						<tr>
							<td>密码<input type="password" name="pwd" value="" id="pwd" /><span style="color:red" id="pwdmessage"></span>
							</td>
							<td>确认密码<input type="password" name="pwd2" value="" id="pwd2" /><span style="color:red" id="pwdmessage2"></span>
							</td>
						</tr>
						<tr>
					<%-- <c:if test="${update==null }"> --%>
						<c:if test="${adminBean.role_id!=1 || update==null}"><!-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------管理员管理，修改增加时出现框 -->
							<td>状态:<select name="admin_state">
									<option value="0">正常</option>
									<option value="1">冻结</option>
							</select>
							</td>
							<td>角色:<select name="role_id">
									<c:forEach items="${list }" var="roleBean">
								  	<c:choose>
								  		<c:when test="${roleBean.role_id==adminBean.role_id }">
								  			<c:if test="${roleBean.role_id!=1}">
								  				<option value="${roleBean.role_id}" selected="selected">${roleBean.role_name }</option>
								  			</c:if>
								  		</c:when>
								  		<c:otherwise>
								  			<c:if test="${roleBean.role_id!=1}">
								  				<option value="${roleBean.role_id}">${roleBean.role_name }</option>
								  			</c:if>
								  		</c:otherwise>
								  	</c:choose>
									 
								</c:forEach>
							</select>
							</td>
						<%-- </c:if> --%>
						</c:if>
						</tr>
						<tr>
							<td colspan="2" align="center"><button
									class="btn btn-primary" type="button" onclick="reg();">${update==null?"注册":"修改"}</button></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<script src="http://localhost:8080/cl/common/admin/js/check.js"></script>
	<script type="text/javascript">
		function reg(){
			
			var email = getemail();
			
			var tel = gettel();
			
			var pwd = getpwd();
			
			if(email && tel && pwd){
				
				document.getElementById("form").submit();	
			}
		}
		
		function getemail(){
			
			var email = document.getElementById("admin_email");
			
			if(isNull(email.value)){
				
				document.getElementById("emailmessage").innerHTML="<img src='http://localhost:8080/cl/common/admin/images/删除／数字面板编辑态.png'>邮箱不能为空!";
				
			}else if(isEmail(email.value)){
				
				document.getElementById("emailmessage").innerHTML="<img src='http://localhost:8080/cl/common/admin/images/正确.png'>";
				return true;
			}else{
				
				document.getElementById("emailmessage").innerHTML="<img src='http://localhost:8080/cl/common/admin/images/错误.png'>邮箱格式不正确";
			}
			
			return false;
			
		}
		
		function gettel(){
			
			var email = document.getElementById("admin_tel");
			
			if(isNull(email.value)){
				document.getElementById("telmessage").innerHTML="<img src='http://localhost:8080/cl/common/admin/images/删除／数字面板编辑态.png'>用户名不能为空!";
				
			}else{
				if(!checkMobile(email.value)){
					document.getElementById("telmessage").innerHTML="<img src='http://localhost:8080/cl/common/admin/images/删除／数字面板编辑态.png'>手机格式不正确!";
				}else{
				document.getElementById("telmessage").innerHTML="<img src='http://localhost:8080/cl/common/admin/images/正确.png'>";
				return true;
				}
			}
			
			return false;
			
		}
		
		function getpwd(){
			
			var pwd = document.getElementById("pwd");
			var pwd2 = document.getElementById("pwd2");
			
			var pwdmessage = document.getElementById("pwdmessage");
			var pwdmessage2 = document.getElementById("pwdmessage2");
			
			if(isNull(pwd.value) || isNull(pwd2.value)){
				pwdmessage.innerHTML="<img src='http://localhost:8080//cl/common/admin/images/错误.png'>密码不能为空";
				pwdmessage2.innerHTML="<img src='http://localhost:8080/cl/common/admin/images/错误.png'>密码不能为空";
			}else if(pwd.value==pwd2.value){
				
				if(pwd.value.length>=6 && pwd.value.length<=15){
					
					pwdmessage.innerHTML="<img src='http://localhost:8080/cl/common/admin/images/正确.png'>";
					pwdmessage2.innerHTML="<img src='http://localhost:8080/cl/common/admin/images/正确.png'>";
					
					return true;
				}else{
					
					
					pwdmessage.innerHTML="<img src='http://localhost:8080/cl/common/admin/images/错误.png'>密码长度必须大于等于6小于等于15";
					pwdmessage2.innerHTML="<img src='http://localhost:8080/cl/common/admin/images/错误.png'>密码长度必须大于等于6小于等于15";
				}
			}else{
				
				pwdmessage.innerHTML="<img src='http://localhost:8080/cl/common/admin/images/错误.png'>两次密码输入不一致";
				pwdmessage2.innerHTML="<img src='http://localhost:8080/cl/common/admin/images/错误.png'>两次密码输入不一致";
			
			}
			
		}
	
	</script>
	<script
		src="http://localhost:8080/cl/common/admin/bootstrap-3.3.7-dist/js/jquery-3.2.1.min.js"></script>
	<script
		src="http://localhost:8080/cl/common/admin/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>