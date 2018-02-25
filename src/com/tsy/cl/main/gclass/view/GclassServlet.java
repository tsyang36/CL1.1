package com.tsy.cl.main.gclass.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsy.cl.main.gclass.bena.GclassBean;
import com.tsy.cl.main.gclass.dao.GclassDao;
import com.tsy.cl.util.PageUtil;
import com.tsy.cl.util.StepUtil;

@WebServlet("/page/admin/page/gclass/gclassServlet")
public class GclassServlet extends HttpServlet{
	
	private GclassDao gclassDao = new GclassDao();
	
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
		}else if("all".equals(method)){
			
			all(req,resp);
		}else if("showall".equals(method)){
		
			showall(req,resp);
		}
		
	}
	
	protected void showall(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String gclass_name = req.getParameter("gclass_name");
		
		//String param = "&name=";
		
		if("".equals(gclass_name) || gclass_name==null || "null".equals(gclass_name)){
			
			gclass_name="%%";
		}else{
			
			//param+=name;
			gclass_name="%"+gclass_name+"%";
		}
		
		req.setAttribute("list", gclassDao.getPage(gclass_name, 0, gclassDao.getCount(gclass_name)));
		
		req.getRequestDispatcher("../../../user/login/gclasslist.jsp").forward(req, resp);
		
	}
	
	
	protected void all(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("list", gclassDao.getPage("%%",0, gclassDao.getCount("%%")));
		
		req.getRequestDispatcher("../goods/add.jsp").forward(req, resp);
		
	}
	
	protected void findById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("gclassBean", gclassDao.findById(Integer.parseInt(req.getParameter("gclass_id"))));
		
		
		req.getRequestDispatcher("add.jsp").forward(req, resp);
	}
	
	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] gclass_ids = req.getParameterValues("gclass_ids");
		
		gclassDao.remove(gclass_ids);
		
		getPage(req,resp);
		
	}
	
	protected void addOrupdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String gclass_id = req.getParameter("gclass_id");
		
		GclassBean gclassBean = new GclassBean(req.getParameter("gclass_name"));
		
		if("".equals(gclass_id)){
			
			gclassDao.save(req.getParameter("gclass_name"));
		}else{
			
			gclassBean.setGclass_id(Integer.parseInt(gclass_id));
			
			gclassDao.modify(gclassBean);
		}
		
		getPage(req, resp);
	}
	
	protected void getPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String gclass_name = req.getParameter("gclass_name");
		
		String param = "&gclass_name=";
		
		if(gclass_name==null || "".equals(gclass_name) || "null".equals(gclass_name)){
			
			gclass_name= "%%";
		}else{
			param+=gclass_name;
			gclass_name="%"+gclass_name+"%";
		}
		
		//1.閹槒顔囪ぐ鏇熸殶
		int totalRow = gclassDao.getCount(gclass_name);

		//3.閼惧嘲褰囪ぐ鎾冲妞わ拷
		int current = Integer.parseInt(req.getParameter("current")==null?"1":req.getParameter("current"));
		
		PageUtil pageUtil = new PageUtil(current,totalRow,param);
		
		List<GclassBean> list=gclassDao.getPage(gclass_name, pageUtil.getbegin(), pageUtil.getSize());
		
		req.setAttribute("list", list);
		
		req.setAttribute("pageUtil", pageUtil);
		
		req.setAttribute("step", new StepUtil().getStep(current, 5, pageUtil.getPagenum()));
		
		//鐠囬攱鐪版潪顒�褰傞崚鐨宎ble.jsp妞ょ敻娼伴弰鍓с仛閺佺増宓�
		req.getRequestDispatcher("table.jsp").forward(req, resp);
		
	}

}
