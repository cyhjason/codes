package com.cyh.sy.common.info;  
  
import java.util.Date;  
import java.util.Properties;  
  
import javax.mail.Authenticator;  
import javax.mail.Message;
import javax.mail.Message.RecipientType;  
import javax.mail.PasswordAuthentication;  
import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  

import com.cyh.sy.entity.Company;

/**
 * 
 * @描述：邮件发送工具类
 * @作者：cyh
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午10:47:36
 *
 */
public class EmailUtils {  
      
    private static final String FROM = "test@163.com";  
    
    private static final String PASS_WORD = "test123";  
  
    /** 
     * 注册成功后,向用户发送帐户激活链接的邮件 
     * @param user 未激活的用户 
     */  
    public static void sendAccountActivateEmail(Company company) {  
        Session session = getSession();  
        Message message = new MimeMessage(session);  
        try {  
        	message.setFrom(new InternetAddress(FROM)); 
        	message.setSentDate(new Date());  
            message.setSubject("SSM-Demo系统-帐户激活邮件");  
            message.setRecipient(RecipientType.TO, new InternetAddress(company.getCompanyContactsEmail()));  
            message.setContent("<h1>此邮件为：SSM-Demo系统官方激活邮件！请点击下面链接完成激活操作！</h1>" +
            				   "<h3><a href='" + GenerateLinkUtils.generateActivateLink(company)+"'>点击激活帐户</a></h3>","text/html;charset=UTF-8");
            message.saveChanges();  
            // 发送邮件  
            Transport.send(message);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
      
    /** 
     * 发送重设密码链接的邮件 
     */  
    public static void sendResetPasswordEmail(Company company) {  
        Session session = getSession();  
        MimeMessage message = new MimeMessage(session);  
        try {  
            message.setSubject("SSM-Demo系统-找回您的帐户与密码");  
            message.setSentDate(new Date());  
            message.setFrom(new InternetAddress(FROM));  
            message.setRecipient(RecipientType.TO, new InternetAddress(company.getCompanyContactsEmail()));  
            message.setContent("<h1>此邮件为：SSM-Demo系统官方账户与密码找回邮件！请点击下面链接重新设置密码！</h1>" +
 				   "<h3><a href='" + GenerateLinkUtils.generateResetPwdLink(company)+"'>点击重新设置密码</a></h3>","text/html;charset=UTF-8");
            message.saveChanges();  
            // 发送邮件  
            Transport.send(message);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
      
    
    public static Session getSession() {  
        Properties props = new Properties();  
        props.setProperty("mail.transport.protocol", "smtp");  
        props.setProperty("mail.smtp.host", "smtp.163.com");  
        props.setProperty("mail.smtp.port", "25");  
        props.setProperty("mail.smtp.auth", "true");  
        Session session = Session.getInstance(props, new Authenticator() {  
            @Override  
            protected PasswordAuthentication getPasswordAuthentication() {  
                return new PasswordAuthentication(FROM, PASS_WORD);  
            }  
        });  
        
        return session;  
    }  
    
}  