<%@page import="com.tsy.cl.main.admin.bean.AdminBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../../../../common/admin/jsp/head.jsp" %>
<link rel="stylesheet" style="text/css"
	href="${basePath}common/admin/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<body>
					
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<ul class="breadcrumb">
					<li>商品模块</li>
					<li><a href="#">商品分类管理</a></li>
					<li class="active">${gclassBean==null?"添加":"修改"}商品分类</li>
				</ul>
				<br />
				<form
					action="${basePath}page/admin/page/gclass/gclassServlet?method=addOrupdate"
					method="post" id="form">
					<table class="table table-bordered table-hover">
						<tr>
							<input type="hidden" name="gclass_id" value="${gclassBean.gclass_id }">
							<td>商品分类名称<input type="text" name="gclass_name"    value="${gclassBean.gclass_name }" id="gclass_name" /><span style="color:red" id="rnamemessage"></span>
							</td>
						
						</tr>
						
						<tr>
							<td colspan="2" align="center"><button
									class="btn btn-primary" type="button" onclick="reg();">${gclassBean==null?"注册":"修改"}</button></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<script src="${basePath}common/admin/js/check.js"></script>
	<script type="text/javascript">
		function reg(){
			
			var email = getuser();
			
			
			if(email){
				
				document.getElementById("form").submit();	
			}
		}
		
		function getuser(){
			
			var email = document.getElementById("gclass_name");
			
			if(isNull(email.value)){
				
				document.getElementById("rnamemessage").innerHTML="<img src='${basePath}common/admin/images/删除／数字面板编辑态.png'>商品分类名称不能为空!";
				
			}else{
				
				document.getElementById("rnamemessage").innerHTML="<img src='${basePath}common/admin/images/正确.png'>";
				return true;
			}
			
			return false;
			
		}

	
	</script>
	<script
		src="${basePath}common/admin/bootstrap-3.3.7-dist/js/jquery-3.2.1.min.js"></script>
	<script
		src="${basePath}common/admin/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>