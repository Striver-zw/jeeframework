package org.zw.singleton.jeeframework.common.utils.sessionutils.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Enumeration;
import java.util.HashSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SissionTest
 */
@WebServlet("/ss")
public class SissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SissionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-------------------------------");
		// 拿到session
		HttpSession httpSession = request.getSession();
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			System.out.println("cookies :"+i+"========"+cookies[i].getValue());
		}
		//拿到登录者信息
		Principal userPrincipal = request.getUserPrincipal();
		if(userPrincipal!=null){
			System.out.println(userPrincipal.getName());
		}
		// 设置过期时间 秒
//		httpSession.setMaxInactiveInterval(40);
		
		if(httpSession!=null){
			System.out.println("service sessionId :" + httpSession.getId());
			PrintWriter pw = response.getWriter();
			pw.println("service sessionId :"+httpSession.getId());
		}
		
		ServletContext application = httpSession.getServletContext();
         
         // 在application范围由一个HashSet集保存所有的session
         @SuppressWarnings("unchecked")
		HashSet<HttpSession> sessions = (HashSet<HttpSession>) application.getAttribute("sessions");
        System.out.println("在线数:"+sessions.size());
		
		// 拿到当前session里面放的数据
		Enumeration e = request.getSession().getAttributeNames();
		while (e.hasMoreElements()) {
			String sessionName = (String) e.nextElement();
			// 键值对
			System.out.println("session item name=" + sessionName);
			System.out.println("session item value="
					+ request.getSession().getAttribute(sessionName));
		}
	}

}
