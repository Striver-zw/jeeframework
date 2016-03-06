package org.zw.singleton.jeeframework.modules.basis.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

//
public class ResourceCheckFilter extends AccessControlFilter {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	private String errorUrl="/unauth.jsp";
	
	public String getErrorUrl() {
		return errorUrl;
	}

	public void setErrorUrl(String errorUrl) {
		this.errorUrl = errorUrl;
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		System.err.println("------过滤器----------");
		Subject subject = getSubject(request, response);
		String url = getPathWithinApplication(request);
		logger.error("-----"+url);
		return subject.isPermitted(url);
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		HttpServletResponse hsp = (HttpServletResponse)response;
		HttpServletRequest hReq = (HttpServletRequest)request;
		logger.error("-----"+this.errorUrl);
		hsp.sendRedirect(hReq.getContextPath()+"/"+this.errorUrl);
		return false;
	}

}
