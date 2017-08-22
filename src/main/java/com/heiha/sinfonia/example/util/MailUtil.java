package com.heiha.sinfonia.example.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

/**
 * <br>
 * <b>Project:</b> example<br>
 * <b>Date:</b> 2017/8/22 10:18<br>
 * <b>Author:</b> heiha<br>
 */
@Component
public class MailUtil {
    private static MailSender mailSender;

    @Autowired
    public MailUtil(MailSender mailSender) {
        MailUtil.mailSender = mailSender;
    }

    public static void send(String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("heiha_test@163.com");
        message.setTo("heiha_test@163.com");
        message.setSubject("This is one test email");
        message.setText(text);
        mailSender.send(message);
    }
}
