package org.zw.singleton.jeeframework.common.utils.mail;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class SpringMail {

	@Autowired
	private JavaMailSenderImpl mailSender;
	@Autowired
	private SimpleMailMessage simpleMailMessage;

	public void work() {
		System.out.println("执行了");
		List<File> list = new ArrayList<File>();
		list.add(new File("D:\\1.zip"));
		list.add(new File("D:\\2.zip"));
		SpringMailUtil.sendMimeMessageHelper(mailSender, simpleMailMessage, "2321277858@qq.com", null, "下午5点准备开会",
				"请所有人都到", list);

		simpleMailMessage.getFrom();
		// SpringMailUtil.sendMail(mailSender, simpleMailMessage,
		// "2321277858@qq.com", null, "下午5点准备开会", "请所有人都到");

	}
	 /**
	  * 纯java版
	  * @方法说明:
	  * @方法名称:main
	  * @param args
	  * @作者:
	  * @返回值:void
	  */
	 public static void main(String[] args) {
//		 JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();  
//	        // 设定mail server  
//	        senderImpl.setHost("smtp.sina.com");  
//	  
//	        // 建立邮件消息  
//	        SimpleMailMessage mailMessage = new SimpleMailMessage();  
//	        // 设置收件人，寄件人 用数组发送多个邮件  
//	        // String[] array = new String[] {"sun111@163.com","sun222@sohu.com"};  
//	        // mailMessage.setTo(array);  
//	        mailMessage.setTo("2321277858@qq.com");  
//	        mailMessage.setFrom("jeeframework@sina.com");  
//	        mailMessage.setSubject(" 数据已经乘车");  
//	        mailMessage.setText("巨化股份 ");  
//	  
//	        senderImpl.setUsername("jeeframework"); // 根据自己的情况,设置username  
//	        senderImpl.setPassword("2321277858zw"); // 根据自己的情况, 设置password  
//	  
//	        Properties prop = new Properties();  
//	        prop.put(" mail.smtp.auth ", " true "); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确  
//	        prop.put(" mail.smtp.timeout ", " 25000 ");  
//	        senderImpl.setJavaMailProperties(prop);  
//	        // 发送邮件  
//	        senderImpl.send(mailMessage);  
//	  
//	        System.out.println(" 邮件发送成功.. ");  
	}
}
