package com.tsy.cl.main.admin.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tsy.cl.main.admin.bean.AdminBean;
import com.tsy.cl.main.admin.dao.AdminDao;
import com.tsy.cl.main.menu.service.MenuService;
import com.tsy.cl.main.role.dao.RoleDao;
import com.tsy.cl.util.PageUtil;
import com.tsy.cl.util.StepUtil;

public class AdminServlet extends HttpServlet {
	private HttpSession session;
	private AdminDao adminDao = new AdminDao();
	private RoleDao roleDao = new RoleDao();

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

		String method = req.getParameter("method");
		String update = req.getParameter("update");
		if ("login".equals(method)) {

			login(req, resp);
		} else if ("exit".equals(method)) {
			exit(req, resp);
		} else if ("getPage".equals(method)) {
			getPage(req, resp);
		} else if ("addOrupdate".equals(method)) {
			if ("update".equals(update)) {

				update(req, resp);
			} else {
				addOrupdate(req, resp);
			}
		} else if ("delete".equals(method)) {
			delete(req, resp);
		} else if ("findById".equals(method)) {
			findById(req, resp);
		} else if ("allRole".equals(method)) {
			allRole(req, resp);
		}
	}

	protected void allRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("list", roleDao.getPage("%%", 0, roleDao.getcount("%%")));
		req.getRequestDispatcher("../page/admin/add.jsp").forward(req, resp);
	}

	protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdminBean adminBean = (AdminBean) req.getAttribute("adminBean");
		String admin_id = req.getParameter("admin_id");

		String pwd = req.getParameter("pwd");

		String admin_state = req.getParameter("admin_state");

		String role_id = req.getParameter("role_id");
		// AdminBean adminBean = new AdminBean();
		adminDao.update(pwd, role_id, admin_state, admin_id);
		getPage(req, resp);
	}

	protected void findById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String admin_id = req.getParameter("admin_id");
		req.setAttribute("adminBean", adminDao.findById(admin_id));
		req.setAttribute("list", roleDao.getPage("%%", 0, roleDao.getcount("%%")));
		req.setAttribute("update", "update");
		req.getRequestDispatcher("../page/admin/add.jsp?update=update").forward(req, resp);
	}

	protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String teloremail = req.getParameter("teloremail");

		String pwd = req.getParameter("pwd");

		String remember = req.getParameter("remember");

		String realCode = (String) req.getSession().getAttribute("realcode");

		String code = req.getParameter("code");

		if (realCode.equalsIgnoreCase(code)) {
			
			
			AdminBean adminBean = adminDao.findByUserAndPwd(teloremail, pwd);

			if (adminBean != null) {
				
				if(!adminBean.getAdmin_state().equals("0")){
					req.setAttribute("message", "该账号已被冻结，请联系管理员");

					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}

				/*if (remember != null) {
					Cookie cookie = new Cookie("teloremail", teloremail);

					Cookie cookie2 = new Cookie("pwd", pwd);

					cookie.setMaxAge(60 * 60 * 24 * 7);

					cookie2.setMaxAge(60 * 60 * 24 * 7);

					resp.addCookie(cookie);

					resp.addCookie(cookie2);
				}*/

				// ����session����
				session = req.getSession();

				// ��������ֵ
				session.setAttribute("adminBean", adminBean);

				// ����ʧЧʱ��
				session.setMaxInactiveInterval(60 * 30);

				session.setAttribute("list", new MenuService().findByRId(adminBean.getRole_id()));

				resp.sendRedirect("../page/main/main.jsp");
			} else {

				req.setAttribute("message", "账号密码有误");

				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} else {

			req.setAttribute("message", "验证码有误");

			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}

	protected void exit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!session.isNew()) {
			session.invalidate();
		}
		resp.sendRedirect("login.jsp");
	}

	/**
	 * 
	 * @Description: ��ԃ���й���Tÿҳ��ʾ10��
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 *             void
	 * @throws @author
	 *             Tang
	 * @date 2017��8��17�� ����5:02:08
	 */
	protected void getPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// String tel =
		// ((AdminBean)session.getAttribute("adminBean")).getAdmin_tel();
		// String tel =
		// ((AdminBean)session.getAttribute("adminBean")).getAdmin_tel();
		String teloremail = req.getParameter("teloremail");
		String tel = req.getParameter("admin_email");
		req.setAttribute("teloremail", teloremail);
		String param = "";
		String param1 = "&admin_tel=";
		String param2 = "&admin_email=";
		if (teloremail == null || "".equals(teloremail) || "null".equals(teloremail)) {
			teloremail = tel;
			if (teloremail == null || "".equals(teloremail) || "null".equals(teloremail)) {
				teloremail = "%%";
			} else {
				teloremail = "%" + teloremail + "%";
				param1 += teloremail;
				param2 += teloremail;
				param = param1 + param2;
			}
		} else {
			teloremail = "%" + teloremail + "%";
			param1 += teloremail;
			param2 += teloremail;
			param = param1 + param2;
		}
		// �ܼ�¼��
		int totalRow = adminDao.getcount(teloremail);

		// ��ȡ��ǰҳ
		int current = Integer.parseInt(req.getParameter("current") == null ? "1" : req.getParameter("current"));
		PageUtil pageUtil = new PageUtil(current, totalRow, param);
		// �����￪ʼ
		// int begin = pageUtil.getbegin();

		List<AdminBean> list = (List<AdminBean>) adminDao.getPage(teloremail, pageUtil.getbegin(), pageUtil.getSize());
		req.setAttribute("list", list);
		req.setAttribute("totalRow", totalRow);
		req.setAttribute("pageUtil", pageUtil);
		req.setAttribute("step", new StepUtil().getStep(pageUtil.getCurrent(), 5, pageUtil.getPagenum()));

		req.getRequestDispatcher("../page/admin/table.jsp").forward(req, resp);

	}

	protected void addOrupdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String admin_tel = req.getParameter("admin_tel");
		String admin_email = req.getParameter("admin_email");
		String pwd = req.getParameter("pwd");
		String admin_state = req.getParameter("admin_state");
		int role_id = Integer.parseInt(req.getParameter("role_id"));
		AdminBean adminBean = new AdminBean(admin_tel, admin_email, pwd, admin_state, role_id);
		if(!new AdminDao().onlyTelAndEmail(admin_tel,admin_email)){
			req.setAttribute("message", "第几个");
			req.getRequestDispatcher("add.jsp").forward(req, resp);
		}
		new AdminDao().save(adminBean);
		getPage(req, resp);
	}

	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// int id = Integer.parseInt(req.getParameter("id"));
		String[] admin_ids = req.getParameterValues("admin_ids");
		AdminDao adminDao = new AdminDao();
		adminDao.delete(admin_ids);
		getPage(req, resp);
	}
}
