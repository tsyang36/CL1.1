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
	href="${basePath}common/admin/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<body>
					
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<ul class="breadcrumb">
					<li>权限管理</li>
					<li><a href="#">菜单管理</a></li>
					<li class="active">${menuBean==null?"添加":"修改"}菜单</li>
				</ul>
				<br />
				<form
					action="${basePath}page/admin/page/menu/menuServlet?method=addOrupdate"
					method="post" id="form" name="form">
					<table class="table table-bordered table-hover">
						<tr>
							<input type="hidden" name="menu_id" value="${menuBean.menu_id }">
							<td>菜单名称<input type="text" name="menu_name" value="${menuBean.menu_name}" id="menu_name" /><span style="color:red" id="menu_namemessage"></span>
							</td>
							<td>
								路径<input type="text" name="menu_url" value="${menuBean.menu_url }" id="menu_url"/><input type="button" onclick="document.getElementById('if').src=document.getElementById('menu_url').value;" value="检测">
							</td>
						</tr>
						
						<tr>
							<td>级别:<select name="father_id">
										<option value="0" >一级菜单</option>
										<!-- <option value="1" >二级菜单</option> -->
										<c:forEach items="${list}" var="menuBean2">
											<c:if test="${menuBean2.father_id==0 }">
													<option value="${menuBean2.menu_id }" ${menuBean2.menu_id==menuBean.father_id?"selected=selected":"" } >${menuBean2.menu_name }</option>
											</c:if>
										</c:forEach>
									</select>
							</td>
							<td colspan="2" align="center"><button
									class="btn btn-primary" type="button" onclick="reg();" >${menuBean==null?"注册":"修改"}</button></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<iframe width="800px" height="500px" src="" id="if"></iframe>
	<script src="${basePath}common/admin/js/check.js"></script>
	<script type="text/javascript">
		function reg(){
			var menu_name = getmenu_name();
			
			
			if(menu_name){
				document.getElementById("form").submit();	
			}
		}
		
		function getmenu_name(){
			
			var menu_name = document.getElementById("menu_name");
			
			if(isNull(menu_name.value)){
				
				document.getElementById("menu_namemessage").innerHTML="<img src='${basePath}common/admin/images/删除／数字面板编辑态.png'>菜单名称不能为空!";
				
			}else{
				
				document.getElementById("menu_namemessage").innerHTML="<img src='${basePath}common/admin/images/正确.png'>";
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