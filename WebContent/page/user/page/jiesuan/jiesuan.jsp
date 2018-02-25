<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%@include file="../../../../common/admin/jsp/head.jsp"%>
<html>

<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta charset='utf-8'>
<meta http-equiv="Cache-Control" content="no-siteapp" />
<title>结算</title>
<meta name="viewport"
	content="width=device-width,initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta http-equiv="Cache-Control" content="no-siteapp">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="stylesheet" type="text/css"
	href="${basePath}common/user/css/base.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}common/user/css/common.css" />
<script src="${basePath}common/user/js/jquery-1.8.3.min.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${basePath}common/user/js/jquery.SuperSlide.2.1.js"></script>

<script type="text/javascript">
	$(function() {

		province();
	})

	function province() {
		$.ajax({
			type : "post", //选择请求方式
			url : "jlServlet", //请求地址
			data : "method=province", //传给服务器端的数据
			dataType : "JSON", //服务器端响应数据格式
			success : function(msg) { //请求成功后   msg(服务器传过来的数据接收对象)

				var province = [];
				/* $("select[name=province]") */
				for (var i = 0; i < msg.length; i++) {
					
					
					if('${addrBean.addr_province}'==(msg[i][1])){
						province.push("<option value='"+msg[i][0]+"' selected='selected'>"+msg[i][1]+"</option>");
						}else{
						province.push("<option value='"+msg[i][0]+"'>"+msg[i][1]+"</option>");
						}
					}

				$("#province").html(province.join(""));

				city2($("#province").val());
			}

		});

	}

	function city2(provinceId) {

		$.ajax({
			type : "post", //选择请求方式
			url : "jlServlet", //请求地址
			data : "method=city&provinceId=" + provinceId, //传给服务器端的数据
			dataType : "JSON", //服务器端响应数据格式
			success : function(msg) { //请求成功后   msg(服务器传过来的数据接收对象)

				var city = [];

				/* $("select[name=province]") */

				for (var i = 0; i < msg.length; i++) {
					
					if('${addrBean.addr_city}'==(msg[i][1])){
								
								city.push("<option value='"+msg[i][0]+"' selected='selected'>"+msg[i][1]+"</option>");
						}else{
								city.push("<option value='"+msg[i][0]+"'>"+msg[i][1]+"</option>");
						}
					
					}

				$("#city").html(city.join(""));

				district2($("#city").val());
			}

		});

	}

	function district2(cityId) {

		$.ajax({
			type : "post", //选择请求方式
			url : "jlServlet", //请求地址
			data : "method=district&cityId=" + cityId, //传给服务器端的数据
			dataType : "JSON", //服务器端响应数据格式
			success : function(msg) { //请求成功后   msg(服务器传过来的数据接收对象)

				var district = [];

				/* $("select[name=province]") */

				for (var i = 0; i < msg.length; i++) {
					if('${addrBean.addr_district}'==(msg[i][1])){
						
						district.push("<option value='"+msg[i][0]+"'  selected='selected'>"+msg[i][1]+"</option>");
							}else{
						district.push("<option value='"+msg[i][0]+"'>"+msg[i][1]+"</option>");
							}
						
					}

				$("#district").html(district.join(""));
			}

		});

	}
	function province2(addrBean) {
		$.ajax({
			type : "post", //选择请求方式
			url : "jlServlet", //请求地址
			data : "method=province", //传给服务器端的数据
			dataType : "JSON", //服务器端响应数据格式
			success : function(msg) { //请求成功后   msg(服务器传过来的数据接收对象)

				var province = [];
				/* $("select[name=province]") */
				for (var i = 0; i < msg.length; i++) {
					
					
					if(addrBean.addr_province==(msg[i][1])){
						province.push("<option value='"+msg[i][0]+"' selected='selected'>"+msg[i][1]+"</option>");
						}else{
						province.push("<option value='"+msg[i][0]+"'>"+msg[i][1]+"</option>");
						}
					}

				$("#province").html(province.join(""));

				city3($("#province").val(),addrBean);
			}

		});

	}

	function city3(provinceId,addrBean) {

		$.ajax({
			type : "post", //选择请求方式
			url : "jlServlet", //请求地址
			data : "method=city&provinceId=" + provinceId, //传给服务器端的数据
			dataType : "JSON", //服务器端响应数据格式
			success : function(msg) { //请求成功后   msg(服务器传过来的数据接收对象)

				var city = [];

				/* $("select[name=province]") */

				for (var i = 0; i < msg.length; i++) {
					
					if(addrBean.addr_city==(msg[i][1])){
								
								city.push("<option value='"+msg[i][0]+"' selected='selected'>"+msg[i][1]+"</option>");
						}else{
								city.push("<option value='"+msg[i][0]+"'>"+msg[i][1]+"</option>");
						}
					
					}

				$("#city").html(city.join(""));

				district3($("#city").val(),addrBean);
			}

		});

	}

	function district3(cityId,addrBean) {

		$.ajax({
			type : "post", //选择请求方式
			url : "jlServlet", //请求地址
			data : "method=district&cityId=" + cityId, //传给服务器端的数据
			dataType : "JSON", //服务器端响应数据格式
			success : function(msg) { //请求成功后   msg(服务器传过来的数据接收对象)

				var district = [];

				/* $("select[name=province]") */

				for (var i = 0; i < msg.length; i++) {
					if(addrBean.addr_district==(msg[i][1])){
						
						district.push("<option value='"+msg[i][0]+"'  selected='selected'>"+msg[i][1]+"</option>");
							}else{
						district.push("<option value='"+msg[i][0]+"'>"+msg[i][1]+"</option>");
							}
						
					}

				$("#district").html(district.join(""));
			}

		});

	}
</script>

</head>

<body>
	<!--header star-->
	<div class="header clearfix">
		<div class="top clearfix">
			<div class="topctent clearfix">
				<div class="left clearfix fl">公告：您好，欢迎登录北京椿龄文化发展有限公司</div>
				<div class="right clearfix fr">
					<div class="zuo clearfix fl">
						<ul class="clearfix fl">
							<li>
									<span class="fl">欢迎</span> <a href="${basePath}page/user/page/ordersxx/ordersServlet?method=getpage"
								class="fl">${userBean.user_tel}</a> <span class="fl">进入商城</span>
								</li>
								<li><a href="${basePath}page/user/login/userServlet?method=exit"> 退出登录</a></li>
								<li>
									<a href="${basePath }page/user/login/reg.jsp">
										免费注册
									</a>
								</li>
						</ul>
					</div>
					<div class="shopcar-btn clearfix fl">
						<a href="${basePath }page/user/page/car/carServlet?method=showlist" class="box-s"> 购物车 </a>
					</div>
					<div class="fenxiang clearfix fl">
						<span class="fl">分享到：</span>
						<ul class="clearfix fl">
							<li><a href="#"><img
									src="${basePath}common/user/img/sina.png" /></a></li>
							<li><a href="#"><img
									src="${basePath}common/user/img/qq.png" /></a></li>
							<li><a href="#"><img
									src="${basePath}common/user/img/wechat.png" /></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="bottom clearfix">
			<div class="logo clearfix">
				<a href="index.html"></a>
			</div>
			<form action="${basePath }page/goodsServlet?method=sousuo" method="post" name ="form1" id="form1">
			<div class="search clearfix fr ra5">
				<input type="text" class="fl" name="sousuo" id="sousuo" value=""
					placeholder="请输入您要搜索的内容" /> <input type="button" name=""
					value="搜索" class="fl box-s" onclick="find();"/>
			</div>
			</form>
		</div>
	</div>
	<!--header end-->

	<!--navbar star-->
	<div class="navbar clearfix">
		<div class="content clearfix">
			<ul>
				<li class="cur"><a
					href="${basePath }page/goodsServlet?method=home">首页</a></li>
				<li><a href="${basePath }page/goodsServlet?method=sousuo">商城</a>
				</li>
				<li>
						<a href="${basePath}page/user/page/ordersxx/ordersServlet?method=getpage">个人中心</a>
					</li>
			</ul>
		</div>
	</div>
	<!--navbar end-->

	<!--Main-wrap-->
	<div class="main-wrap graybg pt40 pb40">
		<div class="js-box wrapper white-box">
			<!--收货人信息-->
			<div class="consignee-info">
				<div class="title line-bot">
					<span class="fs18 pl20 ml40 darkgray">收货人地址</span>
				</div>
				<div class="consignee-box clearfix">

					<c:forEach items="${addrlist}" var="addrBean">
						<div class="consignee-block check-box radius5" id = "checkaddr">  
						    <input hidden="hidden" type="text" value="${addrBean.addr_id }" id="addr_id" name="addr_id" />
							<!-- check_on  -->
							<em></em>
							<p class="fs14 lh40 clearfix">
								<span class="fl darkgray"><i class="iconfont fs24">&#xe60e;</i>${addrBean.addr_name }</span>
								
								<a
									href="javascript:openbox(${addrBean.addr_id });"
									class="fr green edit"><i class="iconfont fs24 green">&#xe60f;</i>编辑</a>
								<%-- <a
									href="${basePath}page/user/page/jiesuan/addrServlet?method=findByAddrId&addr_id=${addrBean.addr_id }"
									class="fr green edit"><i class="iconfont fs24 green">&#xe60f;</i>编辑</a> --%>
								<a
									href="javascript:del(${addrBean.addr_id });"
									class="fr green edit"><i class="iconfont fs24 green">&#xe60b;</i>删除</a>
								
							</p>
							<p class="fs14 darkgray lh40">
								<i class="iconfont fs24">&#xe60c;</i>${addrBean.tel } </p>
							<p class="fs14 darkgray lh30 clearfix">
								<i class="fl iconfont fs24">&#xe610;</i><span class="fl address">${addrBean.addr_province }${addrBean.addr_city }${addrBean.addr_district }${addrBean.addrxx }</span>
							</p>
						</div>
					</c:forEach>

					<div class="consignee-block radius5 tc add-info">
						<a href="javascript:openbox1();" class="full-db "> <span
							class="full-db add pt40"></span> <span class="full-db fs14">添加新地址</span>
						</a>
					</div>
				</div>
			</div>
			<!--/end-->

<%-- <a
									href="${basePath}page/user/page/jiesuan/addrServlet?method=del&addr_id=${addrBean.addr_id }"
									class="fr green edit"><i class="iconfont fs24 green">&#xe60f;</i>删除</a> --%>

			<!--goodssale-->
			<div class="goodssale">
				<div class="title line-bot">
					<span class="fs18 pl20 ml40 darkgray">商品信息</span>
				</div>
				<table class="table_1 table_goods" border="0" cellpadding="0"
					cellspacing="0">

					<c:if test="${goodsBean ==null}">
						<c:forEach items="${carlist}" var="carBean">
							<tr class="line-bot">
								<td>
									<p class="o-goods-info clearfix  ">
										<a href="#" class="fl"><span><img
												src="${basePath}upload/${carBean.goodsBean.goods_image}"
												alt=""></span></a> <span class="fl tit mt5 ml10">${carBean.goodsBean.goods_desc}</span>
									</p>
								</td>
								<td>${carBean.goodsBean.goods_price}*${carBean.goods_number }</td>
								<td></td>
								<td>有货</td>
								<td></td>
								<td><span class="orange">${carBean.goodsBean.goods_price*carBean.goods_number }</span></td>
							</tr>
						</c:forEach>
					</c:if>

					<c:if test="${goodsBean !=null}">
						<tr class="line-bot">
							<td>
								<p class="o-goods-info clearfix  ">
									<a href="#" class="fl"><span><img
											src="${basePath}upload/${goodsBean.goods_image}" alt=""></span></a>
									<span class="fl tit mt5 ml10">${goodsBean.goods_desc}</span>
								</p>
							</td>
							<td>${goodsBean.goods_price} * ${addnumber}</td>
							<td></td>
							<td>有货</td>
							<td></td>
							<td><span class="orange">${goodsBean.goods_price * addnumber}</span></td>
						</tr>
					</c:if>
					


				</table>
				<div class="sale-info pt10 pb10 clearfix">
					<div class="fr total-amount mb30">
						<p class="mt20 fr">
						<c:choose>
						   <c:when test="${goodsBean !=null}">  
						       <span class="fs16 darkgray clearfix">商品总价：<em
									class="fr orange fs24 f-arial">¥${goodsBean.goods_price * addnumber}.00</em></span> 
						   </c:when>
						   <c:otherwise> 
						     <span class="fs16 darkgray clearfix">商品总价：<em
									class="fr orange fs24 f-arial">¥${sum[1] }.00</em></span>
						   </c:otherwise>
						</c:choose>
								
						</p>
						<p class="mt10 fr">
						<a href="javascript:ddtj();" class="fr orange-but fs20 radius3">订单提交</a>
						</form>
							
						</p>
					</div>
				</div>
			</div>
			<!--/end-->




		</div>
	</div>
	<!--/end-->

	<!--footer star-->
	<div class="footer clearfix">
			<div class="content clearfix">
				<div class="top clearfix">
					<div class="list clearfix fl box-s">
						<div class="part icon1 box-s">
							<h3>专业</h3>
							<p>拥有资深艺术顾问和先进交易平台，安全物流，快捷支付。</p>
						</div>
					</div>
					<div class="list clearfix fl box-s">
						<div class="part icon2 box-s">
							<h3>保真</h3>
							<p>阵容强大的艺术评鉴团，确保平台上的藏品货真价实。</p>
						</div>
					</div>
					<div class="list clearfix fl box-s">
						<div class="part icon3 box-s">
							<h3>保值</h3>
							<p>为您精选具备艺术价值的作品，助您的资产保值、增值。</p>
						</div>
					</div>
				</div>
				<div class="bottom clearfix">
					<div class="left clearfix fl">
						<div class="list clearfix">
							<div class="shang clearfix">
								<p>新手指南</p>
								<span></span>
							</div>							
							<div class="xia clearfix">
								<ul>
									<li><a href="#">商城购买流程</a></li>
									<li><a href="#">常见问题</a></li>
								</ul>
							</div>
						</div>
						<div class="list clearfix">
							<div class="shang clearfix">
								<p>账户管理</p>
								<span></span>
							</div>							
							<div class="xia clearfix">
								<ul>
									<li><a href="#">账户充值</a></li>
									<li><a href="#">账户提现</a></li>
									<li><a href="#">支付方式</a></li>
								</ul>
							</div>
						</div>						
						<div class="list clearfix">
							<div class="shang clearfix">
								<p>服务合作</p>
								<span></span>
							</div>							
							<div class="xia clearfix">
								<ul>
									<li><a href="#">友情链接</a></li>
									<li><a href="#">艺术家入驻</a></li>
								</ul>
							</div>
						</div>
						<div class="list clearfix">
							<div class="shang clearfix">
								<p>关于我们</p>
								<span></span>
							</div>							
							<div class="xia clearfix">
								<ul>
									<li><a href="#">公司简介</a></li>
									<li><a href="#">联系我们</a></li>
									<li><a href="#">加入我们</a></li>
								</ul>
							</div>
						</div>
						<div class="list clearfix">
							<div class="shang clearfix">
								<p>售后服务</p>
								<span></span>
							</div>							
							<div class="xia clearfix">
								<ul>
									<li><a href="#">物流说明</a></li>
									<li><a href="#">免责声明</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="middle clearfix fl">
						<ul>
							<li><img src="${basePath}upload/ewm.png"/></li>
							<li><img src="${basePath}upload/ewm1.jpeg"/></li>
						</ul>
					</div>
					<div class="right clearfix fr">
						<p class="bt">免费咨询热线：</p>
						<p class="tel">400-000-0000</p>
						<p class="fu-bt">(周一到周五8:00-22:00)</p>
					</div>
				</div>
			</div>
			<div class="banquan clearfix ta-center">
				Copyright © 2017-2018 椿龄文化(chunlingwenhua). All Rights Reserved. 
			</div>
		</div>
	<!--footer end-->

	<div id="mask">
		<div class="alert-box radius8">
			<h3 class="fs20">
				添加收货地址 <span class="close"></span>
			</h3>
			<div class="address-form box-s">
				<form
					action="${basePath }page/user/page/jiesuan/addrServlet?method=add"
					method="post" name="form" id="form">
					<input type="hidden" 
							value=""  name="addr_id" id ="addr_id">
					<p class="mb20 clearfix">
						<label class="fl">收货人：</label> <input type="text" placeholder="姓名"
							value="" placeholder="姓名" class="fl ml5" name="addr_name" id ="addr_name">
						<em class="fl red lh40 ml10">*</em>
					</p>
					<p class="mb20 clearfix">
						<label class="fl">手机：</label> <input type="text" placeholder="手机"
							value="" placeholder="手机" class="fl ml5" name="tel" id = "tel"> <em
							class="fl red lh40 ml10">*</em>
					</p>



					<p class="mb20 clearfix">
						<label class="fl">地址：</label> <select name="add_province"
							id="province" class="fl ml5"
							onchange="city2($('#province').val())">
						</select> <select name="add_city" id="city" class="fl ml5"
							onchange="district2($('#city').val())">
						</select> <select name="add_district" id="district" class="fl ml5">
						</select>
					</p>

					<p class="mb20 clearfix">
						<label class="fl"></label> <input type="text" value=""
							placeholder="详细地址" class="fl ml5" name="addrxx" id="addrxx"> <em
							class="fl red lh40 ml10">*</em>
					</p>
					<p class="mb20 clearfix">
						<label class="fl">邮政编码：</label> <input type="text"
							placeholder="邮政编码" value="" class="fl ml5" name="youbian" id="youbian">
					</p>
					<p class="mb20 clearfix">
						<label class="fl"></label> <input type="button" value="保存"
							class="fl orange-but radius3 ml5" onclick="savaaddr();">
						<input type="button" value="取消" class="fl gray-but radius3 ml10"
							onclick="dontsavaaddr();">
					</p>
				</form>
			</div>
		</div>
	</div>
	<div class="yu">
	  <input hidden="hidden" type="text" value="123" id="addrID" name="addrID" />
	</div>
</body>
<script src="${basePath}common/user/js/other.js" type="text/javascript"></script>
<script type="text/javascript">
	function savaaddr() {
		var addr_id = $("#addr_id").val();
		var addr_name = $("#addr_name").val();
		var tel = $("#tel").val();
		var province = $("#province").val();
		var city = $("#city").val();
		var district = $("#district").val();
		var addrxx = $("#addrxx").val();
		var youbian = $("#youbian").val();
		if(addr_id==""){
			var url = "${basePath }page/user/page/jiesuan/addrServlet?method=add"
		}else{
			var url = "${basePath }page/user/page/jiesuan/addrServlet?method=updateaddr"
		}
		
		$.ajax({
			type : "post",
			url : url,
			data : {"addr_id": addr_id,"addr_name": addr_name, "tel": tel, "province": province, "city": city, "district": district, "addrxx": addrxx, "youbian": youbian},
			dataType : "json",
			success:function(data){						
				window.location.reload();   // 刷新当前页面数据 
			},
			error: function(e) {
				alert("失败");
				window.location.reload();   // 刷新当前页面数据 
			}
		});
		//document.getElementById("form").submit();
	}
	function dontsavaaddr() {
		$("#mask").hide();
	}
	function find(){
		document.getElementById("form1").submit();	
	}
	function ddtj(){
		var addr_id = $(".check_on input[name='addr_id']").val();
		if(addr_id == undefined || addr_id==null){
			alert("请选择地址后再提交订单");
		}else{
		window.location.href = "${basePath }page/user/page/orders/ordersServlet?method=add&addr_id="+addr_id+"&goods_id=${goodsBean.goods_id}&addnumber=${addnumber}";
		}
		
	}
	function del(addr_id){
			var r=confirm("确认删除吗？");
			if (r==true){
				$.ajax({
					type : "post",
					url : "${basePath}page/user/page/jiesuan/addrServlet?method=del&addr_id="+addr_id,
					dataType : "json",
					success:function(data){						
						window.location.reload();   // 刷新当前页面数据 
					},
					error: function(e) {
						alert("失败");
						window.location.reload();   // 刷新当前页面数据 
					}
				});
			}
			
				
			//alert("删除成功！");
		
	}
	function openbox(addr_id) {
		$.ajax({
			type : "post",
			url : "${basePath}page/user/page/jiesuan/addrServlet?method=findByAddrId&addr_id="+addr_id,
			dataType : "json",
			scriptCharset: 'utf-8',
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			success:function(addrBean){	
				//alert(addrBean.addr_city);
				//alert(JSON.stringify(addrBean));
				$("#addr_id").val(addrBean.addr_id);
				$("#addr_name").val(addrBean.addr_name);
				$("#tel").val(addrBean.tel);
				$("#addrxx").val(addrBean.addrxx);
				
				province2(addrBean);
				 /*  $("#province option:contains("+addrBean.addr_province+")").prop('selected', true);
				  	city2($("#province").val());
				 $("#city option:contains("+addrBean.addr_city+")").prop('selected', true);
				 	district2($("#city").val());
				 $("#district option:contains("+addrBean.addr_district+")").prop('selected', true); 
				$("#youbian").val(addrBean.youbian); */
				$("#mask").show();
			}
			
		});		
		
		
	}
	function openbox1() {//添加时先清空原先的内容
		province();
		$("#addr_id").val("");
		$("#province").val("");
		$("#city").val("");
		$("#district").val("");
		$("#addr_name").val("");
		$("#tel").val("");
		$("#addrxx").val("");
		$("#youbian").val("");
		$("#mask").show();
	}
</script>
</html>