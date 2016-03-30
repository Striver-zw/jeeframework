package org.zw.singleton.jeeframework.common.utils.mail;

import java.io.File;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SpringMailUtil {

	/**
	 * 发送简单的邮箱消息
	 * @方法说明:
	 * @方法名称:sendMail
	 * @param mailSender
	 * @param simpleMailMessage
	 * @param mail  收件人
	 * @param mails 群发人
	 * @param subject 主题
	 * @param text 内容
	 * @作者:
	 * @返回值:boolean
	 */
	public static boolean sendMail(JavaMailSender mailSender,SimpleMailMessage simpleMailMessage,String mail,String[] mails,String subject,String text){
		//发送邮件
//		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		 // String[] array = new String[] {"sun111@163.com","sun222@sohu.com"};  
        // mailMessage.setTo(array);  
		if(mails!=null&&mails.length>0){
			//群发
			simpleMailMessage.setTo(mails);
		}else{
			//收件人
			simpleMailMessage.setTo(mail);
		}
		//主题
		simpleMailMessage.setSubject(subject);
		//内容
		simpleMailMessage.setText(text);
		try {
			mailSender.send(simpleMailMessage);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
//			throw new RuntimeException("发送失败！请检查网络");
		}
		return false;
	}
	

	/**
	 * 发送带有附近的的邮件
	 * @方法说明:
	 * @方法名称:sendMimeMessageHelper
	 * @param mailSender
	 * @param simpleMailMessage
	 * @param mail
	 * @param mails
	 * @param subject
	 * @param text
	 * @param list
	 * @return
	 * @作者:
	 * @返回值:boolean
	 */
	public static boolean sendMimeMessageHelper(JavaMailSenderImpl mailSender, SimpleMailMessage simpleMailMessage,
			String mail, String[] mails, String subject, String text, List<File> list) {
		// 建立邮件消息,发送简单邮件和html邮件的区别
		MimeMessage mailMessage = mailSender.createMimeMessage();
		try {
			// 注意这里的boolean,等于真的时候才能嵌套图片，在构建MimeMessageHelper时候，所给定的值是true表示启用，
			// multipart模式 为true时发送附件 可以设置html格式
			MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");
			if (mails != null && mails.length > 0) {
				// 群发
				messageHelper.setTo(mails);
			} else {
				// 收件人
				messageHelper.setTo(mail);
			}
			messageHelper.setFrom(simpleMailMessage.getFrom());
			// 主题
			messageHelper.setSubject(subject);
			// 内容 是否开启html
			messageHelper.setText(text, true);
			//传入文件
			for (File file : list) {
				FileSystemResource fileSystemResource = new FileSystemResource(file);
				messageHelper.addAttachment(file.getName(), fileSystemResource);
			}
			mailSender.send(mailMessage);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// throw new RuntimeException("发送失败！请检查网络");
		}
		return false;
	}
}
