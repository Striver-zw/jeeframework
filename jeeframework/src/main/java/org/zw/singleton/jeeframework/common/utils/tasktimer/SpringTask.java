package org.zw.singleton.jeeframework.common.utils.tasktimer;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * <!-- 计划任务配置，用 @Service @Lazy(false)标注类，用@Scheduled(cron = "0 0 2 * * ?")标注方法 -->
  * @类名:Testo
  * @类描述:
  * @作者:张威
  * @创建时间:2016年1月11日-下午2:22:32
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2016
 */
@Service
@Lazy(false)
public class SpringTask {

//	@Scheduled(cron = "0/1 * * * * ?")
//	public void gg(){
//		System.out.println("正在调度");
//	}
//	
//	@Scheduled(cron = "0/3 * * * * ?")
//	public void gg2(){
//		System.out.println("正在调度2");
//	}
	
}
