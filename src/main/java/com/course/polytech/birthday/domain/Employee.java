package com.course.polytech.birthday.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;

@Data
public class Employee {
    private final String firstName;
    private final String lastName;
    private final LocalDate birthday;
    private final String email;

    public boolean isBirthday(LocalDate today) {
        return today.getMonth() == birthday.getMonth() && today.getDayOfMonth() == birthday.getDayOfMonth();
    }

}
