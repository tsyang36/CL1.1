package com.tsy.cl.main.ordersxx.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.tsy.cl.main.goods.bean.GoodsBean;
import com.tsy.cl.main.orders.bena.OrderBean;
import com.tsy.cl.main.orders.dao.OrderDao;
import com.tsy.cl.main.ordersxx.dao.OrdersxxDao;
import com.tsy.cl.main.user.bena.UserBean;

@WebServlet("/page/user/page/ordersxx/ordersServlet")
public class OrdersxxServlet extends HttpServlet{
	OrderDao orderDao = new OrderDao();
	OrdersxxDao ordersxxDao = new OrdersxxDao();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charst=UTF-8");
		
		String method = req.getParameter("method");
		
		if("getpage".equals(method)){
			
			getpage(req,resp);
		}else if("getPageByOrderId".equals(method)){
			
			getPageByOrderId(req,resp);
		}else if("updatestate".equals(method)){
			
			//updatestate(req,resp);
		}
	}
	
	protected void getpage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int user_id = ((UserBean)req.getSession().getAttribute("userBean")).getUser_id();
		List<OrderBean> Myordersxxlist =  ordersxxDao.getpage(user_id);
		req.setAttribute("Myordersxxlist", Myordersxxlist);
		req.getRequestDispatcher("../MyOrders/myorders.jsp").forward(req, resp);
	}
	protected void getPageByOrderId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int orders_id = Integer.parseInt(req.getParameter("order_id"));
		List<GoodsBean> Myordersxxlist =  ordersxxDao.getPageByOrderId(orders_id);
		//req.getSession().removeAttribute("Myordersxxlist");
		req.getSession().setAttribute("Myordersxxlist1", Myordersxxlist);
		resp.setContentType("text/text;charset=GBK"); 
		resp.getWriter().write(JSON.toJSONString(Myordersxxlist));
	}

}
