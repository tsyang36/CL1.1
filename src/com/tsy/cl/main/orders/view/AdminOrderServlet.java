package com.tsy.cl.main.orders.view;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.tsy.cl.main.addr.bena.AddrBean;
import com.tsy.cl.main.addr.dao.AddrDao;
import com.tsy.cl.main.car.bean.CarBean;
import com.tsy.cl.main.car.dao.CarDao;
import com.tsy.cl.main.goods.bean.GoodsBean;
import com.tsy.cl.main.orders.bena.OrderBean;
import com.tsy.cl.main.orders.dao.OrderDao;
import com.tsy.cl.main.ordersxx.bena.OrdersxxBean;
import com.tsy.cl.main.ordersxx.dao.OrdersxxDao;
import com.tsy.cl.main.user.bena.UserBean;
import com.tsy.cl.util.PageUtil;
import com.tsy.cl.util.StepUtil;


@WebServlet("/page/admin/page/orders/adminOrdersServlet")
public class AdminOrderServlet extends HttpServlet {
	
	private OrderDao orderDao = new OrderDao();
	
	private AddrDao addrDao = new AddrDao();

	private OrdersxxDao ordersxxDao = new OrdersxxDao();
	
	private CarDao carDao = new CarDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charst=UTF-8");
		
		String method = req.getParameter("method");
		
		if("fahuo".equals(method)){
		
			fahuo(req,resp);
		}
		
	}
	
	private void fahuo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int order_id = Integer.parseInt(req.getParameter("order_id"));
		orderDao.modify(order_id,"2");
		resp.getWriter().write("true");
	}
	

	
	
	
}
