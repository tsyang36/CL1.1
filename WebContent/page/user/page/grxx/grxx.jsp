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
		<title>个人中心</title>
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
									<span class="fl">欢迎</span>
									<a href="grxx.html" class="fl">瑾晨0212</a>
									<span class="fl">进入商城</span>
								</li>
									<li><a href="${basePath }page/user/login/reg.jsp"> 免费注册 </a></li>
								<li>
						<a href="${basePath}page/user/page/ordersxx/ordersServlet?method=getpage">个人中心</a>
					</li>
							</ul>
						</div>
						<div class="shopcar-btn clearfix fl">
							<a href="shopping.html" class="box-s">
								购物车（0）
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
				<div class="search clearfix fr ra5">
					<input type="text" class="fl" name="" id="" value="" placeholder="请输入您要搜索的内容" />
					<input type="button" name="" id="" value="搜索" class="fl box-s" />
				</div>
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
					<li><a href="${basePath }page/user/page/grxx/grxx.jsp">个人中心</a></li>
				</ul>
			</div>
		</div>
		<!--navbar end-->

		<!--Main-wrap-->
		<div class="main-wrap graybg clearfix">
			<div class="wrapper pt40 pb40 clearfix">
				<div class="fl slide-nav white-box">
					<ul>
						<li>
							<a href="${basePath}page/user/page/ordersxx/ordersServlet?method=getpage" class="db fs16">我的订单</a>
						</li>
						<li>
							<a href="${basePath }page/user/page/jiesuan/addrServlet?method=getaddrByUserId" class="db fs16">收货地址</a>
						</li>
						<li>
							<a href="xgmm.html" class="db fs16">修改密码</a>
						</li>
						<li>
							<a href="zixun.html" class="db fs16">我的咨询</a>
						</li>
						<li>
							<a href="znx.html" class="db fs16">站内信</a>
						</li>
					</ul>
				</div>
				<div class="fr slide-show white-box">
					<div class="dark-tit line-bot clearfix">
						<h3 class="fl fs26">个人信息</h3>
					</div>
					<div class="user-info mt50 clearfix">
						<form action="">
							<div class="fl base-info">
								<ul>
									<li>
										<label class="fl l-option">姓名：</label><input type="text" class="fl ml10" placeholder="">
									</li>
									<li>
										<label class="fl l-option">生日：</label>
										<div class="fl ml10 sel_wrap">
											<em></em>
											<label>1991</label>
											<select class="select" name="" id=" ">
												<option value="0">1991</option>
												<option value="1">1992</option>
											</select>
										</div>
										<label class="fl ml5 fs14">年</label>
										<div class="fl ml5 sel_wrap">
											<em></em>
											<label>01</label>
											<select class="select" name="" id=" ">
												<option value="0">01</option>
												<option value="1">02</option>
											</select>
										</div>
										<label class="fl ml5 fs14">月</label>
										<div class="fl ml5 sel_wrap">
											<em></em>
											<label>01</label>
											<select class="select" name="" id=" ">
												<option value="0">01</option>
												<option value="1">02</option>
											</select>
										</div>
										<label class="fl ml5 fs14">日</label>

									</li>
									<li class="radio-li">
										<label class="fl l-option">性别：</label>
										<div class="radio-box">
											<input type="radio" class="radio-inline" checked><label class="fs14">男</label>
											<input type="radio" class="ml10 radio-inline"><label class="fs14">女</label>
										</div>
									</li>
									<li>
										<label class="fl l-option">电话：</label><input type="text" class="fl ml10" placeholder="">
									</li>
									<li>
										<label class="fl l-option">Q Q：</label><input type="text" class="fl ml10" placeholder="">
									</li>
									<li>
										<label class="fl l-option">邮箱：</label><input type="text" class="fl ml10" placeholder="">
									</li>
									<li class="but-li pl10"><input type="button" class="green-but radius3 fs16 ml50" value="保存修改"></li>
								</ul>
							</div>
							<div class="fr user-photo pr50 mr10">
								<p class="photo"><img src="img/photo.jpg" alt="" /></p>
								<input type="button" onMouseMove="f.style.pixelLeft=event.x-60;f.style.pixelTop=this.offsetTop;" value="更换头像" onClick="f.click()" class="edit_photo fs14 green radius3 mt10">
								<input type="file" id="f" onChange="txt.value=this.value" name="f" class="files" size="1" hidefocus>
							</div>
						</form>

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

</html>