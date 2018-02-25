<%@page import="com.tsy.cl.main.role.bean.RoleBean"%>
<%@page import="com.tsy.cl.main.admin.bean.AdminBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="../../../../common/admin/jsp/head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" style="text/css"
	href="http://localhost:8080/cl/common/admin/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<ul class="breadcrumb">
					<li>权限管理</li>
					
					<li><a href="${basePath}page/admin/page/role/roleServlet?method=getPage">角色管理</a></li>
					<li class="active">${roleBean==null?"添加":"修改"}管理员</li>
				</ul>
				<br />
				<%-- <%RoleBean roleBean = (RoleBean)request.getAttribute("roleBean");%> --%>
				<form
					action="${basePath}page/admin/page/role/roleServlet?method=addOrupdate&update=<%=request.getParameter("update") %>"
					method="post" id="form">
					<table class="table table-bordered table-hover">
						<tr>
							<input type="hidden" name="role_id" value="${roleBean.role_id }">
							<td>角色名称<input type="text" name="role_name"    value="${roleBean.role_name }" id="role_name" />
							<%-- <div style="color: red;" id="message"><%=request.getAttribute("message")==null?"":request.getAttribute("message") %></div> --%>
							<span style="color:red" id="message"><%=request.getAttribute("message")==null?"":request.getAttribute("message") %></span>
							</td> 	
							<td>状态:<select name="state">
									<option value="0">正常</option>
									<option value="1">冻结</option>
							</select>
							</td>
						</tr>
						
						<tr>
							<td colspan="2" align="center"><button
									class="btn btn-primary" type="button" onclick="reg();">${roleBean==null?"注册":"修改"}</button></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<script src="http://localhost:8080/cl/common/admin/js/check.js"></script>
	<script type="text/javascript">
		function reg(){
			
			var email = getuser();
			
		
			if(email){
				document.getElementById("form").submit();	
			}
		}
		
		function getuser(){
			
			var email = document.getElementById("role_name");
			if(isNull(email.value)){
				document.getElementById("message").innerHTML="<img src='http://localhost:8080/cl/common/admin/images/删除／数字面板编辑态.png'>角色名称不能为空!";
			}else{
				document.getElementById("message").innerHTML="<img src='http://localhost:8080/cl/common/admin/images/正确.png'>";
				return true;
			}
				return false;
			
			
		}
		
		
	
	</script>
	<script
		src="http://localhost:8080/cl/common/admin/bootstrap-3.3.7-dist/js/jquery-3.2.1.min.js"></script>
	<script
		src="http://localhost:8080/cl/common/admin/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>