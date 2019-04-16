package com.course.polytech.birthday.domain;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Arrays;

public class BirthdayServiceTest {

    private TodayService todayService = Mockito.mock(TodayService.class);
    private EmployeeRepository employeeRepository = Mockito.mock(EmployeeRepository.class);
    private MailSender mailSender = Mockito.mock(MailSender.class);
    private BirthdayService birthdayService = new BirthdayService(todayService, employeeRepository, mailSender);


    @Test
    void should_send_email_for_birthday() {
        Mockito.when(todayService.today()).thenReturn(LocalDate.of(2019, 11, 23));
        Mockito.when(employeeRepository.allEmployees()).thenReturn(Arrays.asList(
                new Employee("John", "Doe", LocalDate.of(1988, 11, 23), "john.doe@gmail.com"),
                new Employee("Mary", "Anne", LocalDate.of(1997, 6, 18), "john.doe@gmail.com")
        ));
        birthdayService.sendGreetingsIfAny();
        Mockito.verify(mailSender, Mockito.times(1)).sendEmail(
                "john.doe@gmail.com",
                "Happy birthday!",
                "Happy birthday, dear John!");
        Mockito.verifyNoMoreInteractions(mailSender);
    }
}
