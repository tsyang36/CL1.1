<%@page import="com.tsy.cl.main.gclass.dao.GclassDao"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.tsy.cl.main.goods.bean.GoodsBean"%>
<%@page import="com.tsy.cl.main.goods.dao.GoodsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%@include file="../../../common/admin/jsp/head.jsp"%>
<html>

<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta charset='utf-8'>
<meta http-equiv="Cache-Control" content="no-siteapp" />
<title>首页</title>
<meta name="viewport"
	content="width=device-width,initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta http-equiv="Cache-Control" content="no-siteapp">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="stylesheet" type="text/css"
	href="${basePath}common/user/css/page.css" />
<link rel="stylesheet" type="text/css"
	href="${basePath}common/user/css/base.css" />
<script src="${basePath}common/user/js/jquery-1.8.3.min.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${basePath}common/user/js/jquery.SuperSlide.2.1.js"></script>
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
						<c:if test="${userBean !=null}">
						<li><span class="fl">欢迎</span> <a href="${basePath}page/user/page/ordersxx/ordersServlet?method=getpage"
								class="fl">${userBean.user_tel}</a> <span class="fl">进入商城</span></li>
								<li><a href="${basePath}page/user/login/userServlet?method=exit"> 退出登录</a></li>
						</c:if>
						<c:if test="${userBean ==null}">
						<li>你好，请<a href="${basePath }page/user/login/login.jsp"> 登录 </a></li>
						</c:if>
							
							
							<li><a href="${basePath }page/user/login/reg.jsp"> 免费注册 </a></li>
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
				<li class="cur"><a href="${basePath }page/goodsServlet?method=home">首页</a></li>
				<li><a href="${basePath }page/goodsServlet?method=sousuo">商城</a></li>
				<li><a href="${basePath}page/user/page/ordersxx/ordersServlet?method=getpage">个人中心</a></li>
			</ul>
		</div>
	</div>
	<!--navbar end-->

	<!--banner star-->
	<div class="banner">
		<div class="bd">
			<ul>
				<li
					style="background:url(${basePath}upload/banner.jpg) #194982 center 0 no-repeat;"><a
					href="#"></a></li>
			</ul>
		</div>
		<div class="hd">
			<ul></ul>
		</div>
	</div>
	<!--banner end-->

	<!--recom star-->


	<div class="recom clearfix">
		<div class="content clearfix">
			<div class="recom-tit clearfix">
				<p class="engtit ta-center">RECOMMENDS</p>
				<div class="middle clearfix">
					<span class="line"></span> <span class="wenzi">今日推荐</span> <span
						class="line"></span>
				</div>
				<p class="fu-tit">好作品无需多说 你会由心的看清它的诉说</p>
			</div>






			<div class="bottom clearfix box-s">
				<div class="right clearfix fl">
					<c:forEach items="${list}" var="goodsBean">
						<%-- <li class="list l_num02"><a href="${basePath}page/goodsServlet?method=showGoods&id=${goodsBean.id}"><img src="${basePath}upload/${goodsBean.image}" /></a></li>	 --%>

						<div class="listone clearfix fl">
							<a
								href="${basePath}page/goodsServlet?method=showGoods&goods_id=${goodsBean.goods_id}">
								<!--备注：第一张图 宽度：418像素，高度：710像素-->
								<div class="tu clearfix">
									<img src="${basePath}upload/${goodsBean.goods_image}" /> <span></span>
								</div>
								<div class="listxia clearfix ta-center">
									<h2>
										<p>
											${goodsBean.goods_name } <span>${goodsBean.goods_price }<samp>.00</samp></span>
										</p>
									</h2>
								</div>
							</a>
							</li>
						</div>
					</c:forEach>
				</div>


				<div class="right clearfix fr">
					<c:forEach items="${list1}" var="goodsBean">
						<%-- <li class="list l_num02"><a href="${basePath}page/goodsServlet?method=showGoods&id=${goodsBean.id}"><img src="${basePath}upload/${goodsBean.image}" /></a></li>	 --%>

						<div class="listone clearfix fl">
							<a
								href="${basePath}page/goodsServlet?method=showGoods&goods_id=${goodsBean.goods_id}">
								<!--备注：第三张图 宽度：530像素，高度：638像素-->
								<div class="tu clearfix">
									<img src="${basePath}upload/${goodsBean.goods_image}" /> <span></span>
								</div>
								<div class="listxia clearfix ta-center">
									<h2>
										<p>
											${goodsBean.goods_name } <span>${goodsBean.goods_price }<samp>.00</samp></span>
										</p>
									</h2>
								</div>
							</a>
							</li>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<!--recom end-->

	<!--choice star-->
	<div class="choice clearfix">
		<div class="bgdian"></div>
		<div class="recom-tit clearfix">
			<p class="engtit ta-center">SHOPPING MALL</p>
			<div class="middle clearfix">
				<span class="line"></span> <span class="wenzi">商城精选</span> <span
					class="line"></span>
			</div>
			<p class="fu-tit">画品丰富多类 抽象 印象 自然 城市皆有</p>
		</div>
		<div class="content clearfix box-s">
			<a href="#" class="choice-more">MORE+</a>


			<c:forEach items="${list2}" var="goodsBean">
				<div class="list clearfix transition">
					<div class="tu clearfix">
						<img src="${basePath}upload/${goodsBean.goods_image}" /> <span></span>

						<div class="ycang clearfix">
							<samp class="opa8"></samp>
							<div class="nr clearfix">
								<!--注意：当下方li中添加class名为cur的时候为选中的时候样式-->
								<ul>
									<!-- <li class="box-s transition">收藏</li> -->
									<li class="box-s transition"><a href="${basePath }page/user/page/car/carServlet?method=addOrupdate&goods_id=${goodsBean.goods_id}">购物车</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="xia clearfix box-s">
						<p class="bt over">${goodsBean.goods_name }作</p>
						<div class="price clearfix">
							<span class="fl">￥${goodsBean.goods_price }.00</span> <a
								href="${basePath}page/goodsServlet?method=showGoods&goods_id=${goodsBean.goods_id}"
								class="goumai fr ra3 transition">立即购买</a>
						</div>
					</div>
				</div>
			</c:forEach>



		</div>
	</div>
	<!--choice end-->

	<!--art star-->
	<div class="art clearfix">
		<div class="content clearfix box-s">
			<div class="art-ctent clearfix box-s">
				<div class="recom-tit clearfix">
					<p class="engtit ta-center">ART WRITER</p>
					<div class="middle clearfix">
						<span class="line"></span> <span class="wenzi">艺术家</span> <span
							class="line"></span>
					</div>
				</div>
				<div class="bottom clearfix box-s">
					<div class="scrollBox" style="margin: 0 auto">
						<div class="ohbox">
							<ul class="piclist">
								<li>
									<div class="list clearfix fl box-s transition">
										<div class="tu clearfix box-s">
											<img src="${basePath}upload/people.jpg" /> <span></span>
										</div>
										<div class="ctent clearfix box-s">
											<div class="shang clearfix">
												<p class="over ta-center">孙瑾晨</p>
												<span></span>
											</div>
											<div class="xia clearfix">
												<p>
													原名查君，生于西安，自幼受家庭熏陶，随父习画1986年入中
													原名查君，生于西安，自幼受家庭熏陶，随父习画。1986年入中
													原名查君，生于西安，自幼受家庭熏陶，随父习画。1986年入中...... <a href="#"
														class="more"> 查看更多&gt;&gt; </a>
												</p>
											</div>
										</div>
									</div>
								</li>
								<li>
									<div class="list clearfix fl box-s transition">
										<div class="tu clearfix box-s">
											<img src="${basePath}upload/people.jpg" /> <span></span>
										</div>
										<div class="ctent clearfix box-s">
											<div class="shang clearfix">
												<p class="over ta-center">孙瑾晨</p>
												<span></span>
											</div>
											<div class="xia clearfix">
												<p>
													原名查君，生于西安，自幼受家庭熏陶，随父习画1986年入中
													原名查君，生于西安，自幼受家庭熏陶，随父习画。1986年入中
													原名查君，生于西安，自幼受家庭熏陶，随父习画。1986年入中...... <a href="#"
														class="more"> 查看更多&gt;&gt; </a>
												</p>
											</div>
										</div>
									</div>
								</li>
								<li>
									<div class="list clearfix fl box-s transition">
										<div class="tu clearfix box-s">
											<img src="${basePath}upload/people.jpg" /> <span></span>
										</div>
										<div class="ctent clearfix box-s">
											<div class="shang clearfix">
												<p class="over ta-center">孙瑾晨</p>
												<span></span>
											</div>
											<div class="xia clearfix">
												<p>
													原名查君，生于西安，自幼受家庭熏陶，随父习画1986年入中
													原名查君，生于西安，自幼受家庭熏陶，随父习画。1986年入中
													原名查君，生于西安，自幼受家庭熏陶，随父习画。1986年入中...... <a href="#"
														class="more"> 查看更多&gt;&gt; </a>
												</p>
											</div>
										</div>
									</div>
								</li>
								<li>
									<div class="list clearfix fl box-s transition">
										<div class="tu clearfix box-s">
											<img src="${basePath}upload/people.jpg" /> <span></span>
										</div>
										<div class="ctent clearfix box-s">
											<div class="shang clearfix">
												<p class="over ta-center">孙瑾晨</p>
												<span></span>
											</div>
											<div class="xia clearfix">
												<p>
													原名查君，生于西安，自幼受家庭熏陶，随父习画1986年入中
													原名查君，生于西安，自幼受家庭熏陶，随父习画。1986年入中
													原名查君，生于西安，自幼受家庭熏陶，随父习画。1986年入中...... <a href="#"
														class="more"> 查看更多&gt;&gt; </a>
												</p>
											</div>
										</div>
									</div>
								</li>
							</ul>
						</div>
						<div class="pageBtn">
							<span class="prev">&lt;</span> <span class="next">&gt;</span>
							<ul class="list">
								<li>0</li>
								<li>1</li>
							</ul>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!--art end-->

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
<script src="${basePath}common/user/js/other.js" type="text/javascript"></script>
	<script type="text/javascript">
		function find(){

			
			document.getElementById("form").submit();	
			
		}
	</script>

</html>
