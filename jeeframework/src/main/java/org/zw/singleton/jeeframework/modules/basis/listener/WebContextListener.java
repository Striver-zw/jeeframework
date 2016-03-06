package org.zw.singleton.jeeframework.modules.basis.listener;

import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.zw.singleton.jeeframework.common.utils.times.CtimeDateFormat;


/**
 * spring监听器
  * @ClassName:WebContextListener
  * @Description:
  * @Author:singleton-zw
  * @CreateDate:2016年2月6日-下午9:27:52
  * @UpdateAuthor:
  * @UpdateDate:
  * @UpdateDesc:
  * @version: v1.0
  * @Copyright (c)-2016
 */
public class WebContextListener extends ContextLoaderListener {
	
	/**
	 * 初始化容器
	  * @EnclosingMethod:initWebApplicationContext
	  * @Overridden:@see org.springframework.web.context.ContextLoader#initWebApplicationContext(javax.servlet.ServletContext)
	  * @MethodsDescription:
	  * @param arg0
	  * @return
	  * @Author:singleton-zw
	  * @Return:WebApplicationContext
	 */
	@Override
	public WebApplicationContext initWebApplicationContext(ServletContext arg0) {


		System.out.println("====*==========*=========*============*=========\n"
				+ "\t欢迎使用：jeeframework\n"
				+"\t启动时间："+CtimeDateFormat.DataToString(new Date())
				+ "\n====*==========*=========*============*=========");
		
		return super.initWebApplicationContext(arg0);
	}
}
