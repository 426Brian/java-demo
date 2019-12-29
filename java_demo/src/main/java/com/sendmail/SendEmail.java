package com.sendmail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Brian in 0:46 2018/5/7
 */
public class SendEmail {
    public static void main(String[] args) throws IOException {

        // 收件人电子邮箱
        String to = "1165380405@qq.com";

        // 发件人电子邮箱
        String from = "1165380405@qq.com";

        // 指定发送邮件的主机为 localhost
        String host = "smtp.qq.com";

        // 获取系统属性
        Properties props = System.getProperties();

        // 设置邮件服务器
        props.setProperty("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.user", from);
        props.put("mail.password", "cghpgzcvlweggaff");


        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                String user = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(user, password);
            }
        };

        // 获取默认session对象
        Session session = Session.getDefaultInstance(props, authenticator);

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("This is the Subject Line!");

            // 设置消息体
            message.setText("This is actual message");

            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }
}
