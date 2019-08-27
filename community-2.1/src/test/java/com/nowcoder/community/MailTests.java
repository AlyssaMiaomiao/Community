package com.nowcoder.community;

import com.nowcoder.community.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
//这个注解表示接下来运行的这个类的代码都是以这个类作为配置类，同时这个类也被@SpringBootApplication标识
@ContextConfiguration(classes=CommunityApplication.class)
public class MailTests {
    @Autowired
    private MailClient mailClient;
    @Autowired
    private TemplateEngine templateEngine; //这是thymeleaf模板引擎
     @Test
     public void testHtmlMail(){
         Context context=new Context();
         context.setVariable("username","sunday");//这是设置要传到模板文件中的变量
         String content=templateEngine.process("/mail/demo",context);//将对应页面的内容和content一起发送到邮件中
         System.out.println(content);
         mailClient.sendMail("ziyingxiong@163.com","HTML",content);

     }


    @Test
    public void testTestMail(){
        mailClient.sendMail("ziyingxiong@163.com","Test","welcome");
    }
}
