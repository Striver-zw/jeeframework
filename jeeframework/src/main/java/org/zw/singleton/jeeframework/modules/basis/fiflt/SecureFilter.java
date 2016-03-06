
package org.zw.singleton.jeeframework.modules.basis.fiflt;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
/**
 * 
 * 管理过滤器
 * 
 * @author FANGJINXIN
 * 
 */
public class SecureFilter implements Filter {

	protected final Logger logger = Logger.getLogger(this.getClass());

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String uri = request.getRequestURI();
		if(uri.indexOf("login.html") > 0){
			chain.doFilter(request, response);
			return;
		}
		if(uri.indexOf(".jsp")>0){
//			if(uri.indexOf("login.jsp") > 0){
//				chain.doFilter(request, response);
//				return;
//			}else{
//				Object obj = request.getSession().getAttribute(BaseController.USER_ADMIN_SESSION);  
//				if(null==obj){
//					String path = request.getContextPath();
//					String basePath = request.getScheme() + "://"
//							+ request.getServerName() + ":" + request.getServerPort()
//							+ path;
//					response.sendRedirect(basePath + "/admin/login.html");
//					return;
//				}else{
//					chain.doFilter(request, response);
//					return;
//				}
//			}
		}else{
			chain.doFilter(request, response);
			return;
		}
	}

	public void destroy() {

	}

}
