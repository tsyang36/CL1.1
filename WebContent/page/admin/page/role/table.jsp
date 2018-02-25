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
<link rel="stylesheet" style="text/css"
	href="${basePath}common/admin/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<ul class="breadcrumb">
					<li><a>权限管理</a></li>

					<li class="active">角色管理</li>
				</ul>
				<form class="form-search"
					action="${basePath}page/admin/page/role/roleServlet"
					method="get">
					<input type="hidden" name="method" value="getPage"/>
					<input class="input-medium search-query" type="text" name="role_name" value="${param.role_name}" /><%-- ${param.admin_user } --%>
					<button type="submit" class="btn" >查找</button>
				</form>
				<br />
				<button class="btn btn-primary" type="button"
					onclick="window.location.href='add.jsp';">添加
				</button>
				<button class="btn btn-danger" type="button" onclick="remove();">批量删除</button>
				<br />
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th></th>
							<th>编号</th>
							<th>角色名</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list }" var="rolebean" varStatus="in">
						
						
						
						<tr>
							<c:if test="${rolebean.role_id!=1}"><td><input type="checkbox" name="role_ids"
								value="${rolebean.role_id}"></td></c:if>
								<c:if test="${rolebean.role_id==1}"><td></td></c:if>
							<td>${(pageUtil.current-1)*10+in.index+1}</td>
							<td>${rolebean.role_name}</td>
							<%-- <td><%=adminbean.getAstate()%></td> --%>
							<td>${rolebean.role_state=="0"?"正常":"冻结"}</td>
							<%-- <c:choose>
							<c:when test="${rolebean.role_id}"></c:when>
							</c:choose> --%>
							<c:if test="${rolebean.role_id!=1}">
							<td><a
								href="roleServlet?method=findById&role_id=${rolebean.role_id}"><img
									src="${basePath}common/admin/images/修改.png">修改</a>
								<a
								href="roleServlet?method=delete&role_ids=${rolebean.role_id}"><img
									src="${basePath}common/admin/images/删除／数字面板编辑态.png">删除</a>
								<a
								href="${basePath}page/admin/page/menu/menuServlet?method=all&a=1&role_ids=${rolebean.role_id}"><img
									src="${basePath}common/admin/images/删除／数字面板编辑态.png">权限分配</a>
							</td>
							</c:if>
							<c:if test="${rolebean.role_id==1}"><td></td></c:if>
						</tr>
						</c:forEach>
						<span style="color: red;"><%=request.getAttribute("message1")==null?"":request.getAttribute("message1") %></span>
					</tbody>
				</table>

				<%PageUtil pageUtil = (PageUtil)request.getAttribute("pageUtil"); %>
				<div style="text-align: center;">
					<ul class="pagination">
						<li><a
							href="roleServlet?method=getPage&current=1${pageUtil.param}">首页</a>
						</li>
						<li><a
							href="roleServlet?method=getPage&current=${pageUtil.current-1}${pageUtil.param}">上一页</a>
						</li>
						<%
							int[] step = (int[]) request.getAttribute("step");
							int current = (int) pageUtil.getCurrent();
							//int begin = step[0];
							//int end = step[1];
							for (int i = step[0]; i <= step[1]; i++) {
								if(i==current){
									
							
						%>
						<li>
						<span style="background-color: red;color: black;"><%=i %></span>
						</li>
						<%}else{
						%>
						<li>
							<a href="${basePath}page/admin/page/role/roleServlet?method=getPage&current=<%=i%>${pageUtil.param}"><%=i %></a>
						</li>
						<%} %>
						<%}%>
						<li><a
							href="roleServlet?method=getPage&current=${pageUtil.current+1}${pageUtil.param}">下一页</a>
						</li>
						<li><a
							href="roleServlet?method=getPage&current=${pageUtil.pagenum}${pageUtil.param}">尾页</a>
						</li>
						<li>第${pageUtil.current}页/共${pageUtil.pagenum}页
							:共${pageUtil.totalRow}条记录
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<script
		src="${basePath}common/admin/bootstrap-3.3.7-dist/js/jquery-3.2.1.min.js"></script>
	<script
		src="${basePath}common/admin/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function remove() {
			var role_ids = document.getElementsByName("role_ids");
			alert(role_ids.length);
			if(role_ids.length==1){//长度为1说明里面没有选择批量删除的值
				var url = "http://localhost:8080/cl/page/admin/page/role/roleServlet?method=getPage";
			}else{
					var url = "http://localhost:8080/cl/page/admin/page/role/roleServlet?method=delete";
					for (var i = 0; i < role_ids.length; i++) {
		
						if (role_ids[i].checked == true) {
		
							url += "&role_ids=" + role_ids[i].value;
						}
					}
				}

			window.location.href = url;
		}
	</script>
</body>
</html>