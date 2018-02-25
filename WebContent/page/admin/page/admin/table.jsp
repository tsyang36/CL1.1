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
<link rel="stylesheet" style="text/css"
	href="http://localhost:8080/cl/common/admin/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<ul class="breadcrumb">
					<li><a>权限管理</a></li>

					<li class="active">管理员管理</li>
				</ul>
				<form class="form-search"
					action="http://localhost:8080/cl/page/admin/login/adminServlet"
					method="get">
					<input type="hidden" name="method" value="getPage"/>
					<input class="input-medium search-query" type="text" name="teloremail"
					value="${teloremail }" /><%-- ${param.admin_user } --%>
					<button type="submit" class="btn" >查找</button>
				</form>
				<br />
				<button class="btn btn-primary" type="button"
					onclick="window.location.href='http://localhost:8080/cl/page/admin/login/adminServlet?method=allRole';">添加
				</button>
				<button class="btn btn-danger" type="button" onclick="remove();">批量删除</button>
				<br />
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th></th>
							<th>编号</th>
							<th>手机号</th>
							<th>邮箱</th>
							<th>密码</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list }" var="adminbean" varStatus="in">
						
						
						
						<tr>
						<c:if test="${adminbean.role_id!=1}">
							<td><input type="checkbox" name="admin_ids"
								value="${adminbean.admin_id}"></td></c:if>
								<c:if test="${adminbean.role_id==1}"><td></td></c:if>
							<td>${(pageUtil.current-1)*10+in.index+1}</td>
							<td>${adminbean.admin_tel}</td>
							<td>${adminbean.admin_email}</td>
							<td>${adminbean.admin_password}</td>
							<%-- <td><%=adminbean.getAstate()%></td> --%>
							<td>${adminbean.admin_state=="0"?"正常":"冻结"}</td>
							
							<td><a
								href="../../admin/login/adminServlet?method=findById&admin_id=${adminbean.admin_id}"><img
									src="http://localhost:8080//cl/common/admin/images/修改.png">修改</a>
									<c:if test="${adminbean.role_id!=1}">
								<a
								href="../../admin/login/adminServlet?method=delete&admin_ids=${adminbean.admin_id}"><img
									src="http://localhost:8080/cl/common/admin/images/删除／数字面板编辑态.png">删除</a>
									</c:if>
							</td>
							
						</tr>
						</c:forEach>
					</tbody>
				</table>

				<%PageUtil pageUtil = (PageUtil)request.getAttribute("pageUtil"); %>
				<div style="text-align: center;">
					<ul class="pagination">
						<li><a
							href="../../admin/login/adminServlet?method=getPage&current=1${pageUtil.param}">首页</a>
						</li>
						<li><a
							href="../../admin/login/adminServlet?method=getPage&current=${pageUtil.current-1}${pageUtil.param}">上一页</a>
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
							<a href="http://localhost:8080/cl/page/admin/login/adminServlet?method=getPage&current=<%=i%>${pageUtil.param}"><%=i %></a>
						</li>
						<%} %>
						<%}%>
						<li><a
							href="../../admin/login/adminServlet?method=getPage&current=${pageUtil.current+1}${pageUtil.param}">下一页</a>
						</li>
						<li><a
							href="../../admin/login/adminServlet?method=getPage&current=${pageUtil.pagenum}${pageUtil.param}">尾页</a>
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
		src="http://localhost:8080/cl/common/admin/bootstrap-3.3.7-dist/js/jquery-3.2.1.min.js"></script>
	<script
		src="http://localhost:8080/cl/common/admin/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function remove() {

			var admin_ids = document.getElementsByName("admin_ids");

			var url = "http://localhost:8080/cl/page/admin/login/adminServlet?method=delete";

			for (var i = 0; i < admin_ids.length; i++) {

				if (admin_ids[i].checked == true) {

					url += "&admin_ids=" + admin_ids[i].value;
				}
			}
			window.location.href = url;
			
		}
	</script>
</body>
</html>