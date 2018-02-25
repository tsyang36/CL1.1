<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@include file="../../../../common/admin/jsp/head.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	ul li{
		list-style: none;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${basePath}page/admin/page/role/rmServlet?method=add" method="post">
		<input type="button" value="全选" onclick="all2();">
		<input type="button" value="反选" onclick="all3();">
		<input type="hidden" value="${role_id }" name="roleId">
		<ul>
			<c:forEach items="${list }" var="menuBean">
				<c:if test="${menuBean.father_id==0}">
					<li><input type="checkbox" value="${menuBean.menu_id }" name="role_ids">${menuBean.menu_name}
						<ul>
							<c:forEach items="${list }" var="menuBean2">
								<c:if test="${menuBean2.father_id == menuBean.menu_id }">
									<li><input type="checkbox" value="${menuBean2.menu_id }" 
										name="role_ids">${menuBean2.menu_name}
								</c:if>
							</c:forEach>
						</ul></li>
				</c:if>
			</c:forEach>
		</ul>
		<input type="submit" value="提交" id ="tj" name = "tj"> 
	</form>

</body>
<script type="text/javascript">
	function all2() {
		var role_ids = document.getElementsByName("role_ids");
		for (var i = 0; i < role_ids.length; i++) {
			role_ids[i].checked = true;
		}
	}
	function all3() {
		var role_ids = document.getElementsByName("role_ids");
		for (var i = 0; i < role_ids.length; i++) {
			if (role_ids[i].checked) {
				role_ids[i].checked = false;
			} else {
				role_ids[i].checked = true;
			}
		}
	}
</script>
</html>