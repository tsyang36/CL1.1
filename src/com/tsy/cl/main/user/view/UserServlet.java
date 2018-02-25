package com.tsy.cl.main.user.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.tsy.cl.main.gclass.dao.GclassDao;
import com.tsy.cl.main.goods.dao.GoodsDao;
import com.tsy.cl.main.user.bena.UserBean;
import com.tsy.cl.main.user.dao.UserDao;


@WebServlet("/page/user/login/userServlet")
public class UserServlet extends HttpServlet {
	
	private UserDao userDao = new UserDao();
	
	private GoodsDao goodsDao = new GoodsDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		resp.setContentType("text/html;charset=UTF-8");
		
		String method = req.getParameter("method");
		
		if("add".equals(method)){
			
			add(req,resp);
		}else if("login".equals(method)){
			
			login(req,resp);
		}else if("exit".equals(method)){
			
			exit(req,resp);
		}else if("toupdatepassword".equals(method)){
		
			toupdatepassword(req,resp);
		}else if("updatepassword".equals(method)){
		
			updatepassword(req,resp);
		}
		
	}
	
	protected void toupdatepassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_password = ((UserBean)req.getSession().getAttribute("userBean")).getUser_password();
		req.getRequestDispatcher("updatepassword.jsp").forward(req, resp);
	}
	protected void updatepassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_password1 = req.getParameter("user_password1");
		int user_id = ((UserBean)req.getSession().getAttribute("userBean")).getUser_id();
		userDao.updatepassword(user_password1,user_id);
		req.setAttribute("message","密码已经修改，请重新登录");
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	
	protected void exit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_teloreamil = (String) req.getSession().getAttribute("user_teloreamil");
		String user_password =(String) req.getSession().getAttribute("user_password");
		req.getSession().invalidate();
		req.getSession().setAttribute("user_teloreamil",user_teloreamil);
		req.getSession().setAttribute("user_password",user_password);
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	
	protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserBean userBean=userDao.findTelEmaAndPwd(new UserBean(req.getParameter("user_teloreamil"),req.getParameter("user_teloreamil"),req.getParameter("user_password")));
		
		if(userBean!=null && !"".equals(userBean) && !"null".equals(userBean)){
			req.getSession().setAttribute("userBean", userBean);
			if(req.getParameter("remember")!=null){
				req.getSession().setAttribute("user_teloreamil",req.getParameter("user_teloreamil"));
				req.getSession().setAttribute("user_password",req.getParameter("user_password"));
			}
			req.getRequestDispatcher("../../../index.jsp").forward(req, resp);
			
		}else{
			req.setAttribute("message","账号密码有误");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
	
	protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_tel = req.getParameter("user_tel");
		String user_email = req.getParameter("user_email");
		String user_password = req.getParameter("user_password");
		UserBean userBean = new UserBean(user_tel,user_email,user_password);
		if(userDao.isexist(user_tel)){
			req.setAttribute("message1","该手机已经注册过，请重新注册或直接登录");
			req.getRequestDispatcher("reg.jsp").forward(req, resp);
		}else if(userDao.isexist(user_email)){
			req.setAttribute("message1","该邮箱已经注册过，请重新注册或直接登录");
			req.getRequestDispatcher("reg.jsp").forward(req, resp);
		}else{
			userDao.save(userBean);
			req.setAttribute("message","注册成功，请登录");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
	
}
