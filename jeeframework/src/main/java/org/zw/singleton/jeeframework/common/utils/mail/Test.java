package org.zw.singleton.jeeframework.common.utils.mail;

import java.io.FileOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
/**
 * java版
 * http://www.cnblogs.com/xdp-gacl/p/4216311.html
 * 这里使用的 smtp.sina.com 新浪的邮箱进行发送
  * @类名:Test
  * @类描述:
  * @作者:张威
  * @创建时间:2016年1月11日-下午4:54:46
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2016
 */
public class Test {
	    /**
	     * @param args
	     * @throws Exception 
	     */
	    public static void main(String[] args) throws Exception {
	        
	        Properties prop = new Properties();
	        prop.setProperty("mail.host", "smtp.sina.com");
	        prop.setProperty("mail.transport.protocol", "smtp");
	        prop.setProperty("mail.smtp.auth", "true");
//	        prop.setProperty("mail.smtp.ssl.enable", "");
	        //使用JavaMail发送邮件的5个步骤
	        //1、创建session
	        Session session = Session.getInstance(prop);
	        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
	        session.setDebug(true);
	        //2、通过session得到transport对象
	        Transport ts = session.getTransport();
	        //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
	        ts.connect("smtp.sina.com", "****", "****");
	        //4、创建邮件
	        Message message = createSimpleMail(session);
	        //5、发送邮件
	        ts.sendMessage(message, message.getAllRecipients());
	        ts.close();
	    }
	    
	    /**
	     * 
	     * @方法说明:
	     * @方法名称:createSimpleMail
	     * @param session
	     * @return
	     * @throws Exception
	     * @作者:张威
	     * @返回值:MimeMessage
	     */
	    public static MimeMessage createSimpleMail(Session session)
	            throws Exception {
	        //创建邮件对象
	        MimeMessage message = new MimeMessage(session);
	        //指明邮件的发件人
	        message.setFrom(new InternetAddress("jeeframework@sina.com"));
	        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
	        message.setRecipient(Message.RecipientType.TO, new InternetAddress("2321277858@qq.com"));
	        //邮件的标题
	        message.setSubject("只包含文本的简单邮件");
	        //邮件的文本内容
	        message.setContent("你好啊！", "text/html;charset=UTF-8");
	        //返回创建好的邮件对象
	        return message;
//	        
	    	
	    	
	    	
//	    	
//	    	
//	      //创建邮件
//	        MimeMessage message = new MimeMessage(session);
//	        // 设置邮件的基本信息
//	        //发件人
//	        message.setFrom(new InternetAddress("jeeframework@sina.com"));
//	        //收件人
//	        message.setRecipient(Message.RecipientType.TO, new InternetAddress("2321277858@qq.com"));
//	        //邮件标题
//	        message.setSubject("带图片的邮件");
//
//	        // 准备邮件数据
//	        // 准备邮件正文数据
//	        MimeBodyPart text = new MimeBodyPart();
//	        text.setContent("这是一封邮件正文带图片<img src='cid:xxx.jpg'>的邮件", "text/html;charset=UTF-8");
//	        // 准备图片数据
//	        MimeBodyPart image = new MimeBodyPart();
//	        DataHandler dh = new DataHandler(new FileDataSource("d:\\1.jpg"));
//	        image.setDataHandler(dh);
//	        image.setContentID("1.jpg");
//	        // 描述数据关系
//	        MimeMultipart mm = new MimeMultipart();
//	        mm.addBodyPart(text);
//	        mm.addBodyPart(image);
//	        mm.setSubType("related");
//
//	        message.setContent(mm);
//	        message.saveChanges();
//	        //将创建好的邮件写入到E盘以文件的形式进行保存
//	        message.writeTo(new FileOutputStream("d:\\ImageMail.eml"));
//	        //返回创建好的邮件
//	        return message;
	    	
	    	
	    	
//	        
//	        MimeMessage message = new MimeMessage(session);
//	        
//	        //设置邮件的基本信息
//	        //发件人
//	        message.setFrom(new InternetAddress("jeeframework@sina.com"));
//	        //收件人
//	        message.setRecipient(Message.RecipientType.TO, new InternetAddress("2321277858@qq.com"));
//	        //邮件标题
//	        message.setSubject("JavaMail邮件发送测试");
//	        
//	        //创建邮件正文，为了避免邮件正文中文乱码问题，需要使用charset=UTF-8指明字符编码
//	        MimeBodyPart text = new MimeBodyPart();
//	        text.setContent("使用JavaMail创建的带附件的邮件", "text/html;charset=UTF-8");
//	        
//	        //创建邮件附件
//	        MimeBodyPart attach = new MimeBodyPart();
//	        DataHandler dh = new DataHandler(new FileDataSource("d:\\1.jpg"));
//	        attach.setDataHandler(dh);
//	        attach.setFileName(dh.getName());  //
//	        
//	        //创建容器描述数据关系
//	        MimeMultipart mp = new MimeMultipart();
//	        mp.addBodyPart(text);
//	        mp.addBodyPart(attach);
//	        mp.setSubType("mixed");
//	        
//	        message.setContent(mp);
//	        message.saveChanges();
//	        //将创建的Email写入到E盘存储
//	        message.writeTo(new FileOutputStream("D:\\attachMail.eml"));
//	        //返回生成的邮件
//	        return message;
	        
//	        //创建邮件
//	        MimeMessage message = new MimeMessage(session);
//	        
//	        //设置邮件的基本信息
//	        message.setFrom(new InternetAddress("jeeframework@sina.com"));
//	        message.setRecipient(Message.RecipientType.TO, new InternetAddress("2321277858@qq.com"));
//	        message.setSubject("带附件和带图片的的邮件");
//	        
//	        //正文
//	        MimeBodyPart text = new MimeBodyPart();
//	        text.setContent("xxx这是女的xxxx<br/><img src='cid:aaa.jpg'>","text/html;charset=UTF-8");
//	        
//	        //图片
//	        MimeBodyPart image = new MimeBodyPart();
//	        image.setDataHandler(new DataHandler(new FileDataSource("D:\\1.jpg")));
//	        image.setContentID("aaa.jpg");
//	        
//	        //附件1
//	        MimeBodyPart attach = new MimeBodyPart();
//	        DataHandler dh = new DataHandler(new FileDataSource("D:\\1.zip"));
//	        attach.setDataHandler(dh);
//	        attach.setFileName(dh.getName());
//	        
////	        //附件2
////	        MimeBodyPart attach2 = new MimeBodyPart();
////	        DataHandler dh2 = new DataHandler(new FileDataSource("src\\波子.zip"));
////	        attach2.setDataHandler(dh2);
////	        attach2.setFileName(MimeUtility.encodeText(dh2.getName()));
//	        
//	        //描述关系:正文和图片
//	        MimeMultipart mp1 = new MimeMultipart();
//	        mp1.addBodyPart(text);
//	        mp1.addBodyPart(image);
//	        mp1.setSubType("related");
//	        
//	        //描述关系:正文和附件
//	        MimeMultipart mp2 = new MimeMultipart();
//	        mp2.addBodyPart(attach);
////	        mp2.addBodyPart(attach2);
//	        
//	        //代表正文的bodypart
//	        MimeBodyPart content = new MimeBodyPart();
//	        content.setContent(mp1);
//	        mp2.addBodyPart(content);
//	        mp2.setSubType("mixed");
//	        
//	        message.setContent(mp2);
//	        message.saveChanges();
//	        
//	        message.writeTo(new FileOutputStream("E:\\MixedMail.eml"));
//	        //返回创建好的的邮件
//	        return message;
	    }
	    /**
	     * 
	     * @方法说明:
	     * @方法名称:createSimpleMail
	     * @param session
	     * @return
	     * @throws Exception
	     * @作者:张威
	     * @返回值:MimeMessage
	     */
	    public static MimeMessage createSimpleMail1(Session session)
	            throws Exception {    	
	    	
	      //创建邮件
	        MimeMessage message = new MimeMessage(session);
	        // 设置邮件的基本信息
	        //发件人
	        message.setFrom(new InternetAddress("jeeframework@sina.com"));
	        //收件人
	        message.setRecipient(Message.RecipientType.TO, new InternetAddress("2321277858@qq.com"));
	        //邮件标题
	        message.setSubject("带图片的邮件");

	        // 准备邮件数据
	        // 准备邮件正文数据
	        MimeBodyPart text = new MimeBodyPart();
	        text.setContent("这是一封邮件正文带图片<img src='cid:xxx.jpg'>的邮件", "text/html;charset=UTF-8");
	        // 准备图片数据
	        MimeBodyPart image = new MimeBodyPart();
	        DataHandler dh = new DataHandler(new FileDataSource("d:\\1.jpg"));
	        image.setDataHandler(dh);
	        image.setContentID("1.jpg");
	        // 描述数据关系
	        MimeMultipart mm = new MimeMultipart();
	        mm.addBodyPart(text);
	        mm.addBodyPart(image);
	        mm.setSubType("related");

	        message.setContent(mm);
	        message.saveChanges();
	        //将创建好的邮件写入到E盘以文件的形式进行保存
	        message.writeTo(new FileOutputStream("d:\\ImageMail.eml"));
	        //返回创建好的邮件
	        return message;

	    }
	    
	    public static MimeMessage createSimpleMail2(Session session)
	            throws Exception { 
//	        MimeMessage message = new MimeMessage(session);
//	        
//	        //设置邮件的基本信息
//	        //发件人
//	        message.setFrom(new InternetAddress("jeeframework@sina.com"));
//	        //收件人
//	        message.setRecipient(Message.RecipientType.TO, new InternetAddress("2321277858@qq.com"));
//	        //邮件标题
//	        message.setSubject("JavaMail邮件发送测试");
//	        
//	        //创建邮件正文，为了避免邮件正文中文乱码问题，需要使用charset=UTF-8指明字符编码
//	        MimeBodyPart text = new MimeBodyPart();
//	        text.setContent("使用JavaMail创建的带附件的邮件", "text/html;charset=UTF-8");
//	        
//	        //创建邮件附件
//	        MimeBodyPart attach = new MimeBodyPart();
//	        DataHandler dh = new DataHandler(new FileDataSource("d:\\1.jpg"));
//	        attach.setDataHandler(dh);
//	        attach.setFileName(dh.getName());  //
//	        
//	        //创建容器描述数据关系
//	        MimeMultipart mp = new MimeMultipart();
//	        mp.addBodyPart(text);
//	        mp.addBodyPart(attach);
//	        mp.setSubType("mixed");
//	        
//	        message.setContent(mp);
//	        message.saveChanges();
//	        //将创建的Email写入到E盘存储
//	        message.writeTo(new FileOutputStream("D:\\attachMail.eml"));
//	        //返回生成的邮件
//	        return message;
	        
	        //创建邮件
	        MimeMessage message = new MimeMessage(session);
	        
	        //设置邮件的基本信息
	        message.setFrom(new InternetAddress("jeeframework@sina.com"));
	        message.setRecipient(Message.RecipientType.TO, new InternetAddress("2321277858@qq.com"));
	        message.setSubject("带附件和带图片的的邮件");
	        
	        //正文
	        MimeBodyPart text = new MimeBodyPart();
	        text.setContent("xxx这是女的xxxx<br/><img src='cid:aaa.jpg'>","text/html;charset=UTF-8");
	        
	        //图片
	        MimeBodyPart image = new MimeBodyPart();
	        image.setDataHandler(new DataHandler(new FileDataSource("D:\\1.jpg")));
	        image.setContentID("aaa.jpg");
	        
	        //附件1
	        MimeBodyPart attach = new MimeBodyPart();
	        DataHandler dh = new DataHandler(new FileDataSource("D:\\1.zip"));
	        attach.setDataHandler(dh);
	        attach.setFileName(dh.getName());
	        
//	        //附件2
//	        MimeBodyPart attach2 = new MimeBodyPart();
//	        DataHandler dh2 = new DataHandler(new FileDataSource("src\\波子.zip"));
//	        attach2.setDataHandler(dh2);
//	        attach2.setFileName(MimeUtility.encodeText(dh2.getName()));
	        
	        //描述关系:正文和图片
	        MimeMultipart mp1 = new MimeMultipart();
	        mp1.addBodyPart(text);
	        mp1.addBodyPart(image);
	        mp1.setSubType("related");
	        
	        //描述关系:正文和附件
	        MimeMultipart mp2 = new MimeMultipart();
	        mp2.addBodyPart(attach);
//	        mp2.addBodyPart(attach2);
	        
	        //代表正文的bodypart
	        MimeBodyPart content = new MimeBodyPart();
	        content.setContent(mp1);
	        mp2.addBodyPart(content);
	        mp2.setSubType("mixed");
	        
	        message.setContent(mp2);
	        message.saveChanges();
	        
	        message.writeTo(new FileOutputStream("E:\\MixedMail.eml"));
	        //返回创建好的的邮件
	        return message;
	    }
}
