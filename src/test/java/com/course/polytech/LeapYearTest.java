package com.course.polytech;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LeapYearTest {

    private LeapYear leapYear = new LeapYear();

    @Test
    public void common_year() {
        assertThat(leapYear.isLeapYear(2001)).isFalse();
    }

    @Test
    public void common_leap_year() {
        assertThat(leapYear.isLeapYear(1996)).isTrue();
    }

    @Test
    public void atypical_common_year() {
        assertThat(leapYear.isLeapYear(1900)).isFalse();
    }

    @Test
    public void atypical_leap_year() {
        assertThat(leapYear.isLeapYear(2000)).isTrue();
    }


}
