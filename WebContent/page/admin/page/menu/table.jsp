<%@page import="com.tsy.cl.util.PageUtil"%>
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
<link rel="stylesheet" style="text/css" href="${basePath}common/admin/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<ul class="breadcrumb">
				<li>
					<a href="#">权限管理</a>
				</li>
			
				<li class="active">
					菜单管理
				</li>
			</ul>
			<form class="form-search" action="${basePath}page/admin/page/menu/menuServlet" method="get">
				<input type="hidden" name="method" value="getPage">
				<input class="input-medium search-query" type="text" name="menu_name" value="${param.menu_name}" /> <button type="submit" class="btn">查找</button>
			</form><br/> <button class="btn btn-primary" type="button" onclick="window.location.href='${basePath}page/admin/page/menu/menuServlet?method=all';">添加</button> <button class="btn btn-danger" type="button" onclick="remove();">批量删除</button>
			<br/>
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>
							
						</th>
						<th>
							编号
						</th>
						<th>
							菜单名称
						</th>
						<th>
							路径
						</th>
						<th>
							级别
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="menuBean" varStatus="in">
					
					<tr>
						<td>
							<input type="checkbox" name="menu_ids" value="${menuBean.menu_id}" >
						</td>
						<td>
							${in.index+1+(pageUtil.current-1)*10}
						</td>
						<td>
							${menuBean.menu_name}
						</td>
						<td>
							${menuBean.menu_url}
						</td>
						<td>
							${menuBean.father_id==0?"一级菜单":"二级菜单"}
						</td>
						<td>
							<a href="${basePath}page/admin/page/menu/menuServlet?method=findById&menu_id=${menuBean.menu_id }"><img src="http://localhost:8080/cl/common/admin/images/修改.png">修改</a>
							<a href="${basePath}page/admin/page/menu/menuServlet?method=delete&menu_ids=${menuBean.menu_id }"><img src="http://localhost:8080/cl/common/admin/images/删除／数字面板编辑态.png">删除</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			
			<div style="text-align: center;">
				<ul class="pagination">
					<li>
						<a href="${basePath}page/admin/page/menu/menuServlet?method=getPage&current=1${pageUtil.param} ">首页</a>
					</li>
					<li>
						<a href="${basePath}page/admin/page/menu/menuServlet?method=getPage&current=${pageUtil.current-1}${pageUtil.param}">上一页</a>
					</li>
					
					<%
						PageUtil pageUtil =(PageUtil) request.getAttribute("pageUtil");
						int[] step = (int[])request.getAttribute("step");
					
						int current =pageUtil.getCurrent();
					
						for(int i=step[0];i<=step[1];i++){
							
						if(current==i){
					%>
						<li>
							<span style="background-color: red;color: black;"><%=i %></span>
						</li>
					<%}else{ %>
					<li>
						<a href="${basePath}page/admin/page/menu/menuServlet?method=getPage&current=<%=i%>${pageUtil.param}"><%=i %></a>
					</li>
					<%} %>
					<%} %>
					<li>
						<a href="${basePath}page/admin/page/menu/menuServlet?method=getPage&current=${pageUtil.current+1}${pageUtil.param}">下一页</a>
					</li>
					<li>
						<a href="${basePath}page/admin/page/menu/menuServlet?method=getPage&current=${pageUtil.pagenum}${pageUtil.param}">尾页</a>
					</li>
					<li>当前页:${pageUtil.current}/${pageUtil.pagenum}&nbsp;&nbsp;总记录:${pageUtil.totalRow}</li>
				</ul>
			</div>
		</div>
	</div>
</div>
<script src="http://localhost:8080/cl/common/admin/bootstrap-3.3.7-dist/js/jquery-3.2.1.min.js"></script>
<script src="http://localhost:8080/cl/common/admin/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function remove(){
		
		var menu_ids=document.getElementsByName("menu_ids");
		
		var menu_url = "${basePath}page/admin/page/menu/menuServlet?method=delete";
		
		for (var i = 0; i < menu_ids.length; i++) {
			
			if(menu_ids[i].checked==true){
				
				menu_url+="&menu_ids="+menu_ids[i].value;
			}
		}
		
		window.location.href=menu_url;
		
		
	}

</script>
</body>
</html>