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


@WebServlet("/page/user/page/orders/ordersServlet")
public class OrderServlet extends HttpServlet {
	
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
		
		if("add".equals(method)){
			
			add(req,resp);
		}else if("updatestate".equals(method)){
			
			updatestate(req,resp);
		}else if("getPage".equals(method)){
			
			getpage(req,resp);
		}else if("shouhuo".equals(method)){
		
			shouhuo(req,resp);
		}
		
	}
	
	/*private void fahuo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int order_id = Integer.parseInt(req.getParameter("order_id"));
		orderDao.modify(order_id,"2");
		resp.getWriter().write("true");
	}
*/
	protected void getpage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String order_code = req.getParameter("order_code");
		
		String param = "&order_code=";
		
		if(order_code==null || "".equals(order_code) || "null".equals(order_code)){
			
			order_code= "%%";
		}else{
			param+=order_code;
			order_code="%"+order_code+"%";
		}
		
		
		List<OrderBean> ordergllist = orderDao.getpage(order_code);
		req.setAttribute("ordergllist", ordergllist);
		req.getRequestDispatcher("../../../admin/page/ordergl/table.jsp").forward(req, resp);
	}
	
	protected void updatestate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int order_id = Integer.parseInt(req.getParameter("order_id"));
		orderDao.modify(order_id,"1");
		req.getRequestDispatcher("../../../goodsServlet?method=home").forward(req, resp);
	}
	private void shouhuo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int order_id = Integer.parseInt(req.getParameter("order_id"));
		orderDao.modify(order_id,"3");
		resp.getWriter().write("true");
	}
	
	protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int addr_id = Integer.parseInt(req.getParameter("addr_id"));
		
		int user_id = ((UserBean)req.getSession().getAttribute("userBean")).getUser_id();
		
		String orders_code = UUID.randomUUID().toString().replaceAll("-", "");
		
		OrderBean orderBean = new OrderBean();
		
		orderBean.setUser_id(user_id);
		
		orderBean.setOrder_state("0");
		
		orderBean.setOrder_code(orders_code);
		
		//orderBean.setAddr_id(addr_id);
		
		AddrBean addr = addrDao.getoneaddr(addr_id+"");
		
		orderBean.setAddr_name(addr.getAddr_name());
		orderBean.setAddr_province(addr.getAddr_province());
		orderBean.setAddr_city(addr.getAddr_city());
		orderBean.setAddr_district(addr.getAddr_district());
		orderBean.setAddrxx(addr.getAddrxx());
		orderBean.setTel(addr.getTel());
		orderBean.setYoubian(addr.getYoubian());
		//orderBean.setOrders_sumprice(orderDao.GetSumPriceBycode(orders_code));
		orderBean.setOrders_sumprice(new BigDecimal(0));
		orderDao.save(orderBean);
		int order_id = orderDao.findBycode(orders_code);
		
		req.setAttribute("order_id", order_id);
		OrdersxxBean ordersxxBean = new OrdersxxBean();
		if(req.getParameter("goods_id")==null || "".equals(req.getParameter("goods_id")) || "null".equals(req.getParameter("goods_id"))){
			List<CarBean> list = carDao.findByUserId(user_id);
			for (CarBean carBean : list) {
				ordersxxBean.setOrders_id(order_id);
				ordersxxBean.setGoods_id(carBean.getGoodsBean().getGoods_id());
				ordersxxBean.setGoods_number(carBean.getGoods_number());
				ordersxxDao.save(ordersxxBean);
			}
			req.setAttribute("sum", carDao.getsum(user_id));
			carDao.removeall(user_id);
		}else{
			int addnumber = Integer.parseInt(req.getParameter("addnumber"));
			int goods_id = Integer.parseInt(req.getParameter("goods_id"));
			ordersxxBean.setOrders_id(order_id);
			ordersxxBean.setGoods_id(goods_id);
			ordersxxBean.setGoods_number(addnumber);
			ordersxxDao.save(ordersxxBean);
		}
		BigDecimal sumprice = orderDao.GetSumPriceBycode(order_id);
		orderDao.updateSumpriceByOrderId(sumprice,order_id);
		req.getRequestDispatcher("../fukuan/fukuan.jsp").forward(req, resp);
		
	}

	
}
