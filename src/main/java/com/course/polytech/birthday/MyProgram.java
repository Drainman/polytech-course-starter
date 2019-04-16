package com.course.polytech.birthday;

import com.course.polytech.birthday.domain.BirthdayService;
import com.course.polytech.birthday.infra.ConsoleMailSender;
import com.course.polytech.birthday.infra.CsvFileEmployeeRepository;
import com.course.polytech.birthday.infra.SystemTodayService;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyProgram {

    public static void main(String[] args) throws URISyntaxException {
        URL url = MyProgram.class.getResource("employee.csv");
        Path path = Paths.get(url.toURI());
        BirthdayService  birthdayService = new BirthdayService(
                new SystemTodayService(),
                new CsvFileEmployeeRepository(path),
                new ConsoleMailSender());
        birthdayService.sendGreetingsIfAny();

    }
}
