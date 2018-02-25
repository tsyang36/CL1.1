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
<title>收货地址</title>
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
	<script src="${basePath}common/admin/js/check.js"></script>
<script type="text/javascript">
	$(function(){
		
		province();
	})
	
	function province(){
		
		$.ajax({
			type:"post",		//选择请求方式
			url:"jlServlet",    //请求地址
			data:"method=province", //传给服务器端的数据
			dataType:"JSON",		//服务器端响应数据格式
			success:function(msg){  //请求成功后   msg(服务器传过来的数据接收对象)
				
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
				$("#province1").html(province.join(""));
				
				city2($("#province").val());
				city2($("#province1").val());
			}
			
		});
		
		
	}
	
	function city2(provinceId){
		
		$.ajax({
			type:"post",		//选择请求方式
			url:"jlServlet",    //请求地址
			data:"method=city&provinceId="+provinceId, //传给服务器端的数据
			dataType:"JSON",		//服务器端响应数据格式
			success:function(msg){  //请求成功后   msg(服务器传过来的数据接收对象)
				
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
				$("#city1").html(city.join(""));
				
				district2($("#city").val());
				district2($("#city1").val());
			}
			
		});
		
		
	}
	
function district2(cityId){
		
		$.ajax({
			type:"post",		//选择请求方式
			url:"jlServlet",    //请求地址
			data:"method=district&cityId="+cityId, //传给服务器端的数据
			dataType:"JSON",		//服务器端响应数据格式
			success:function(msg){  //请求成功后   msg(服务器传过来的数据接收对象)
					
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
				$("#district1").html(district.join(""));
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
					<div class="left clearfix fl">
						公告：您好，欢迎登录北京椿龄文化发展有限公司
					</div>
					<div class="right clearfix fr">
						<div class="zuo clearfix fl">
							<ul class="clearfix fl">
								<li>
									<span class="fl">欢迎</span>
									<a href="${basePath}page/user/page/ordersxx/ordersServlet?method=getpagex" class="fl">${userBean.user_tel}</a>
									<span class="fl">进入商城</span>
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
							<a href="${basePath }page/user/page/car/carServlet?method=showlist" class="box-s">
								购物车
							</a>
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
					<a href="${basePath }page/goodsServlet?method=home"></a>
				</div>
				<form action="${basePath }page/goodsServlet?method=sousuo" method="post" name ="form" id="form">
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
					<li class="cur">
						<a href="${basePath }page/goodsServlet?method=home">首页</a>
					</li>
					<li>
						<a href="${basePath }page/goodsServlet?method=sousuo">商城</a>
					</li>
					<li>
						<a href="${basePath}page/user/page/ordersxx/ordersServlet?method=getpage">个人中心</a>
					</li>
				</ul>
			</div>
		</div>
		<!--navbar end-->

		<!--Main-wrap-->
		<div class="main-wrap graybg">
			<div class="wrapper pt40 pb40 clearfix">
				<div class="fl slide-nav white-box">
					<ul>
						<li>
							<a href="${basePath}page/user/page/ordersxx/ordersServlet?method=getpage" class="db fs16">我的订单</a>
						</li>
						<li class="on">
							<a href="${basePath}page/user/page/jiesuan/addrServlet?method=getaddrByUserId" class="db fs16">收货地址</a>
							<%-- <a href="${basePath }page/user/page/jiesuan/addrServlet?method=findByUserId&a=1" class="db fs16">收货地址</a> --%>
						</li>
						<li>
							<a href="${basePath }page/user/login/userServlet?method=toupdatepassword" class="db fs16">修改密码</a>
						</li>
						<li>
							<a href="zixun.html" class="db fs16" title="">我的咨询</a>
						</li>
						<li>
							<a href="znx.html" class="db fs16">站内信</a>
						</li>
					</ul>
				</div>
				<div class="fr slide-show white-box">
					<div class="dark-tit line-bot">
						<h3 class="fs26">收货地址</h3></div>
					<div class="add-address fs14 mt20 mb30">
						<form action="${basePath }page/user/page/jiesuan/addrServlet?method=add&a=1"
						method="post" name="addrform" id="addrform">
							<input type="hidden" name = "addr_id" id ="addr_id" value="${addrBean.addr_id }">
							<p class="address-tit mb20 clearfix"><i class="fl iconfont tc">&#xe611;</i><span class="fl fs16 bold orange ml5">新增收货地址</span></p>
							<p class="mb20 clearfix">
								<label class="fl"><em class="red">*</em>收件人：</label>
								<input type="text" placeholder="姓名" value="${addrBean.addr_name }" name="addr_name" id="addr_name" class="fl">
								<label class="fl"><em class="red">*</em>联系方式：</label>
								<input type="text" placeholder="手机" value="${addrBean.tel }" name = "tel"  id= "tel" class="fl">
							</p>
							<p class="mb20 clearfix">
							<label class="fl"><em class="red f-arial">*</em>地址：</label> <select
								name="add_province" id="province" class="fl"
								onchange="city2($('#province').val())">
								<option value="0" selected="selected">${addrBean.addr_province }</option>
							</select> <select name="add_city" id="city" class="fl ml10"
								onchange="district2($('#city').val())">
							</select> <select name="add_district" id="district" class="fl ml10">
							</select>
							</p>
							<p class="mb20 clearfix">
							<label class="fl">&nbsp;</label>
							<textarea name="addrxx" id="addrxx" cols="30" rows="10" 
								placeholder="请输入您的详细地址" class="fl">${addrBean.addrxx }</textarea>
							</p>
							<p class="mb20 clearfix">
								<label class="fl">邮政编码：</label> <input type="text" name = "youbian"  id= "youbian"
								placeholder="邮政编码" value="${addrBean.youbian }" class="fl">
							</p>
							<p class="mb20 clearfix">
							<label class="fl">&nbsp;</label> 
							<input type="button" value="确认"
								class="fl orange-but radius3 fs16"
								onclick="savaaddr();" >
								<input type="button" value="取消" class="fl reset-but radius3 fs16 ml10"  onclick="dontsavaaddr();">
								<div style="color: red;text-align: center;" id="message1"><%=request.getAttribute("message1")==null?"":request.getAttribute("message1") %></div>
							</p>
						</form>
					</div>
					<div class="saved-address">
						<p class="address-tit mb10 clearfix"><i class="fl iconfont tc">&#xe610;</i><span class="fl fs16 bold orange ml5">已保存收货地址</span></p>
						<table class="ye-table address-table" style="border:1px solid #eaeaea">
							<tr>
								<th width="10%">收货人</th>
								<th width="60%">收货地址</th>
								<th width="10%">电话</th>
								<th width="20%">操作</th>
							</tr>
							
							
							<c:forEach items="${addrlist}" var="addrBean">
							<tr>
								<td>${addrBean.addr_name }</td>
								<td>${addrBean.addr_province }${addrBean.addr_city }${addrBean.addr_district }${addrBean.addrxx }</td>
								<td>${addrBean.tel }</td>
								<td>
									<a href="javascript:del(${addrBean.addr_id });" class="pl10"><i class="iconfont">&#xe60b;</i><em class="orange">删除</em></a>
									<a href="javascript:openbox(${addrBean.addr_id });" class="pl10"><i class="iconfont">&#xe60f;</i><em class="orange">编辑</em></a>
									<%-- <a href="${basePath}page/user/page/jiesuan/addrServlet?method=findByAddrId&addr_id=${addrBean.addr_id }" class="pl10"><i class="iconfont">&#xe60f;</i><em class="orange">编辑</em></a> --%>
								</td>
							</tr>
					</c:forEach>
							
							
						</table>
					</div>

				</div>

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
							value=""  name="addr_id" id ="addr_id1">
					<p class="mb20 clearfix">
						<label class="fl">收货人：</label> <input type="text" placeholder="姓名"
							value="" placeholder="姓名" class="fl ml5" name="addr_name" id ="addr_name1">
						<em class="fl red lh40 ml10">*</em>
					</p>
					<p class="mb20 clearfix">
						<label class="fl">手机：</label> <input type="text" placeholder="手机"
							value="" placeholder="手机" class="fl ml5" name="tel" id = "tel1"> <em
							class="fl red lh40 ml10">*</em>
					</p>



					<p class="mb20 clearfix">
						<label class="fl">地址：</label> <select name="add_province"
							id="province1" class="fl ml5"
							onchange="city2($('#province1').val())">
						</select> <select name="add_city" id="city1" class="fl ml5"
							onchange="district2($('#city1').val())">
						</select> <select name="add_district" id="district1" class="fl ml5">
						</select>
					</p>

					<p class="mb20 clearfix">
						<label class="fl"></label> <input type="text" value=""
							placeholder="详细地址" class="fl ml5" name="addrxx" id="addrxx1"> <em
							class="fl red lh40 ml10">*</em>
					</p>
					<p class="mb20 clearfix">
						<label class="fl">邮政编码：</label> <input type="text"
							placeholder="邮政编码" value="" class="fl ml5" name="youbian" id="youbian1">
					</p>
					<p class="mb20 clearfix">
						<label class="fl"></label> <input type="button" value="保存"
							class="fl orange-but radius3 ml5" onclick="updateaddr();">
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
<script type="text/javascript">
	function savaaddr() {
		var addr_name = $("#addr_name").val();
		var tel = $("#tel").val();
		var province = $("#province").val();
		var city = $("#city").val();
		var district = $("#district").val();
		var addrxx = $("#addrxx").val();
		var youbian = $("#youbian").val();
		var url = "${basePath }page/user/page/jiesuan/addrServlet?method=add"
		if(isNull(addr_name)){
			$("#message1").val("用户名不能为空");
		}else if(isNull(tel)){
			$("#message1").val("手机号不能为空");
		}else if(!checkMobile(tel)){
			$("#message1").val("手机格式不正确");
		}else{
			$.ajax({
				type : "post",
				url : url,
				data : {"addr_name": addr_name, "tel": tel, "province": province, "city": city, "district": district, "addrxx": addrxx, "youbian": youbian},
				dataType : "json",
				success:function(data){						
					$("#addr_name").val("");
					$("#tel").val("");
					$("#province").val("");
					$("#city").val("");
					$("#district").val("");
					$("#addrxx").val("");
					$("#youbian").val("");
					window.location.reload();   // 刷新当前页面数据
				},
				error: function(e) {
					alert("失败");
					window.location.reload();   // 刷新当前页面数据 
				}
			});
		}
	}
	function updateaddr() {
		var addr_id = $("#addr_id1").val();
		var addr_name = $("#addr_name1").val();
		var tel = $("#tel1").val();
		var province = $("#province1").val();
		var city = $("#city1").val();
		var district = $("#district1").val();
		var addrxx = $("#addrxx1").val();
		var youbian = $("#youbian1").val();
		var url = "${basePath }page/user/page/jiesuan/addrServlet?method=updateaddr"
		
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
	}
	function dontsavaaddr() {
		$("#mask").hide();
	}
	function find(){

		
		document.getElementById("form").submit();	
		
	}
	
	function openbox(addr_id) {
		$(".close").click(function() {
			$("#mask").hide();
		})
		$.ajax({
			type : "post",
			url : "${basePath}page/user/page/jiesuan/addrServlet?method=findByAddrId&addr_id="+addr_id,
			dataType : "json",
			scriptCharset: 'utf-8',
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			success:function(addrBean){	
				$("#addr_id1").val(addrBean.addr_id);
				$("#addr_name1").val(addrBean.addr_name);
				$("#tel1").val(addrBean.tel);
				$("#addrxx1").val(addrBean.addrxx);
				 $("#province1 option:contains("+addrBean.addr_province+")").prop('selected', true);
				  	city2($("#province1").val());
				 $("#city1 option:contains("+addrBean.addr_city+")").prop('selected', true);
				 	district2($("#city1").val());
				 $("#district1 option:contains("+addrBean.addr_district+")").prop('selected', true);
				$("#youbian1").val(addrBean.youbian);
			}
			
		});		
		
		
		$("#mask").show();
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
	</script>	
</html>