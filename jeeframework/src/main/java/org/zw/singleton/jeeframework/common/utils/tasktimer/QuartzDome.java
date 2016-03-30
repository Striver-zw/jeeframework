package org.zw.singleton.jeeframework.common.utils.tasktimer;

import java.util.Date;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

/**
 * http://cron.qqe2.com/
  * @类名:QuartzDome
  * @类描述:
  * @作者:
  * @创建时间:2016年1月13日-上午10:13:03
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2016
 */
@Service
public class QuartzDome {

	/**
	 * 采用依赖注入的方式前提是要一开始就启动定时器 否则拿不到 SchedulerFactoryBean
	 * lazy-init="false"
	 */
//	@Autowired
//	private  SchedulerFactoryBean startQuertz;
//	@Autowired
//	private CronTriggerFactoryBean doTime;
//	@Autowired
//	private MethodInvokingJobDetailFactoryBean jobtask;
	private static SchedulerFactory startQuertz = new StdSchedulerFactory();
	Scheduler sched;
	
	/**
	 * 这种方式需要在配置文件中加入
	 * <property name="exposeSchedulerInRepository" value="true" />
	 * @方法说明:
	 * @方法名称:getSchedulerFactory
	 * @作者:
	 * @返回值:void
	 */
	public void getSchedulerFactory(){
		try {
			sched = startQuertz.getScheduler("startQuertz");
//			sched.getTrigger(triggerKey)
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	private static int counter = 0;  
	/**
	 * 执行的方法
	 * @方法说明:
	 * @方法名称:execute
	 * @作者:
	 * @返回值:void
	 */
    public void execute()  {  
   
//    	getSchedulerFactory();
        long ms = System.currentTimeMillis();  
        System.out.println("\t\t" + new Date(ms));  
        System.out.println("(" + counter++ + ")"); 
//        if(counter>2){
//        	System.out.println("移除");
////        	shutdownJobs();
//        }
    }  
    
    /**
     * 关闭所有定时任务 
     * @方法说明:
     * @方法名称:shutdownJobs
     * @作者:
     * @返回值:void
     */
    public  void shutdownJobs() {  
        try {  
//            Scheduler sched = startQuertz.getScheduler();  
            if (!sched.isShutdown()) {  
                sched.shutdown();  
            }  
            System.out.println("定时任务停止");
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
}
