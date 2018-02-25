<%@page import="com.tsy.cl.main.admin.bean.AdminBean"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
					<li><a href="#">商品管理</a></li>
					<li class="active">${goodsBean==null?"添加":"修改"}商品</li>
				</ul>
				<br />
				<form
					action="${basePath}page/goodsServlet?method=addOrupdate"
					method="post" id="form" enctype="multipart/form-data">
					<table class="table table-bordered table-hover">
						<tr>
							<input type="hidden" name="goods_id" value="${goodsBean.goods_id }">
							<td>商品名称<input type="text" name="goods_name"    value="${goodsBean.goods_name}" id="goods_name" /><span style="color:red" id="rnamemessage"></span>
							</td>
							<td>单价<input type="text" name="goods_price" value="${goodsBean.goods_price}" id="goods_price" /><span style="color:red" id="pricemessage"></span>
							</td>
						</tr>
						
						<tr>
							<td>选择商品分类<select name="gclassid">
											<c:forEach items="${list}" var="gclassBean">
												<c:if test="${goodsBean.gclassId==gclassBean.gclass_id }">
													<option value="${gclassBean.gclass_id }" selected="selected">${gclassBean.gclass_name }</option>
												</c:if>
												<c:if test="${goodsBean.gclassId!=gclassBean.gclass_id }">
													<option value="${gclassBean.gclass_id }">${gclassBean.gclass_name }</option>
												</c:if>
											</c:forEach>
										</select>
							</td>
							<td>上传图片<input type="file" name="goods_image" value="${goodsBean.goods_image}" id="goods_image" />
							</td>
						</tr>
						<tr>
							<td colspan="2"><textarea rows="20" cols="170" name="goods_desc">${goodsBean.goods_desc }</textarea></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><button
									class="btn btn-primary" type="button" onclick="reg();">${goodsBean==null?"添加":"修改"}</button></td>
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
			var price = getprice();
			
			if(email &&price){
				document.getElementById("form").submit();	
			}
		}
		
		function getuser(){
			
			var email = document.getElementById("goods_name");
			
			if(isNull(email.value)){
				
				document.getElementById("rnamemessage").innerHTML="<img src='${basePath}common/admin/images/删除／数字面板编辑态.png'>商品名称不能为空!";
				
			}else{
				
				document.getElementById("rnamemessage").innerHTML="<img src='${basePath}common/admin/images/正确.png'>";
				return true;
			}
			
			return false;
			
		}
		
		function getprice(){
			
			var price = document.getElementById("goods_price");
			
			if(isNull(price.value)){
				
				document.getElementById("pricemessage").innerHTML="<img src='${basePath}common/admin/images/删除／数字面板编辑态.png'>商品价格不能为空!";
				
			}else{
				
				document.getElementById("pricemessage").innerHTML="<img src='${basePath}common/admin/images/正确.png'>";
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