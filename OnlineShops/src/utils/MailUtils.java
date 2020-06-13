package utils;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtils {
    public static void sendMail(String email,String emailMsg) throws AddressException,MessagingException{
    	// 1.创建一个程序与邮件服务器会话对象 Session
    	Properties props = new Properties();
    	
    	props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    	props.setProperty("mail.smtp.socketFactory.port", "465"); // 端口
    	// 设置SMTP服务器是否需要用户验证，需要验证设置为true
    	props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.debug", "true");
        // 设置邮件传输协议为SMTP
    	props.setProperty("mail.transport.protiocol", "SMTP");
    	// 设置SMTP服务器地址
    	props.setProperty("mail.host", "smtp.qq.com");
    	
    	props.setProperty("mail.smtp.ssl.enable","true");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        // 创建验证器
    	Authenticator auth = new Authenticator() {
    		public PasswordAuthentication getPasswordAuthentication() {
    			return new PasswordAuthentication("1539210969@qq.com","oazepchjmacljfda"); // 授权码
    		}
    	};
    	Session session = Session.getInstance(props, auth);
    	// 2.创建一个Message，它相当于是邮件内容
    	Message message = new MimeMessage(session);
    	// 设置发送者
    	message.setFrom(new InternetAddress("1539210969@qq.com"));
    	// 设置发送方式与接收者
    	message.setRecipient(RecipientType.TO, new InternetAddress(email));
    	message.setSubject("网上商城（科技点亮未来）：支付详情信息");
    	message.setContent(emailMsg, "text/html;charset=utf-8");
    	// 3.创建 Transport用于将邮件发送
    	Transport.send(message);
    }
}
