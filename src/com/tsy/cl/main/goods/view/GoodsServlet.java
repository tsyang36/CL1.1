package com.tsy.cl.main.goods.view;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DataPacket;
import org.apache.commons.fileupload.FileUploadCom;

import com.tsy.cl.main.admin.bean.AdminBean;
import com.tsy.cl.main.gclass.dao.GclassDao;
import com.tsy.cl.main.goods.bean.GoodsBean;
import com.tsy.cl.main.goods.dao.GoodsDao;
import com.tsy.cl.util.PageUtil;
import com.tsy.cl.util.StepUtil;


@WebServlet("/page/goodsServlet")
public class GoodsServlet extends HttpServlet {
	
	private GoodsDao goodsDao = new GoodsDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charst=UTF-8");
		
		String method = req.getParameter("method");
		if("getPage".equals(method)){
			
			getPage(req,resp);
		}else if("addOrupdate".equals(method)){
			addOrupdate(req,resp);
		}else if("findById".equals(method)){
			
			findById(req,resp);
		}else if("delete".equals(method)){
			
			delete(req,resp);
		}else if("showGoods".equals(method)){
			
			showGoods(req,resp);
		}else if("showlist".equals(method)){
		
			showlist(req,resp);
		}else if("sousuo".equals(method)){
		
			sousuo(req,resp);
		}else if("home".equals(method)){
		
			home(req,resp);
		}
		
	}
	
	protected void home(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//if(request.getAttribute("list")==null){
		//request.setAttribute("list", new GoodsDao().getPage("%%", 0, 10));
		List<Integer> arr = new GclassDao().getIdArr();
		int random = 0;
		int random1 = 0;

		random = (int) (Math.random() * (arr.size()));
		req.setAttribute("list", new GoodsDao().findByGclassId(arr.get(random), 0, 2));

		random1 = (int) (Math.random() * (arr.size()));
		while (random == random1) {
			random1 = (int) (Math.random() * (arr.size()));
		}
		req.setAttribute("list1", new GoodsDao().findByGclassId(arr.get(random1), 0, 2));

		req.setAttribute("list2", new GoodsDao().findByGclassId(8, 0, 3));//精选的gcalss_id为8
		
		req.getRequestDispatcher("user/login/home.jsp").forward(req, resp);
	/* 	System.out.println(arr);
		System.out.println(arr.get(random));
		System.out.println(arr.get(random1)); */
	
	}
	
	protected void sousuo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String goods_name = req.getParameter("goods_name");
		//req.setAttribute("goods_name", goods_name);
		//String param = "&goods_name=";
		if (goods_name == null || "".equals(goods_name) || "null".equals(goods_name)) {
			goods_name = "%%";
		}else{
			goods_name = "%" + goods_name + "%";
		}
		//param += goods_name;
				// 总记录数
				int totalRow = goodsDao.getCount(goods_name);

				// 获取当前页
				int current = Integer.parseInt(req.getParameter("current") == null ? "1" : req.getParameter("current"));
				PageUtil pageUtil = new PageUtil(current, totalRow, goods_name);
				// 从哪里开始
				// int begin = pageUtil.getbegin();

				List<GoodsBean> shangchenglist = (List<GoodsBean>) goodsDao.getPage(goods_name, pageUtil.getbegin(), pageUtil.getSize());

				req.setAttribute("shangchenglist", shangchenglist);
				req.setAttribute("totalRow", totalRow);
				req.setAttribute("pageUtil", pageUtil);
				req.setAttribute("step", new StepUtil().getStep(pageUtil.getCurrent(), 5, pageUtil.getPagenum()));
				req.getRequestDispatcher("user/login/shangcheng.jsp").forward(req, resp);
	}
	
	protected void getPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String goods_name = req.getParameter("goods_name");
		
		String param = "&goods_name=";
		
		if(goods_name==null || "".equals(goods_name) || "null".equals(goods_name)){
			
			goods_name= "%%";
		}else{
			param+=goods_name;
			goods_name="%"+goods_name+"%";
		}
		
		int totalRow = goodsDao.getCount(goods_name);
		
		int current = Integer.parseInt(req.getParameter("current")==null?"1":req.getParameter("current"));
		
		PageUtil pageUtil = new PageUtil(current,totalRow,param);
		
		List<GoodsBean> list=goodsDao.getPage(goods_name, pageUtil.getbegin(), pageUtil.getSize());
		
		req.setAttribute("list", list);
		
		req.setAttribute("pageUtil", pageUtil);
		
		req.setAttribute("step", new StepUtil().getStep(current, 5, pageUtil.getPagenum()));
		
		req.getRequestDispatcher("admin/page/goods/table.jsp").forward(req, resp);
		
		
	}
	protected void showlist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*UserBean userBean = (UserBean)req.getSession().getAttribute("userBean");
		int id = userBean.getId();*/
		req.setAttribute("list", goodsDao.findByGclassId(Integer.parseInt(req.getParameter("goods_id"))));
		
		req.getRequestDispatcher("user/login/goodslist.jsp").forward(req, resp);
	}
	
	protected void showGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("goodsBean", goodsDao.findById(Integer.parseInt(req.getParameter("goods_id"))));
		req.getRequestDispatcher("user/login/goodsxx.jsp").forward(req, resp);
	}
	
	
	
	protected void findById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("goodsBean", goodsDao.findById(Integer.parseInt(req.getParameter("goods_id"))));
		
		req.setAttribute("list", new GclassDao().getPage("%%", 0, new GclassDao().getCount("%%")));
		
		req.getRequestDispatcher("admin/page/goods/add.jsp").forward(req, resp);
		
	}
	
	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] goods_ids = req.getParameterValues("goods_ids");
		
		goodsDao.remove(goods_ids);
		
		getPage(req,resp);
	}
	
	protected void addOrupdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DataPacket dataPacket = new FileUploadCom().upload(req);
		GoodsBean goodsBean = new GoodsBean(dataPacket.getValue("goods_name"),dataPacket.getValue("goods_image"),new BigDecimal(dataPacket.getValue("goods_price")),dataPacket.getValue("goods_desc"),Integer.parseInt(dataPacket.getValue("gclassid")));
		
		String goods_id = dataPacket.getValue("goods_id");
		String goods_image = dataPacket.getValue("goods_image");
		
		if("".equals(goods_id)){
			
			goodsDao.save(goodsBean);
		}else if(!"".equals(goods_image)){
			
			goodsBean.setGoods_id(Integer.parseInt(goods_id));
			
			goodsDao.modify(goodsBean);
			dataPacket.write("goods_image", "upload\\"+dataPacket.getValue("goods_image"));
		}else{
			goodsBean.setGoods_id(Integer.parseInt(goods_id));
			
			goodsDao.modifyNoImage(goodsBean);
		}
		
		
		getPage(req, resp);
	}
	
	
	

}
