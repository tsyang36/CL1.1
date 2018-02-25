<%@page import="com.tsy.cl.main.goods.bean.GoodsBean"%>
<%@page import="com.tsy.cl.util.PageUtil"%>
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
<link rel="stylesheet" style="text/css" href="${basePath}common/user/css/common.css">
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
					订单管理
				</li>
			</ul>
			<form class="form-search" action="${basePath}page/user/page/orders/ordersServlet" method="get">
				<input type="hidden" name="method" value="getPage">
				<input class="input-medium search-query" type="text" name="order_code" value="" /> <button type="submit" class="btn">查找</button>
			</form><br/> 
			<br/>
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>
							订单编号
						</th>
						<th>
							订单号
						</th>
						<th>
							订单提交时间
						</th>
						<th>
							订单状态
						</th>
						<th>
							用户编号
						</th>
						<th>
							订单总价
						</th>
						<th>
							收件人
						</th>
						<th>
							省份
						</th>
						<th>
							市区
						</th>
						<th>
							乡镇
						</th>
						<th>
							详细地址
						</th>
						<th>
							联系电话
						</th>
						<th>
							邮编
						</th>
						<th>
							详情
						</th>
						<th>
							操作
						</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ordergllist}" var="OrderBean" varStatus="in">
					
					<tr>
						<%-- <td>
							<input type="checkbox" name="order_id" value="${OrderBean.order_id }" >
						</td> --%>
						<td>
							${OrderBean.order_id }
						</td>
						<td>
							${OrderBean.order_code }
						</td>
						<td>
							${OrderBean.order_time }
						</td>
						<td>
							<c:if test="${OrderBean.order_state==3}">已收货</c:if>
							<c:if test="${OrderBean.order_state==2}">已发货</c:if>
							<c:if test="${OrderBean.order_state==1}">待发货</c:if>
							<c:if test="${OrderBean.order_state==0}">未付款</c:if> 
						</td>
						<td>
							${OrderBean.user_id }
						</td>
						<td>
							${OrderBean.orders_sumprice }
						</td>
						<td>
							${OrderBean.addr_name }
						</td>
						<td>
							${OrderBean.addr_province }
						</td>
						<td>
							${OrderBean.addr_city }
						</td>
						<td>
							${OrderBean.addr_district }
						</td>
						<td>
							${OrderBean.addrxx }
						</td>
						<td>
							${OrderBean.tel }
						</td>
						<td>
							${OrderBean.youbian }
						</td>
						<td>
							<a href="javascript:lookXX(${OrderBean.order_id });"><img src="${basePath}common/admin/images/正确.png">订单详情</a>
						</td>
						<td>
							<a href="javascript:sendGoods(${OrderBean.order_id },${OrderBean.order_state});"><img src="${basePath}common/admin/images/正确.png">
						
							<c:if test="${OrderBean.order_state==3}">已签收</c:if>
							<c:if test="${OrderBean.order_state==2}">已发货</c:if>
							<c:if test="${OrderBean.order_state==1}">发货</c:if>
							<c:if test="${OrderBean.order_state==0}">未付款</c:if> 
							
							</a>
							<%-- <a href="${basePath}page/admin/page/gclass/gclassServlet?method=findById&gclass_id=${gclassBean.gclass_id }"><img src="${basePath}common/admin/images/修改.png">发货</a> --%>
							<%-- <a href="${basePath}page/admin/page/gclass/gclassServlet?method=delete&gclass_ids=${gclassBean.gclass_id }"><img src="${basePath}common/admin/images/删除／数字面板编辑态.png">删除</a> --%>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			
			<%-- <div style="text-align: center;">
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
			</div> --%>
		</div>
	</div>
</div>
	
	<%-- <div id="mask">
		<div class="alert-box radius8" style="width: 700px;text-align: center;margin-left: -390px;margin-top: -196px;">
			<h3 class="fs20" style="width: 100%;">
				订单详情 <span class="close"></span>
			</h3>
			<div class="address-form box-s">
			<div hidden="hidden">
				<%=request.getSession().getAttribute("Myordersxxlist") %>
			</div> 
			<c:forEach items="${Myordersxxlist1 }" var="goodsBean" varStatus="aa"  >
					<p class="mb20 clearfix">
						编号：${aa.index+1 }&nbsp;&nbsp;&nbsp;&nbsp;
						商品：${goodsBean.goods_name }&nbsp;&nbsp;&nbsp;&nbsp;
						数量：${goodsBean.goods_number }&nbsp;&nbsp;&nbsp;&nbsp;
						价格：${goodsBean.goods_price }
					</p>
			</c:forEach>

			</div>
		</div>
	</div> --%>
	<script src="${basePath}common/admin/bootstrap-3.3.7-dist/js/jquery-3.2.1.min.js"></script>
<script src="${basePath}common/admin/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="${basePath}common/user/js/other.js" type="text/javascript"></script>
<script type="text/javascript">
/* $(function() {
	$("#mask .close").click(function() {
		$("#mask").hide();
	})
}); */
	/* function remove(){
		
		var gclass_ids=document.getElementsByName("gclass_ids");
		
		var gclass_url = "${basePath}page/admin/page/gclass/gclassServlet?method=delete";
		
		for (var i = 0; i < gclass_ids.length; i++) {
			
			if(gclass_ids[i].checked==true){
				
				gclass_url+="&gclass_ids="+gclass_ids[i].value;
			}
		}
		
		window.location.href=gclass_url;
		
		
	} */

	function lookXX(order_id){
		var str="";		
		var head="                                              订单详情"+"\n";		
		var evergoods ="";
		$.ajax({
			type : "post",
			url : "${basePath}page/user/page/ordersxx/ordersServlet?method=getPageByOrderId&order_id="+order_id,
			dataType : "json",
			success:function(Myordersxxlist){	
				//alert(Myordersxxlist[0].goods_name);
			  //request.setAttribute("Myordersxxlist1",Myordersxxlist1);
			//  var arr = eval(Myordersxxlist);
			<%-- var a= <%="Myordersxxlist" %>; --%>
			for(var i=0;i<Myordersxxlist.length;i++){
				evergoods= "编号："+(i+1)+"    商品名："+Myordersxxlist[i].goods_name+"      商品数量："+Myordersxxlist[i].goods_number+"    商品价格："+Myordersxxlist[i].goods_price+"    商品小计："+Myordersxxlist[i].goods_price*Myordersxxlist[i].goods_number+"\n";
				str=str+evergoods;
			}
				alert(head+str);
				//$("#mask").stop().show();
			},
			error: function(e) {
				alert("失败");
			}
		});
		
		
}
	function sendGoods(order_id,order_state){
		var str=""
		<c:if test="${OrderBean.order_state==3}">已收货</c:if>
		<c:if test="${OrderBean.order_state==2}">已发货</c:if>
		<c:if test="${OrderBean.order_state==1}">待发货</c:if>
		<c:if test="${OrderBean.order_state==0}">未付款</c:if> 
		if(order_state==0){
			str="对方还未付款确定发货？"
		}else if(order_state==1){
			str="确定发货？"
		}else if(order_state==2){
			alert("已经发货了");
		}else if(order_state==3){
			alert("对方已经签收");
		}
		if(order_state==0||order_state==1){
			var r=confirm(str);
			if (r==true)
			{
				$.ajax({
					type : "post",
					url : "${basePath}page/admin/page/orders/adminOrdersServlet?method=fahuo&order_id="+order_id,
					dataType : "json",
					success:function(){
						alert("发货成功");
						window.location.reload();
					},
					error: function(e) {
						alert("发货失败");
					}
				});
			}
			else
			{
			    x="你按下了\"取消\"按钮!";
			} 
		}
		
		
}
	
</script>
</body>
</html>