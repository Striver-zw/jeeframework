package org.zw.singleton.jeeframework.common.utils.sysconfig;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

import org.zw.singleton.jeeframework.common.utils.download.FileUtilsJ;

/**
 * 性能优化问题
 * 	http://zhidao.baidu.com/link?url=SoSprKhSR7rAoPNMJMQIN-8RNolrOMvACczFSMT_EtaBmLS4I52MyP-w5dqdip61Whw-M-VWcsrSHwxp22dstK
 * 代码优化：
 * 	http://www.cnblogs.com/chinafine/articles/1787118.html
  * @类名:SysData
  * @类描述:
  * @作者:张威
  * @创建时间:2016年1月6日-上午9:43:38
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2016
 */
public class SysData {

	public static void main(String[] args) {
		SysData s = new SysData();
		s.memoryData();
	}
	
	public void memoryData(){
		
//		==========================================================================
//		Runtime rt = Runtime.getRuntime();
//		long totalMemorySize = rt.totalMemory(); //初始的总内存
//		long maxMemorySiz = rt.maxMemory(); //最大可用内存
//		long freeMemorySize = rt.freeMemory(); //当前可用内存
		
		Runtime rt = Runtime.getRuntime();
		long freeMemory = rt.freeMemory();//空闲内存
//		long freeMemory1 = rt.maxMemory() ;// 返回 Java 虚拟机试图使用的最大内存量。
		long g = rt.totalMemory();// 返回 Java 虚拟机中的内存总量。
//		System.out.println("虚拟机试图使用的最大内存量："+ FileUtilsJ.FormetFileSize(freeMemory1));
		
//		========================================================================
		MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
		MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage(); //椎内存使用情况
		long init = memoryUsage.getInit(); //初始的总内存
		long max = memoryUsage.getMax(); //最大可用内存
		long used = memoryUsage.getUsed(); //已使用的内存
		
//		long init = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getInit(); 
//		long max = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getMax(); 
//		long used = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed();
		
		System.out.println("最大可用内存："+FileUtilsJ.FormetFileSize(max));
		System.out.println("初始的总内存："+FileUtilsJ.FormetFileSize(init));
		System.out.println("空闲内存："+FileUtilsJ.FormetFileSize(freeMemory));
		
		System.out.println("虚拟机中的内存总量:"+FileUtilsJ.FormetFileSize(g));
		System.err.println("使用内存："+FileUtilsJ.FormetFileSize(used));
//		long go = g-freeMemory;
		
//		总内存 - 空闲内存 = 使用内存
//		System.err.println("使用内存："+FileUtilsJ.FormetFileSize(go));
		
//		==================================================================
//		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
//		long currentCpuTime = threadMXBean.getCurrentThreadCpuTime(); //当前线程的cpu使用时间
//		long someThreadId = 709817L; //假定有某个线程的ID是709817
//		long someThreadCpuTime = threadMXBean.getThreadCpuTime(someThreadId); //获取ID为someThreadId即709817的线程的cpu时间
//		System.err.println(currentCpuTime);
//		System.out.println(someThreadCpuTime);
//		
//		long nanoTime = System.nanoTime();
//		System.out.println(nanoTime);
//		int a = 90;
//		System.out.println(a>>1);
//		System.out.println(a<<3);
		
//		=========================================================================

	}
}
