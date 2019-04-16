package com.course.polytech.birthday.domain;

import java.time.LocalDate;

public class BirthdayService {
    private final TodayService todayService;
    private final EmployeeRepository employeeRepository;
    private final MailSender mailSender;

    public BirthdayService(TodayService todayService, EmployeeRepository employeeRepository, MailSender mailSender) {
        this.todayService = todayService;
        this.employeeRepository = employeeRepository;
        this.mailSender = mailSender;
    }

    public void sendGreetingsIfAny() {
        LocalDate today = todayService.today();
        for (Employee employee : employeeRepository.allEmployees()) {
            sendEmailIfBirthday(today, employee);
        }
    }

    private void sendEmailIfBirthday(LocalDate today, Employee employee) {
        if (employee.isBirthday(today)) {
            mailSender.sendEmail(
                    employee.getEmail(),
                    "Happy birthday!",
                    "Happy birthday, dear "+employee.getFirstName()+"!"
            );
        }
    }
}
