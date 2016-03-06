package org.zw.singleton.jeeframework.common.utils.dwr;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.directwebremoting.Container;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.event.ScriptSessionEvent;
import org.directwebremoting.event.ScriptSessionListener;
import org.directwebremoting.extend.ScriptSessionManager;
import org.directwebremoting.servlet.DwrServlet;
/**
 * 
  * @类名:DwrScriptSessionManagerUtil
  * @类描述:
  * @作者:zw
  * @创建时间:2015年12月28日-上午9:32:28
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2015
 */
public class DwrScriptSessionManagerUtil extends DwrServlet {
	private static final long serialVersionUID = -7504612622407420071L;
	  public void init() throws ServletException {
	    Container container = ServerContextFactory.get().getContainer();
	    ScriptSessionManager manager = container.getBean(ScriptSessionManager.class);
	    
	    ScriptSessionListener listener = new ScriptSessionListener() {
	      public void sessionCreated(ScriptSessionEvent ev) {
	        HttpSession session = WebContextFactory.get().getSession();
//	        String userId = UserUtils.getUser().getId();
//	        String userId="123";getClass()
//	        SysUser user = (SysUser)session.getAttribute("user");
	        System.out.println("拿到当前seeion中的user");
//	        System.out.println("a ScriptSession is created!"+user.getId());
//	        ev.getSession().setAttribute("userId", user.getId());
	      }

	      public void sessionDestroyed(ScriptSessionEvent ev) {
	        System.out.println("a ScriptSession is distroyed");
	      }
	    };

	    manager.addScriptSessionListener(listener);

	  }
}
