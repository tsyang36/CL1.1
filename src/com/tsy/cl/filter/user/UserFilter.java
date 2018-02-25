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
		
		//��ȡ��¼����
		UserBean userBean = (UserBean) session.getAttribute("userBean");
		
		//���ò����˵õ�·��||���в�����
		String[] array = new String[]{"userServlet?method=login","goodsServlet?method=showGoods","ordersServlet?method=getPage"};
		boolean bool = false;
		
		//��ȡurl·��
		String url =req.getRequestURL().toString()+"?"+req.getQueryString();
		//�ж��Ƿ����
		
		for (String string : array) {
			if(url.contains(string)){
				bool=true;
				break;
			}
		}
		if(bool){
			//������
			arg2.doFilter(arg0, arg1);
		}else if(userBean!=null){
			//������
			arg2.doFilter(arg0, arg1);
		}else{
			//�ض��򵽵�¼ҳ��
			resp.sendRedirect(req.getContextPath()+"/page/user/login/login.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
