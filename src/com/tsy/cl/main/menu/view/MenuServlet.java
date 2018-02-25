package com.tsy.cl.main.menu.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsy.cl.main.menu.bean.MenuBean;
import com.tsy.cl.main.menu.service.MenuService;
import com.tsy.cl.main.role_menu.dao.RMDao;
import com.tsy.cl.util.PageUtil;
import com.tsy.cl.util.StepUtil;


@WebServlet("/page/admin/page/menu/menuServlet")
public class MenuServlet extends HttpServlet {
	
	private  MenuService menuService = new MenuService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String method = req.getParameter("method");
		
		if("getPage".equals(method)){
			
			getPage(req,resp);
		}else if("all".equals(method)){
			
			all(req,resp);
		}else if("addOrupdate".equals(method)){
			
			addOrupdate(req,resp);
		}else if("findById".equals(method)){
			
			findById(req,resp);
		}else if("delete".equals(method)){
			
			delete(req,resp);
		}
	}
	
	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] menu_ids = req.getParameterValues("menu_ids");
		
		menuService.delete(menu_ids);
		
		getPage(req,resp);
		
	}
	
	protected void findById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("menuBean", menuService.findById(Integer.parseInt(req.getParameter("menu_id"))));
		
		all(req,resp);
		
	}
	
	protected void addOrupdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RMDao rmDao = new RMDao();
		
		String menu_id =req.getParameter("menu_id");
		
		MenuBean menuBean = new MenuBean(req.getParameter("menu_name"),req.getParameter("menu_url"),Integer.parseInt(req.getParameter("father_id")));
		
		if(menu_id==""){
			
			menuService.save(menuBean);
			int menuid = menuService.getidbymenuBean(menuBean);
			//超级管理员加个这个新的菜单
			rmDao.savesuperone(menuid);
		}else{
			
			menuBean.setMenu_id(Integer.parseInt(menu_id));
			
			menuService.update(menuBean);
		}
		
		resp.sendRedirect("menuServlet?method=getPage");
	}
	
	protected void all(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("list", menuService.getPage("%%", 0, menuService.getCount("%%")));
		
		if("1".equals(req.getParameter("a"))){
			String role_id = req.getParameter("role_ids");
			req.setAttribute("role_id", role_id);
			req.getRequestDispatcher("../role/fenpei.jsp").forward(req, resp);
		}else{
			req.getRequestDispatcher("add.jsp").forward(req, resp);
		}
	}
	
	protected void getPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String menu_name = req.getParameter("menu_name");
		
		String param = "&menu_name=";
		
		if(menu_name==null || "".equals(menu_name) || "null".equals(menu_name)){
			
			menu_name = "%%";
		}else{
			
			param += menu_name;
			menu_name="%"+menu_name+"%";
		}
		
		int totalRow = menuService.getCount(menu_name);
		
		int current = Integer.parseInt(req.getParameter("current")==null?"1":req.getParameter("current"));
		
		PageUtil pageUtil = new PageUtil(current,totalRow,param);
		
		StepUtil stepUtil = new StepUtil();
		
		req.setAttribute("step", stepUtil.getStep(current,5, pageUtil.getPagenum()));
		
		req.setAttribute("list", menuService.getPage(menu_name,pageUtil.getbegin(), pageUtil.getSize()));
		
		req.setAttribute("pageUtil", pageUtil);
		
		req.getRequestDispatcher("table.jsp").forward(req, resp);
		
	}
	
	

}
