package com.course.polytech.birthday.infra;

import com.course.polytech.birthday.domain.TodayService;

import java.time.LocalDate;

public class SystemTodayService implements TodayService {
    @Override
    public LocalDate today() {
        return LocalDate.now();
    }
}
