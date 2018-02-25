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
		<title>我的订单</title>
		<meta name="viewport" content="width=device-width,initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta http-equiv="Cache-Control" content="no-siteapp">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link rel="stylesheet" type="text/css" href="${basePath}common/user/css/base.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}common/user/css/common.css" />
		<script src="${basePath}common/user/js/jquery-1.8.3.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="${basePath}common/user/js/jquery.SuperSlide.2.1.js"></script>
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
							<a href="${basePath }page/user/page/car/carServlet?method=showlist" class="box-s">
								购物车
							</a>
						</div>
						<div class="fenxiang clearfix fl">
							<span class="fl">分享到：</span>
							<ul class="clearfix fl">
								<li>
									<a href="#"><img src="${basePath}common/user/img/sina.png" /></a>
								</li>
								<li>
									<a href="#"><img src="${basePath}common/user/img/qq.png" /></a>
								</li>
								<li>
									<a href="#"><img src="${basePath}common/user/img/wechat.png" /></a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="bottom clearfix">
				<div class="logo clearfix">
					<a href="#"></a>
				</div>
				<form action="${basePath }page/goodsServlet?method=sousuo" method="post" name ="form" id="form">
			<div class="search clearfix fr ra5">
				<input type="text" class="fl" name="goods_name" id="goods_name" value=""
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
						<!-- <li>
							<a href="grxx.html" class="db fs16">个人信息</a>
						</li> -->
						<li class="on">
							<a href="${basePath}page/user/page/ordersxx/ordersServlet?method=getpage" class="db fs16">我的订单</a>
						</li>
						<li>
							<a href="${basePath}page/user/page/jiesuan/addrServlet?method=getaddrByUserId" class="db fs16">收货地址</a>
							<%-- <a href="${basePath}page/user/page/jiesuan/addrServlet?method=findByUserId" class="db fs16">收货地址</a> --%>
						</li>
						<li>
							<a href="${basePath }page/user/login/userServlet?method=toupdatepassword" class="db fs16">修改密码</a>
						</li>
						<li>
							<a href="#" class="db fs16">我的咨询</a>
						</li>
						<li>
							<a href="#" class="db fs16">站内信</a>
						</li>
						<!-- <li>
							<a href="pjsd.html" class="db fs16">评价晒单</a>
						</li>
						<li>
							<a href="shdz.html" class="db fs16">收货地址</a>
						</li>
						<li>
							<a href="wdsc.html" class="db fs16">我的收藏</a>
						</li>
						<li>
							<a href="wdgz.html" class="db fs16">我的关注</a>
						</li>
						<li>
							<a href="xgmm.html" class="db fs16">修改密码</a>
						</li>
						<li>
							<a href="zhye.html" class="db fs16">账户余额</a>
						</li>
						<li>
							<a href="zxcz.html" class="db fs16">在线充值</a>
						</li>
						<li>
							<a href="lljl.html" class="db fs16">退货记录</a>
						</li>
						<li>
							<a href="zixun.html" class="db fs16">我的咨询</a>
						</li>
						<li>
							<a href="znx.html" class="db fs16">站内信</a>
						</li> -->
					</ul>
				</div>
				<div class="fr slide-show white-box">
					<div class="dark-tit clearfix">
						<h3 class="fl fs26">我的订单</h3>
						<!-- <p class="fr slide-t-nav">
							<a href="#" class="on fs14 radius3">所有订单</a>
							<a href="#" class="fs14 radius3">待支付</a>
							<a href="#" class="fs14 radius3">待收货</a>
						</p> -->
					</div>
					<table class="table_1">
						<tr>
							<th width="30%">商品信息</th>
							<th width="16%">单价（元）</th>
							<th width="15%">数量</th>
							<!-- <th width="15%">收货人</th> -->
							<th width="24%" rowspan="2">订单状态</th>
						</tr>
					</table>
					<c:forEach items="${Myordersxxlist }" var="orderBean">
						<table class="table_1 mt15">
							<tr>
								<th align="left" colspan="6">
									<p class="fs12"><span class="fr pr10">订单金额：${orderBean.orders_sumprice }</span>订单号：${orderBean.order_code }　　　　下单时间：${orderBean.order_time }</p>
								</th>
							</tr>


						<c:forEach items="${orderBean.goodsBeans}" var="goodsBean"
							varStatus="bb">
							<tr>

								<td width="30%">
									<p class="clearfix o-goods-info">
										<a href="#" class="fl"><span><img
												src="${basePath}upload/${goodsBean.goods_image}" alt=""></span></a>
										<span class="fl tit ">${goodsBean.goods_desc}</span>
									</p>
								</td>
								<td width="16%" align="center">￥${goodsBean.goods_price}</td>
								<td width="15%" align="center">${goodsBean.goods_number}</td>
								<c:if test="${bb.first}">

									<c:forEach items="${orderBean.goodsBeans}" var="goodsBean"
										varStatus="aa">
										<c:if test="${aa.last}">
											<td width="24%" rowspan="${aa.count}" align="center"><c:if
													test="${orderBean.order_state==3}">已收货</c:if> <c:if
													test="${orderBean.order_state==2}">
													<a href="javascript:takeGoods(${orderBean.order_id });"><img
														src="${basePath}common/admin/images/正确.png">确认收货</a>
												</c:if> <c:if test="${orderBean.order_state==1}">待发货</c:if> <c:if
													test="${orderBean.order_state==0}">未付款</c:if> <br></td>
										</c:if>
									</c:forEach>
								</c:if>
							</tr>
						</c:forEach>
						<!-- <tr>
								<td>
									<p class="clearfix o-goods-info">
										<a href="#" class="fl"><span><img src="upload/2.jpg" alt=""></span></a>
										<span class="fl tit ">北京椿龄文化墙角一枝梅北京椿龄文化墙角一枝梅</span>
									</p>
								</td>
								<td align="center">￥1100</td>
								<td align="center">1</td>
							</tr> -->
							
							
							
							
						</table>
					</c:forEach>
					<!-- <div class="tab-pages">
						<a href="#" class="tab-prev tab-btn">上一页</a>
						<a href="#" class="page-btn current">1</a>
						<a href="#" class="page-btn">2</a>
						<a href="#" class="page-btn">3</a>
						<a href="#" class="tab-next tab-btn">下一页</a>
					</div> -->

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
	</body>
<script type="text/javascript">
function find(){

	
	document.getElementById("form").submit();	
	
}
function takeGoods(order_id){
	
		var r=confirm("确认收货？");
		if (r==true)
		{
			$.ajax({
				type : "post",
				url : "${basePath}page/user/page/orders/ordersServlet?method=shouhuo&order_id="+order_id,
				dataType : "json",
				success:function(){
					alert("收货成功");
					window.location.reload();
				},
				error: function(e) {
					alert("收货失败");
				}
			});
		}
		else
		{
		    x="你按下了\"取消\"按钮!";
		} 
	
	
	
}
</script>
</html>