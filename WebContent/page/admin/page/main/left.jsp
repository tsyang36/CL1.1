<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@include file="../../../../../common/admin/jsp/head.jsp" %>
<link href="${basePath}common/admin/css/main.css" rel="stylesheet" type="text/css" />
<script src="${basePath}common/admin/js/jquery-1.7.2.min.js"></script>
</head>
<body>
	<div id="left">
	
		<div id="left_menu"></div>
		<div id="left_tree">
			<div id="tree_text">
				<ul id="globalNav">
					<c:forEach items="${list}" var="menuBean">
					
				
					<li>
						<a>${menuBean.menu_name}</a>
						<ul>
							<c:forEach items="${menuBean.list}" var="menuBean2">
							<li>
								<a class="a" href="${menuBean2.menu_url}" target="right">${menuBean2.menu_name }</a>
							</li>
							</c:forEach>
						</ul>
					</li>
					</c:forEach>
					
				</ul>
			</div>
		</div>
		<div id="tree_down"/>
     </div>
</body>
</html>

<script type="text/javascript">
$(function(){
	initHeight();
	$("#globalNav").children().each(function(index){
		var item = $(this);
		var tag_a = item.children().eq(0);
		tag_a.attr("href", "#this");
		var tag_ul = item.children().eq(1);
		if(index == 0) {
			tag_ul.show();
		}
		tag_a.click(function(){
			tag_ul.toggle();
		});
	});
	
	$(".a").click(function(){
		$(".a").css({"color":"black", "font-weight":"normal"});
		$(this).css({"color":"red", "font-weight":"bold"});
	});
})
window.onresize=function() {
	initHeight();
}
function initHeight(){
	$("#left_tree").css("height", document.documentElement.clientHeight-80);
	$("#tree_text").css("height", document.documentElement.clientHeight-80);
}
</script>
