package com.nowcoder.community.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailClient {
    private static final Logger logger= LoggerFactory.getLogger(MailClient.class);
    @Autowired
    private JavaMailSender mailSender; //主要是使用这个类来发送邮件
    @Value("${spring.mail.username}") //读取配置信息中的邮箱账号
    private String from;//表示从这个邮箱发送出去的
    public void sendMail(String to ,String subject,String content) {
        try {
            MimeMessage message=mailSender.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper(message);
            helper.setFrom(from); //设置谁发送邮件
            helper.setTo(to);//邮件的接收方
            helper.setSubject(subject);//邮件的主题
            helper.setText(content,true);//邮件的内容，加上true表示支持发送HTML文件
            mailSender.send(helper.getMimeMessage());//表示将这封邮件发送出去
        } catch (MessagingException e) {
            logger.error("发送邮件失败："+e.getMessage());
        }
    }

}
