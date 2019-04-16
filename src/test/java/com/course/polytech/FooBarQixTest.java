package com.course.polytech;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FooBarQixTest {

    @Test
    public void should_return_number() {
        assertThat(FooBarQix.INSTANCE.convert(1)).isEqualTo("1");
    }

    @Test
    public void if_divisible_by_3_should_return_foo() {
        assertThat(FooBarQix.INSTANCE.convert(9)).isEqualTo("Foo");
    }

    @Test
    public void if_divisible_by_5_should_return_bar() {
        assertThat(FooBarQix.INSTANCE.convert(10)).isEqualTo("Bar");
    }

    @Test
    public void if_divisible_by_7_should_return_bar() {
        assertThat(FooBarQix.INSTANCE.convert(14)).isEqualTo("Qix");
    }

    @Test
    public void should_return_FooBarQix() {
        assertThat(FooBarQix.INSTANCE.convert(75)).isEqualTo("FooBarBarQix");
    }

    @Test
    public void should_return_BarQix() {
        assertThat(FooBarQix.INSTANCE.convert(35)).isEqualTo("FooBarBarQix");
    }

    @Test
    public void should_return_FooFooFoo() {
        assertThat(FooBarQix.INSTANCE.convert(33)).isEqualTo("FooFooFoo");
    }

    @Test
    public void should_return_QixQixQix() {
        assertThat(FooBarQix.INSTANCE.convert(77)).isEqualTo("QixQixQix");
    }


}
