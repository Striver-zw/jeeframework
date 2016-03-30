package org.zw.singleton.jeeframework.common.utils.sessionutils.listener;

import java.util.HashSet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * 获取在线人数
  * @className: MySessionListener
  * @description:
  * @author: singleton-zw
  * @createDate: 2016年3月30日-上午11:54:43
  * @updateAuthor:
  * @updateDate:
  * @updateDesc:
  * @version: v1.0
  * @Copyright (c)-2016
 */
@SuppressWarnings("unchecked")
public class MySessionListener implements HttpSessionListener {
	/**
	 * 使用
	 *  <listener>
    		<listener-class>listener.MySessionListener</listener-class>
  		</listener>
	  * @enclosingMethod: sessionCreated
	  * @overridden:@see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	  * @methodsDescription:
	  * @param event
	  * @author: singleton-zw
	  * @return: void
	 */
    public void sessionCreated(HttpSessionEvent event) {
           HttpSession session = event.getSession();
           ServletContext application = session.getServletContext();
           
           // 在application范围由一个HashSet集保存所有的session         
           HashSet<HttpSession> sessions = (HashSet<HttpSession>) application.getAttribute("sessions");
           if (sessions == null) {
               sessions = new HashSet<HttpSession>();
               application.setAttribute("sessions", sessions);
           }
           
           // 新创建的session均添加到HashSet集中
           sessions.add(session);
           // 可以在别处从application范围中取出sessions集合
           // 然后使用sessions.size()获取当前活动的session数，即为“在线人数”
    }

    public void sessionDestroyed(HttpSessionEvent event) {
           HttpSession session = event.getSession();
           ServletContext application = session.getServletContext();
           HashSet<HttpSession> sessions = (HashSet<HttpSession>) application.getAttribute("sessions");
           
           // 销毁的session均从HashSet集中移除
           sessions.remove(session);
    }
}