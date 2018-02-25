package com.tsy.cl.filter.user;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tsy.cl.main.admin.bean.AdminBean;
import com.tsy.cl.main.user.bena.UserBean;


public class UserFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req =(HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		HttpSession session = req.getSession();
		
		//获取登录对象
		UserBean userBean = (UserBean) session.getAttribute("userBean");
		
		//设置不过滤得到路径||放行不拦截
		String[] array = new String[]{"userServlet?method=login","goodsServlet?method=showGoods","ordersServlet?method=getPage"};
		boolean bool = false;
		
		//获取url路径
		String url =req.getRequestURL().toString()+"?"+req.getQueryString();
		//判断是否过滤
		
		for (String string : array) {
			if(url.contains(string)){
				bool=true;
				break;
			}
		}
		if(bool){
			//不过滤
			arg2.doFilter(arg0, arg1);
		}else if(userBean!=null){
			//不过滤
			arg2.doFilter(arg0, arg1);
		}else{
			//重定向到登录页面
			resp.sendRedirect(req.getContextPath()+"/page/user/login/login.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
