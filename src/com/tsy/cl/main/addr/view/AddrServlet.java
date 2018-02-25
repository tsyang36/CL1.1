package com.tsy.cl.main.addr.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.tsy.cl.main.addr.bena.AddrBean;
import com.tsy.cl.main.addr.dao.AddrDao;
import com.tsy.cl.main.car.dao.CarDao;
import com.tsy.cl.main.goods.bean.GoodsBean;
import com.tsy.cl.main.goods.dao.GoodsDao;
import com.tsy.cl.main.user.bena.UserBean;


@WebServlet("/page/user/page/jiesuan/addrServlet")
public class AddrServlet extends HttpServlet{
	private AddrDao addrDao = new AddrDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charst=UTF-8");

		String method = req.getParameter("method");
		if("findByUserId".equals(method)){
			findByUserId(req, resp);
		}else if("add".equals(method)){
			add(req, resp);
		}else if("del".equals(method)){
			del(req, resp);
		}else if("findByAddrId".equals(method)){
			findByAddrId(req, resp);
		}else if("updateaddr".equals(method)){
			updateaddr(req, resp);
		}else if("getaddrByUserId".equals(method)){
			getaddrByUserId(req, resp);
		}/*else if("del1".equals(method)){
			del1(req, resp);
		}else if("updateaddr1".equals(method)){
			updateaddr1(req, resp);
		}*/
	}
	
	protected void updateaddr(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String b = req.getParameter("b");
		String addr_id = req.getParameter("addr_id");
		String addr_name = req.getParameter("addr_name");
		String add_provice = req.getParameter("province");
		String add_city = req.getParameter("city");
		String add_district = req.getParameter("district");
		String addxx = req.getParameter("addrxx");
		String tel = req.getParameter("tel");
		String youbian = req.getParameter("youbian");
		int user_id = ((UserBean)req.getSession().getAttribute("userBean")).getUser_id();
		AddrBean addrBean = new AddrBean(Integer.parseInt(addr_id),addr_name,add_provice,add_city,add_district,addxx,tel,youbian,user_id);
		addrDao.updateaddr(addrBean);
		resp.getWriter().write("true");
		/*if(b==null || "".equals(b) || "null".equals(b) ||b ==""){
			findByUserId(req,resp);
		}else{
			getaddrByUserId(req, resp);
		}*/
	}
	
	/*protected void updateaddr1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String addr_id = req.getParameter("addr_id");
		String addr_name = req.getParameter("addr_name");
		String add_provice = req.getParameter("province");
		String add_city = req.getParameter("city");
		String add_district = req.getParameter("district");
		String addxx = req.getParameter("addrxx");
		String tel = req.getParameter("tel");
		String youbian = req.getParameter("youbian");
		int user_id = ((UserBean)req.getSession().getAttribute("userBean")).getUser_id();
		AddrBean addrBean = new AddrBean(Integer.parseInt(addr_id),addr_name,add_provice,add_city,add_district,addxx,tel,youbian,user_id);
		addrDao.updateaddr(addrBean);
		//req.setAttribute("addrBean",addrBean);
		getaddrByUserId(req,resp);
	}*/
	
	protected void findByAddrId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String addr_id = req.getParameter("addr_id");
		String b = req.getParameter("b");
		req.setAttribute("b", b);
		AddrBean addrBean = addrDao.getoneaddr(addr_id);
		req.setAttribute("addrBean",addrBean);
		resp.setContentType("text/text;charset=GBK"); 
		resp.getWriter().write(JSON.toJSONString(addrBean));
		//req.getRequestDispatcher("../updateaddr/updateaddr.jsp").forward(req, resp);
		//req.getRequestDispatcher("../myaddr/myaddr.jsp").forward(req, resp);
		/*if(list.size()<1){
			resp.sendRedirect("jiesuan.jsp");
			
		}else{
			
			req.setAttribute("list",list);
			
			req.getRequestDispatcher("../orders/ordersServlet?method=add").forward(req, resp);
		}*/
	}
	
	protected void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//addr_id,addr_name,provice,city,district,detailAddr,tel,zipcode,user_id
		String addr_id = req.getParameter("addr_id");
		int user_id = ((UserBean)req.getSession().getAttribute("userBean")).getUser_id();
		addrDao.del(addr_id);
		//findByUserId(req,resp);
		resp.getWriter().write("true");
	}
	
	/*protected void del1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//addr_id,addr_name,provice,city,district,detailAddr,tel,zipcode,user_id
		String addr_id = req.getParameter("addr_id");
		int user_id = ((UserBean)req.getSession().getAttribute("userBean")).getUser_id();
		addrDao.del(addr_id);
		getaddrByUserId(req, resp);
	}*/
	
	protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//addr_id,addr_name,provice,city,district,detailAddr,tel,zipcode,user_id
		String addr_name = req.getParameter("addr_name");
		String add_provice = req.getParameter("province");
		String add_city = req.getParameter("city");
		String add_district = req.getParameter("district");
		String addxx = req.getParameter("addrxx");
		String tel = req.getParameter("tel");
		String youbian = req.getParameter("youbian");
		int user_id = ((UserBean)req.getSession().getAttribute("userBean")).getUser_id();
		addrDao.save(new AddrBean(addr_name,add_provice,add_city,add_district,addxx,tel,youbian,user_id));
		//findByUserId(req,resp);
		resp.getWriter().write("true");
		
	}
	
	
	protected void findByUserId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CarDao carDao = new CarDao();
		
		UserBean userBean = (UserBean)req.getSession().getAttribute("userBean");
		int user_id = userBean.getUser_id();
		String a = req.getParameter("a");
		List<AddrBean> addrlist = addrDao.getPage(user_id);
		req.setAttribute("carlist", carDao.findByUserId(user_id));
		req.setAttribute("addrlist",addrlist);
		if(req.getParameter("goods_id")!=null){
			int goods_id = Integer.parseInt(req.getParameter("goods_id"));
			GoodsBean goodsBean = new GoodsDao().findById(goods_id);
			req.setAttribute("goodsBean", goodsBean);
			int addnumber = Integer.parseInt(req.getParameter("addnumber"));
			req.setAttribute("addnumber", addnumber);
			req.getRequestDispatcher("jiesuan.jsp").forward(req, resp);
		}else{
			//if(a!=null){
				//req.getRequestDispatcher("../myaddr/myaddr.jsp").forward(req, resp);
		//	}else{
				req.getRequestDispatcher("jiesuan.jsp").forward(req, resp);
		//	}
		}
		
	}
	
	protected void getaddrByUserId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CarDao carDao = new CarDao();
		
		int user_id = ((UserBean)req.getSession().getAttribute("userBean")).getUser_id();
		
		List<AddrBean> addrlist = addrDao.getPage(user_id);
		
		req.setAttribute("addrlist",addrlist);
		
		req.getRequestDispatcher("../myaddr/myaddr.jsp").forward(req, resp);
		
		
	}
}
