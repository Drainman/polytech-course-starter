package com.course.polytech.birthday.domain;

public interface MailSender {
    void sendEmail(String email, String subject, String body);
}
