package com.tsy.cl.main.addr.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsy.cl.main.addr.dao.JlDao;

import net.sf.json.JsonUtil;

@WebServlet("/page/user/page/jiesuan/jlServlet")
public class JlServlet extends HttpServlet {
	
	private JlDao jlDao = new JlDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		
		req.setCharacterEncoding("UTF-8");
		
		String method =req.getParameter("method");
		
		if("province".equals(method)){
			
			resp.getWriter().write(JsonUtil.fromObject(jlDao.getProvince()));
			
		}else if("city".equals(method)){
			
			int province  = Integer.parseInt(req.getParameter("provinceId"));
			
			resp.getWriter().write(JsonUtil.fromObject(jlDao.getCity(province)));
			
			
		}else if("district".equals(method)){
			
			int city  = Integer.parseInt(req.getParameter("cityId"));
			
			resp.getWriter().write(JsonUtil.fromObject(jlDao.getdistrict(city)));
			
		}
		
	}
	
	
}
