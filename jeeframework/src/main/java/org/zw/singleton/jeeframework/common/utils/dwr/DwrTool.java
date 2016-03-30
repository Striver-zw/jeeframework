package org.zw.singleton.jeeframework.common.utils.dwr;
import java.util.Collection;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;
public class DwrTool {
	
	/**
	 * 给用户推送信息
	 * @param userid
	 * @param message 消息内容
	 */
	public static void sendMessageAuto(String userid, String message) {

	    final String userId =userid;
//	    final String userId = "123";
		
	    System.out.println(userId+"----页面传过来的用户id-------");
	    final String autoMessage = message;

	    Browser.withAllSessionsFiltered(new ScriptSessionFilter() {
			
	      public boolean match(ScriptSession session) {

	        if (session.getAttribute("userId") == null) {
	          return false;
	        } else {
	          return (session.getAttribute("userId")).equals(userId);
	        }
	      }

	    }, new Runnable() {	    	
	    	ScriptBuffer script = new ScriptBuffer();
	    	public void run() {
		    	  System.out.println("================发送消息给用户======================"+userId);
		    	  script.appendCall("showMessage", autoMessage);
	
		    	  Collection<ScriptSession> sessions = Browser.getTargetSessions();
		    	  for (ScriptSession ss : sessions) {
		    		  ss.addScript(script);
		    	  }
	    		}

	    	});
	    }
	}

