package com.xiao.Utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import javax.mail.internet.MimeMessage;

/**
 * @Description 发送邮件工具类
 * @Auther: 笑笑
 * @Date: 14:46 2018/10/11
 */
@Slf4j
@Component
public class MailUtils {

    @Autowired
    private JavaMailSender mailSender; //自动注入的Bean

    @Value("${spring.mail.username}")
    private String sender;

    public void  sendHtmlMail(String email,String link) {
        MimeMessage message = null;
        try {
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(email);
            helper.setSubject("激活邮件");
            StringBuffer sb = new StringBuffer();
            sb.append("<h1>恭喜您注册成功，请点击下方文字激活账号！</h1>").append(link);
            helper.setText(sb.toString(), true);
            log.info("发送邮件成功！");
            mailSender.send(message);
        } catch (Exception e) {
            log.error("激活邮件发送失败！");
            e.printStackTrace();
        }
    }
}
