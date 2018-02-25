package com.tsy.cl.main.car.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsy.cl.main.car.bean.CarBean;
import com.tsy.cl.main.car.dao.CarDao;
import com.tsy.cl.main.user.bena.UserBean;
@WebServlet("/page/user/page/car/carServlet")
public class CarServlet extends HttpServlet {

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

		if ("addOrupdate".equals(method)) {

			addOrupdate(req, resp);
		}else if ("delete".equals(method)) {

			delete(req, resp);
		}else if ("showlist".equals(method)) {

			showlist(req, resp);
		}
		
	}
	
	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int user_id = ((UserBean)req.getSession().getAttribute("userBean")).getUser_id();
		int goods_id = Integer.parseInt(req.getParameter("goods_id"));
		carDao.remove(user_id, goods_id);
		showlist(req, resp);
	}
	
	protected void addOrupdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int user_id = ((UserBean)req.getSession().getAttribute("userBean")).getUser_id();
		int goods_id = Integer.parseInt(req.getParameter("goods_id"));
		CarBean carBean  = new CarDao().findByUidAndGid(user_id, goods_id);
		
		if(carBean!=null){
			if(req.getParameter("goods_number")!=null){
				int goods_number = Integer.parseInt(req.getParameter("goods_number"));
				if(goods_number<1){
					goods_number=1;
				}
				carBean = new CarBean(user_id,goods_id,goods_number);
				carDao.modify(carBean);
			}else{
				if(req.getParameter("addnumber")!=null){
					System.out.println(req.getParameter("addnumber"));
					carBean = new CarBean(user_id,goods_id,carBean.getGoods_number()+Integer.parseInt(req.getParameter("addnumber")));
				}else{
					carBean = new CarBean(user_id,goods_id,carBean.getGoods_number()+1);
				}
				carDao.modify(carBean);
			}
		}else{
			carBean = new CarBean(user_id,goods_id,1);
			carDao.save(carBean);
		}
		showlist(req, resp);
	}
	protected void showlist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int user_id = ((UserBean)req.getSession().getAttribute("userBean")).getUser_id();
		req.setAttribute("carlist", carDao.findByUserId(user_id));
		req.getSession().setAttribute("sum", carDao.getsum(user_id));
		req.getRequestDispatcher("car.jsp").forward(req, resp);
		
	}
	

}
