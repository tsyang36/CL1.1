<%@page import="com.tsy.cl.util.PageUtil"%>
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
		<title>商城</title>
		<meta name="viewport" content="width=device-width,initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta http-equiv="Cache-Control" content="no-siteapp">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link rel="stylesheet" type="text/css" href="${basePath}common/user/css/page.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}common/user/css/base.css" />
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
								<li><a href="#"><img src="${basePath}common/user/img/sina.png"/></a></li>
								<li><a href="#"><img src="${basePath}common/user/img/qq.png"/></a></li>
								<li><a href="#"><img src="${basePath}common/user/img/wechat.png"/></a></li>
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
				<input type="text" class="fl" name="goods_name" id="goods_name" value="${param.goods_name}"
					placeholder="请输入您要搜索的内容" /> <input type="button" 
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
					<li><a href="${basePath }page/goodsServlet?method=home">首页</a></li>
					<li class="cur"><a href="#">商城</a></li>
					<li>
						<a href="${basePath}page/user/page/ordersxx/ordersServlet?method=getpage">个人中心</a>
					</li>
				</ul>
			</div>
		</div>
		<!--navbar end-->
		
		<!--mall star-->
		<div class="mall clearfix">
			<!--sorts star-->
			<div class="sorts clearfix">
				<div class="content clearfix">
					<div class="top clearfix box-s">
						您的位置：商城
					</div>
					<!-- <div class="listed clearfix box-s">
						<div class="list clearfix fl">
							<p class="bt fl">
								分类：
							</p>
							<div class="right clearfix fl">
								<ul>
									<li class="cur">不限</li>
									<li class="">书画</li>
									<li class="">油画</li>
									<li class="">版画</li>
									<li class="">雕塑</li>
								</ul>
							</div>
						</div>
						<div class="list clearfix fl">
							<p class="bt fl">
								尺寸：
							</p>
							<div class="right clearfix fl">
								<ul>
									<li class="cur">不限</li>
									<li>小于50cm</li>
									<li>500-100cm</li>
									<li>大于150cm</li>
								</ul>
							</div>
						</div>
						<div class="list clearfix fl">
							<p class="bt fl">
								价格：
							</p>
							<div class="right clearfix fl">
								<ul>
									<li class="cur">不限</li>
									<li>0-1000元</li>
									<li>1000-2000元</li>
									<li>2000-3000元</li>
									<li>3000-5000元</li>
									<li>5000元以上</li>
								</ul>
							</div>
						</div>						
					</ div>-->
				</div>
			</div>
			<!--sorts end-->
			
			<!--sales star-->
			<div class="sales clearfix">
				<div class="content clearfix">
								全部商品
					<%
					if(request.getAttribute("shangchenglist")==null){
						request.setAttribute("shangchenglist", new GoodsDao().getPage("%%", 0, 10));
						}
					%>
					<div class="bottom clearfix">
					
					
					<c:forEach items="${shangchenglist}" var="goodsBean">
						<div class="list clearfix transition">
					<a href="${basePath}page/goodsServlet?method=showGoods&goods_id=${goodsBean.goods_id}">
							<div class="tu clearfix">
								<img src="${basePath}upload/${goodsBean.goods_image}"/>
								<span></span>
								
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
						</a>
							<div class="xia clearfix box-s">
								<p class="bt over">
									${goodsBean.goods_name}	
								</p>
								<div class="price clearfix">
									<span class="fl">￥${goodsBean.goods_price}.00</span><!-- <samp>原价￥2000.00</samp> -->
									<a href="${basePath}page/goodsServlet?method=showGoods&goods_id=${goodsBean.goods_id}" class="goumai fr ra3 transition">立即购买</a>
								</div>
							</div>
						
						</div>
					</c:forEach>
						
					</div>
					
					<%PageUtil pageUtil = (PageUtil)request.getAttribute("pageUtil"); %>
					<div class="page clearfix ta-right">
						<a href="goodsServlet?method=sousuo&current=1&goods_name=${param.goods_name}" class="pre box-s">首页</a>
						<a href="goodsServlet?method=sousuo&current=${pageUtil.current-1}&goods_name=${param.goods_name}" class="pre box-s">上一页</a>
						<%
							int[] step = (int[]) request.getAttribute("step");
							int current = (int) pageUtil.getCurrent();
							//int begin = step[0];
							//int end = step[1];
							for (int i = step[0]; i <= step[1]; i++) {
								if(i==current){
						%>
						<a href="#" style="color: red"><%=i %></a>
						<%-- <span style="background-color: red;color: black;"><%=i %></span> --%>
						<%}else{
						%>
							<a href="goodsServlet?method=sousuo&current=<%=i%>&goods_name=${param.goods_name}"><%=i %></a>
						<%} %>
						<%}%>
						<span>...</span>
						<a href="goodsServlet?method=sousuo&current=${pageUtil.current+1}&goods_name=${param.goods_name}" class="next box-s">下一页</a>
						<a href="goodsServlet?method=sousuo&current=${pageUtil.pagenum}&goods_name=${param.goods_name}" class="next box-s">尾页</a>
						<span class="ml10">第${pageUtil.current}页/共${pageUtil.pagenum}页
							:共${pageUtil.totalRow}条记录</span>
						<!-- <input type="" name="" id="" value="" /> -->
						<!-- <span>页</span> -->
						<!-- <input type="submit" name="" id="" value="确定" /> -->
					</div>
					
				
				<%-- <%PageUtil pageUtil = (PageUtil)request.getAttribute("pageUtil"); %>					
				<div style="text-align: center;">
					<ul class="pagination">
						<li><a
							href="page/goodsServlet?method=sousuo&current=1${pageUtil.param}">首页</a>
						</li>
						<li><a
							href="page/goodsServlet?method=sousuo&current=${pageUtil.current-1}${pageUtil.param}">上一页</a>
						</li>
						<%
							System.out.println(pageUtil.getParam());
							int[] step = (int[]) request.getAttribute("step");
							int current = (int) pageUtil.getCurrent();
							//int begin = step[0];
							//int end = step[1];
							for (int i = step[0]; i <= step[1]; i++) {
								if(i==current){
						%>
						<li>
						<span style="background-color: red;color: black;"><%=i %></span>
						</li>
						<%}else{
						%>
						<li>
							<a href="page/goodsServlet?method=sousuo&current=<%=i%>${pageUtil.param}"><%=i %></a>
						</li>
						<%} %>
						<%}%>
						<li><a
							href="page/goodsServlet?method=sousuo&current=${pageUtil.current+1}${pageUtil.param}">下一页</a>
						</li>
						<li><a
							href="page/goodsServlet?method=sousuo&current=${pageUtil.pagenum}${pageUtil.param}">尾页</a>
						</li>
						<li>第${pageUtil.current}页/共${pageUtil.pagenum}页
							:共${pageUtil.totalRow}条记录
						</li>
					</ul>
				</div> --%>
				
					
				</div>
			</div>
			<!--sales end-->
		</div>
		<!--mall end-->
		
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
		$('.listed .list ul li').each(function() {
			$(this).click(function() {
				$(this).siblings("li").removeClass("cur");
				$(this).addClass("cur");
			});
		});
		
	</script>
	<script src="${basePath}common/user/js/other.js" type="text/javascript" ></script>
	<script type="text/javascript">
		function find(){

			
			document.getElementById("form").submit();	
			
		}
	</script>
</html>