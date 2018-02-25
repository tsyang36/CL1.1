package com.tsy.cl.main.role_menu.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsy.cl.main.menu.bean.MenuBean;
import com.tsy.cl.main.menu.service.MenuService;
import com.tsy.cl.main.role_menu.dao.RMDao;

@WebServlet("/page/admin/page/role/rmServlet")
public class RMServlet extends HttpServlet {
	RMDao rmDao = new RMDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String method = req.getParameter("method");
		if ("add".equals(method)) {
			add(req, resp);
		}
	}

	protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int role_id = Integer.parseInt(req.getParameter("roleId"));

		rmDao.remove(role_id);

		String[] role_ids = req.getParameterValues("role_ids");

		rmDao.save(role_ids, role_id);
		resp.sendRedirect("roleServlet?method=getPage");
	}

}
