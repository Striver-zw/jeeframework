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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zw.singleton.jeeframework.app.sysutils.RequestDeviceUtil;


/**
 * 
  * @类名:AuthFilter
  * @类描述:过滤器
  * @作者:张威
  * @创建时间:2015年9月8日-下午1:24:32
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright (c)-2015
 */
public class AuthFilter implements Filter { 
    private static Log log = LogFactory.getLog(AuthFilter.class); 
    

    public void init(FilterConfig filterConfig) throws ServletException { 
        if(log.isDebugEnabled()){ 
            log.debug("初始化过滤器。"); 
        } 
    } 

    public void doFilter(ServletRequest servletRequest, 
            ServletResponse servletResponse, FilterChain filterChain) 
            throws IOException, ServletException { 
        /** 
         * 1,doFilter方法的第一个参数为ServletRequest对象。此对象给过滤器提供了对进入的信息（包括 
         * 表单数据、cookie和HTTP请求头）的完全访问。第二个参数为ServletResponse，通常在简单的过 
         * 滤器中忽略此参数。最后一个参数为FilterChain，此参数用来调用servlet或JSP页。 
         */ 
    	
        HttpServletRequest request = (HttpServletRequest) servletRequest; 
        /** 
         * 如果处理HTTP请求，并且需要访问诸如getHeader或getCookies等在ServletRequest中 
         * 无法得到的方法，就要把此request对象构造成HttpServletRequest 
         */ 
        HttpServletResponse response = (HttpServletResponse) servletResponse; 

        //过滤url后面带参数的情况
    	
    	int index=request.getRequestURI().indexOf("?");
    	String apath=request.getRequestURI();
    	
    	if(index !=-1){
    		apath=apath.substring(0, index);
    	}
//    	log.info("------apath---"+apath); 
//    	log.info(apath.indexOf(request.getContextPath()));
    	boolean deviceNews = RequestDeviceUtil.isMobileDeviceNews(request);
    	if(!deviceNews)  log.info("-------web端请求---"); 
    	if(!deviceNews){
    		/**
    		 * web端  都是有admin 所以不需要控制
    		 * 这里主要控制的login  login.jsp这两个
    		 * 移动端的登录不会走进 web端的
    		 */
//    		if(apath.indexOf("login")==-1 && apath.indexOf("login.jsp")==-1){
//        		AdmainUser admainUser = (AdmainUser)request.getSession().getAttribute("admainUser");
//        		if(admainUser!=null){
//        			log.debug("登录成功---------"+admainUser.getAdminname()); 
//        			filterChain.doFilter(request, response);
//        		}else{
////        			if(apath.indexOf("main.jsp")!=-1){
//        				log.debug("没有登录。"); 
//        				response.sendRedirect("/lifeassistant/admin/login.jsp");
////        			}else{
////        				response.setStatus(499);
////        				log.debug("登录。"); 
//////        				response.sendRedirect("/lifeassistant");
////        			}
//        		}
//        	}else{
//        		filterChain.doFilter(request, response);
//        	}
    		filterChain.doFilter(request, response);
    	}else{//移动端
    		/**
    		 * 移动端暂时不 处理
    		 */
    		filterChain.doFilter(request, response);
//    		User user = (User)request.getSession().getAttribute("user");
    		log.debug("移动端请求---------"); 
//    		if((apath.indexOf("admin")!=-1 && apath.indexOf(".do")!=-1)|| apath.indexOf("main.jsp")!=-1){
//    		if(user!=null && apath.indexOf("admin")!=-1 ){
//    			log.debug("登录成功---------"+user.getName()); 
//    			filterChain.doFilter(request, response);
//    		}else{
//    			log.debug("没有登录。"); 
//    		}
//    	}
    	}
//    	
//    
    }
    
    public void destroy() { 

    } 
}
