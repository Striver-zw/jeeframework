package org.zw.singleton.jeeframework.common.utils.dwr;
import javax.servlet.ServletException;

import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContextFactory;
/**
 * 从页面拿到值
  * @类名:MessagePush
  * @类描述:
  * @作者:zw
  * @创建时间:2015年12月27日-下午4:56:53
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2015
 */
public class MessagePush {
	
	/**
	 * 页面循环调用该方法
	 * @param userId
	 */
	public void onPageLoad(String userId) {

        ScriptSession scriptSession = WebContextFactory.get().getScriptSession();
        System.out.println(userId+"----------");
        scriptSession.setAttribute("userId", userId);
        DwrScriptSessionManagerUtil dwrScriptSessionManagerUtil = new DwrScriptSessionManagerUtil();
       
        try {
       	 	dwrScriptSessionManagerUtil.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }

	}
}
