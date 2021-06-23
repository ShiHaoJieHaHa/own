package com.example.common.email;

import org.springframework.stereotype.Component;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


@Component
public class EmailSender {

    public void sendEmail(String to, String code, String username) {
        try {
            Properties props = new Properties();
            props.put("username", "@qq.com");
            props.put("password", "password");
            props.put("mail.transport.protocol", "smtp" );
            props.put("mail.smtp.host", "smtp.qq.com");
            props.put("mail.smtp.port", "465" );

            props.put("mail.smtp.auth","true");
            props.put("mail.smtp.ssl.enable","true");

            Session mailSession = Session.getDefaultInstance(props);

            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress("your@qq.com"));
            msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject("激活邮件");
            msg.setContent(username+"，您好，恭喜你成功注册本系统。点击链接即可完成激活。<h1>此邮件为蜗牛生活发送的激活邮件！请点击下面链接完成激活操作！</h1><h3><a href='http://1dm8911156.imwork.net/register/active?code="+code+"'>《---蜗牛生活---》</a></h3>","text/html;charset=UTF-8");
            msg.saveChanges();

            Transport transport = mailSession.getTransport("smtp");
            transport.connect(props.getProperty("mail.smtp.host"), props
                    .getProperty("username"), props.getProperty("password"));
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
