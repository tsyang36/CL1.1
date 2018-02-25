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
					<a href="#">商品模块</a>
				</li>
			
				<li class="active">
					商品分类管理
				</li>
			</ul>
			<form class="form-search" action="${basePath}page/admin/page/gclass/gclassServlet" method="get">
				<input type="hidden" name="method" value="getPage">
				<input class="input-medium search-query" type="text" name="gclass_name" value="${param.gclass_name}" /> <button type="submit" class="btn">查找</button>
			</form><br/> <button class="btn btn-primary" type="button" onclick="window.location.href='${basePath}page/admin/page/gclass/add.jsp';">添加</button> <button class="btn btn-danger" type="button" onclick="remove();">批量删除</button>
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
							商品分类名称
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="gclassBean" varStatus="in">
					
					<tr>
						<td>
							<input type="checkbox" name="gclass_ids" value="${gclassBean.gclass_id }" >
						</td>
						<td>
							${in.index+1+(pageUtil.current-1)*10}
						</td>
						<td>
							${gclassBean.gclass_name}
						</td>
						<td>
							<a href="${basePath}page/admin/page/gclass/gclassServlet?method=findById&gclass_id=${gclassBean.gclass_id }"><img src="${basePath}common/admin/images/修改.png">修改</a>
							<a href="${basePath}page/admin/page/gclass/gclassServlet?method=delete&gclass_ids=${gclassBean.gclass_id }"><img src="${basePath}common/admin/images/删除／数字面板编辑态.png">删除</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			
			<div style="text-align: center;">
				<ul class="pagination">
					<li>
						<a href="?method=getPage&current=1${pageUtil.param} ">首页</a>
					</li>
					<li>
						<a href="?method=getPage&current=${pageUtil.current-1}${pageUtil.param}">上一页</a>
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
						<a href="?method=getPage&current=<%=i%>${pageUtil.param}"><%=i %></a>
					</li>
					<%} %>
					<%} %>
					<li>
						<a href="?method=getPage&current=${pageUtil.current+1}${pageUtil.param}">下一页</a>
					</li>
					<li>
						<a href="?method=getPage&current=${pageUtil.pagenum}${pageUtil.param}">尾页</a>
					</li>
					<li>当前页:${pageUtil.current}/${pageUtil.pagenum}&nbsp;&nbsp;总记录:${pageUtil.totalRow}</li>
				</ul>
			</div>
		</div>
	</div>
</div>
<script src="${basePath}common/admin/bootstrap-3.3.7-dist/js/jquery-3.2.1.min.js"></script>
<script src="${basePath}common/admin/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function remove(){
		
		var gclass_ids=document.getElementsByName("gclass_ids");
		
		var gclass_url = "${basePath}page/admin/page/gclass/gclassServlet?method=delete";
		
		for (var i = 0; i < gclass_ids.length; i++) {
			
			if(gclass_ids[i].checked==true){
				
				gclass_url+="&gclass_ids="+gclass_ids[i].value;
			}
		}
		
		window.location.href=gclass_url;
		
		
	}

</script>
</body>
</html>