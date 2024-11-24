package com.businesssehyogi.BusinessSehyogi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class sendEmail {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String toEmail, String subject, String body) {

        SimpleMailMessage message = new SimpleMailMessage();
        String fromMail = "businesssehyogi@gmail.com";
        message.setFrom(fromMail);
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        javaMailSender.send(message);

    }

}
