package com.course.polytech.birthday.infra;

import com.course.polytech.birthday.domain.MailSender;

public class ConsoleMailSender implements MailSender {
    @Override
    public void sendEmail(String email, String subject, String body) {
        System.out.println("Sending following email to " + email);
        System.out.println("Subject : "  + subject);
        System.out.println("Body : "  + body);
    }
}
