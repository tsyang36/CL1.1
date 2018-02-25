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
		<title>购物车</title>
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
							<a href="#" class="box-s">
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
					<a href="index.html"></a>
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
			<div class="wrapper">
				<div class="shopping-list pt40 pb40">
					<table class="table_1 table_shopping white-box">
						<tr>
							<th width="40%">商品</th>
							<th width="18%">单价(元)</th>
							<th width="14%">数量</th>
							<th width="14%">小计(元)</th>
							<th width="14%">操作</th>
						</tr>
						
						<c:forEach items="${carlist}" var="carBean">
						<tr>
							<td>

								<p class="o-goods-info ml20 clearfix pt10 pb10">
								<%-- <input type="hidden" name = "goods_id" value="${carBean.goodsBean.goods_id}">  --%>
									<a href="#" class="fl"><span><img src="${basePath}upload/${carBean.goodsBean.goods_image}" alt=""></span></a>
									<span class="fl tit mt5 ml10">${carBean.goodsBean.goods_desc}</span>
								</p>
							</td>
							<td>${carBean.goodsBean.goods_price}</td>
							<td>
								<p class="count clearfix">
									<a href="${basePath}page/user/page/car/carServlet?method=addOrupdate&goods_id=${carBean.goodsBean.goods_id}&goods_number=${carBean.goods_number-1}" class="fl fs30 reduction">-</a>
									<input type="text" value="" class="fl fs16" placeholder="${carBean.goods_number }">
									<a href="${basePath}page/user/page/car/carServlet?method=addOrupdate&goods_id=${carBean.goodsBean.goods_id}&goods_number=${carBean.goods_number+1}" class="fl fs30 add">+</a>
								</p>
							</td>
							<td><span class="orange">${carBean.goodsBean.goods_price*carBean.goods_number }</span></td>
							<td>
								<a href="${basePath }page/user/page/car/carServlet?method=delete&goods_id=${carBean.goodsBean.goods_id}"><i class="iconfont fs26">&#xe60b;</i></a>
							</td>
						</tr>
						</c:forEach>
						
						
					</table>
					<div class="shopping-result white-box mt20 clearfix">
						<a href="${basePath }page/goodsServlet?method=sousuo" class="fl fs16 pl10">继续购物>></a>
						<p class="fr">
							<a href="${basePath }page/user/page/jiesuan/addrServlet?method=findByUserId" class="fr orange-but fs20">去结算</a>
							<span class="fr pr20 fs14">总计：<em class="orange fs24">¥${sum[1] }.00</em></span>
							<span class="fr pr20 fs14">总数量：<em class="orange fs24">¥${sum[0] }</em></span>
						</p>
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
	</body>
<script type="text/javascript">
		function find(){

			
			document.getElementById("form").submit();	
			
		}
	</script>
</html>