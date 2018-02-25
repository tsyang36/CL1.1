<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.tsy.cl.main.goods.bean.GoodsBean"%>
<%@page import="com.tsy.cl.main.goods.dao.GoodsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<%@include file="../../../common/admin/jsp/head.jsp" %>
<html>

	<head>
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta charset='utf-8'>
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<title>详情</title>
		<meta name="viewport" content="width=device-width,initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta http-equiv="Cache-Control" content="no-siteapp">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link rel="stylesheet" type="text/css" href="${basePath}common/user/css/page.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}common/user/css/base.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}common/user/css/common.css" />
		<script src="${basePath}common/user/js/jquery-1.8.3.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="${basePath}common/user/js/jquery.SuperSlide.2.1.js"></script>
		<script src="${basePath}common/user/js/common.js"></script>
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
								<c:if test="${userBean !=null}">
								<li><span class="fl">欢迎</span> <a href="${basePath}page/user/page/ordersxx/ordersServlet?method=getpage"
								class="fl">${userBean.user_tel}</a> <span class="fl">进入商城</span></li>
								<li><a href="${basePath}page/user/login/userServlet?method=exit"> 退出登录</a></li>
								</c:if>
								<c:if test="${userBean ==null}">
								<li>你好，请<a href="${basePath }page/user/login/login.jsp"> 登录 </a></li>
								</c:if>
								<li>
									<a href="${basePath }page/user/login/reg.jsp">
										免费注册
									</a>
								</li>
								<li>
									<a href="settled.html">
										艺术家入驻
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
		<div class="main-wrap graybgtwo pt40 pb40">
			<div class="wrapper">
				<!--Main-pro-info-->
				<div class="main-pro-info white-box  clearfix">
					<div class="fangda clearfix fl">
						<div id="showbox">
						  <img src="${basePath }upload/${goodsBean.goods_image}" width="1000" height="1000" />
						</div><!--展示图片盒子-->
						<div id="showsum"></div><!--展示图片里边-->
						<p class="showpage">
						  <a href="javascript:void(0);" id="showlast"> < </a>
						  <a href="javascript:void(0);" id="shownext"> > </a>
						</p>
						
						</div>
					<!--产品信息介绍-->
					<div class="fr pro-intro">
						<div class="pb20 line-bot">
							<h3 class="fs26 darkblack lh50 ellipsis">${goodsBean.goods_name }</h3>
							<%-- <p class="fs14 lh20 over2">${goodsBean.goods_desc }</p> --%>
							<p class="price pt10 clearfix"><strong class="fl red fs40">¥${goodsBean.goods_price }</strong><em class="fl white ml20 lh20 mt20">已售：2000件</em></p>
						</div>
						<div class="pro-ctent clearfix">
							<ul>
								<%-- <li><span>艺 术 家 ：</span>${goodsBean.goods_name }</li> --%>
								<!-- <li><span>尺      寸 ：</span>50×50cm</li> -->
								<li><span>${goodsBean.goods_desc }</span></li>
								<%-- <li><span>价      格 ：</span>${goodsBean.goods_price }</li> --%>
								<!-- <li><span>材      质 ：</span>纸本设色</li> -->
								<!-- <li><span>年      代 ：</span>2015年</li> -->
							</ul>
						</div>
						<div class="pt10">
							<div class="p-count fs14 mt20 clearfix">
								<label class="fl lh40 darkblack">数量：</label>
								<p class="fl count ml10 clearfix">
									<a href="javascript:jianone();" class="fl fs30 reduction">-</a>
									<input type="text" value="1" class="fl fs16" id="ones"> <!-- placeholder="1" -->
									<a href="javascript:addone();" class="fl fs30 add" id = "add">+</a>
								</p>
							</div>
							<div class="but-box mt30">
								<input type="button" class="fl orange-but radius3" onclick="nowbug();" value="立即购买">
								<input type="button" class="fl ml20 orange-but gray-but radius3" value="加入购物车" onclick="addcar();">
							</div>
						</div>
					</div>
					<!--/end-->
				</div>
				<!--/end-->
				<!--proscroll-->
				<%-- <div class="proscroll white-box mt20">
					<a class="prev" href="javascript:void(0)"></a>
					<div class="scrollWrap">
						<ul class="prolist clearfix">
							<li>
								<a href="#" class="db pic"><span><img src="${basePath}common/user/${basePath}common/user/upload/2.jpg" alt=""/></span></a>
								<a href="#" class="full-db tit darkblack ellipsis">墙角数枝梅</a>
								<strong class="full-db red"><em class="fs12">¥</em>65.00</strong>
							</li>
							<li>
								<a href="#" class="db pic"><span><img src="${basePath}common/user/${basePath}common/user/upload/2.jpg" alt=""/></span></a>
								<a href="#" class="full-db tit darkblack ellipsis">墙角数枝梅</a>
								<strong class="full-db red"><em class="fs12">¥</em>65.00</strong>
							</li>
							<li>
								<a href="#" class="db pic"><span><img src="${basePath}common/user/${basePath}common/user/upload/2.jpg" alt=""/></span></a>
								<a href="#" class="full-db tit darkblack ellipsis">墙角数枝梅</a>
								<strong class="full-db red"><em class="fs12">¥</em>65.00</strong>
							</li>
							<li>
								<a href="#" class="db pic"><span><img src="${basePath}common/user/${basePath}common/user/upload/2.jpg" alt=""/></span></a>
								<a href="#" class="full-db tit darkblack ellipsis">墙角数枝梅</a>
								<strong class="full-db red"><em class="fs12">¥</em>65.00</strong>
							</li>
							<li>
								<a href="#" class="db pic"><span><img src="${basePath}common/user/upload/2.jpg" alt=""/></span></a>
								<a href="#" class="full-db tit darkblack ellipsis">墙角数枝梅</a>
								<strong class="full-db red"><em class="fs12">¥</em>65.00</strong>
							</li>
						</ul>

					</div>
					<a class="next" href="javascript:void(0)"></a>
				</div> --%>
				<!--/end-->

				<div class="mt20 clearfix">
					<div class="fl pro-likes white-box">
						<div class="title"><strong class="fs16 white">大家都喜欢</strong></div>
						<ul class="likelist">
							<li>
								<a href="#" class="db pic"><span><img src="${basePath}common/user/${basePath}common/user/upload/2.jpg" alt=""/></span></a>
								<a href="#" class="full-db tit darkblack ellipsis">墙角数枝梅</a>
								<strong class="full-db red"><em class="fs12">¥</em>65.00</strong>
							</li>
							<li>
								<a href="#" class="db pic"><span><img src="${basePath}common/user/upload/2.jpg" alt=""/></span></a>
								<a href="#" class="full-db tit darkblack ellipsis">墙角数枝梅</a>
								<strong class="full-db red"><em class="fs12">¥</em>65.00</strong>
							</li>
							<li>
								<a href="#" class="db pic"><span><img src="${basePath}common/user/upload/2.jpg" alt=""/></span></a>
								<a href="#" class="full-db tit darkblack ellipsis">墙角数枝梅</a>
								<strong class="full-db red"><em class="fs12">¥</em>65.00</strong>
							</li>

						</ul>
					</div>
					
					<div class="pro-detail fr box-s">
						<div class="tab-hd box-s">
								<ul class="tab-nav clearfix">
								  <li class="fs16 box-s">商品详情</li>
								  <li class="fs16 box-s">商品咨询</li>
								</ul>
						</div>
						<div class="tab-bd">
							<div class="tab-pal">
								<p><img src="${basePath}common/user/upload/2.jpg" alt="" /></p>
							</div>
							<div class="tab-pal">
								<div class="pro-zixun clearfix">
									<p class="bt">我要咨询：</p>
									<textarea name="" rows="5" cols="" placeholder="请输入要咨询内容"></textarea>
									<p class="tijiao"><a href="#" class="ra3">提交</a></p>
								</div>
							</div>
						</div>
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
	<script src="${basePath}common/user/js/other.js" type="text/javascript" ></script>
	<script type="text/javascript">
	
		function addcar(){
			var addnumber =document.getElementById('ones').value;
			window.location.href="${basePath }page/user/page/car/carServlet?method=addOrupdate&goods_id=${goodsBean.goods_id}&addnumber="+addnumber+"";
			
		}
		function nowbug(){
			var addnumber =document.getElementById('ones').value;
			window.location.href="${basePath }page/user/page/jiesuan/addrServlet?method=findByUserId&goods_id=${goodsBean.goods_id }&addnumber="+addnumber+"";
		}
		function find(){
			document.getElementById("form").submit();	
		}
		function addone(){
			document.getElementById("ones").value++;	
		}
		function jianone(){
			if(document.getElementById("ones").value>1){
			document.getElementById("ones").value--;	
			}
		}
	</script>
</html>