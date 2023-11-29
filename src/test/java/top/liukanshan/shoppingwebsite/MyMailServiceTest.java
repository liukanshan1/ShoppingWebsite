package top.liukanshan.shoppingwebsite;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.liukanshan.shoppingwebsite.service.MailService;

@SpringBootTest
public class MyMailServiceTest {
    @Autowired
    MailService mailService;
    @Test
    public void sendMailTest(){
        mailService.sendMail(
        "1269595029@qq.com",
        "SpringBoot发送邮件",
        "邮件发送成功啦!");
    }
}
