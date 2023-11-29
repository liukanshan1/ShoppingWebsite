package top.liukanshan.shoppingwebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailService {
    @Autowired
    JavaMailSender javaMailSender;

    public void sendMail(String to,String subject,String text){
        SimpleMailMessage smm = new SimpleMailMessage();
        smm.setFrom("cuiyuxin2002@outlook.com");//发送者
        smm.setTo(to);//收件人
        smm.setSubject(subject);//邮件主题
        smm.setText(text);//邮件内容
        javaMailSender.send(smm);//发送邮件
    }
}