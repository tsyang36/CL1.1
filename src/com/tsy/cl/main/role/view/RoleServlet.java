package com.tsy.cl.main.role.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsy.cl.main.admin.dao.AdminDao;
import com.tsy.cl.main.role.bean.RoleBean;
import com.tsy.cl.main.role.dao.RoleDao;
import com.tsy.cl.main.user.dao.UserDao;
import com.tsy.cl.util.PageUtil;
import com.tsy.cl.util.StepUtil;

@WebServlet("/page/admin/page/role/roleServlet")
public class RoleServlet extends HttpServlet{
	
	RoleDao roleDao = new RoleDao();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charst=UTF-8");
		String update = req.getParameter("update");
		String method = req.getParameter("method");
		if ("getPage".equals(method)) {

			getPage(req, resp);
		}else if("delete".equals(method)){
			delete(req, resp);
		}else if("findById".equals(method)){
			findById(req, resp);
		} else if ("addOrupdate".equals(method)) {
			if("update".equals(update)){
				
				update(req, resp,req.getParameter("role_id"));
			}else{
				addOrupdate(req, resp);
				}
		}
	}
	
	protected void addOrupdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String role_name = req.getParameter("role_name");
		String state = req.getParameter("state");
		
		RoleBean roleBean = new RoleBean(role_name,state);
		RoleDao roleDao = new RoleDao();
		if(!roleDao.onlyRoleName(role_name)){
			roleDao.save(roleBean);
			resp.sendRedirect("roleServlet?method=getPage");
		}else{
			req.setAttribute("message", "该角色名已经存在不能重复添加！");
			req.getRequestDispatcher("add.jsp").forward(req, resp);
		}
		//getPage(req, resp);
	}
	
	protected void update(HttpServletRequest req, HttpServletResponse resp, String role_id) throws ServletException, IOException {
		//RoleBean roleBean = (RoleBean)req.getAttribute("roleBean");
		//req.setAttribute("role_id", roleBean.getRole_id());
		String role_name = req.getParameter("role_name");
			String state = req.getParameter("state");
			if(!roleDao.onlyRoleNameOtherId(role_name,role_id)){
				if("1".equals(state)){//1表示角色状态为冻结
					AdminDao adminDao = new AdminDao();
					adminDao.blockByroleid(Integer.parseInt(role_id));
				}
				roleDao.update(role_id,role_name,state);
				resp.sendRedirect("roleServlet?method=getPage");
				//getPage(req, resp);
			}else{
				req.setAttribute("message", "该角色名已经存在！修改失败！");
				findById(req, resp);
			}
		
		
	}
	
	protected void findById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String role_id = req.getParameter("role_id");
		RoleDao roleDao = new RoleDao();
		RoleBean roleBean = new RoleBean();
		roleBean = roleDao.findById(role_id);
		req.setAttribute("roleBean", roleBean);
		req.getRequestDispatcher("add.jsp?update=update").forward(req, resp);
	}
	
	protected boolean delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] role_ids = req.getParameterValues("role_ids");
		//System.out.println(role_ids[0]+"role_ids84role");
		RoleDao roleDao = new RoleDao();
		if(roleDao.delete(role_ids)){
			getPage(req, resp);
			return true ;
		}
		req.setAttribute("message1", "该角色下面有管理员，请将管理员删除后再删除角色");
		getPage(req, resp);
		return false;
		
	}
	/**
	 * 
	 * @Description: 查詢所有管理員每页显示10条
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 *             void
	 * @throws @author
	 *             Tang
	 * @date 2017年8月17日 下午5:02:08
	 */
	protected void getPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String role_name = req.getParameter("role_name");
//		req.setAttribute("role_name", role_name);
		String param = "&role_name=";
		if (role_name == null || "".equals(role_name) || "null".equals(role_name)) {
			role_name = "%%";
			
		} else {
			role_name = "%" + role_name + "%";
			param+=role_name;
		}
		//总记录数
		int totalRow = roleDao.getcount(role_name);
		
		
		
		//获取当前页
		int current = Integer.parseInt(req.getParameter("current")==null?"1":req.getParameter("current"));
		PageUtil pageUtil = new PageUtil(current,totalRow,param);
		
		//从哪里开始
		//int begin = pageUtil.getbegin();
		
		
		List<RoleBean> list = roleDao.getPage(role_name, pageUtil.getbegin(), pageUtil.getSize());
		StepUtil stepUtil = new StepUtil();
		req.setAttribute("list", list);
		req.setAttribute("totalRow",totalRow);
		req.setAttribute("pageUtil", pageUtil);
		req.setAttribute("step", new StepUtil().getStep(pageUtil.getCurrent(), 5, pageUtil.getPagenum()));
		req.getRequestDispatcher("table.jsp").forward(req, resp);

	}
}
