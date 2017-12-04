package com.jeonguk.java8.comparison;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Human {
    private String name;
    private int age;

    public Human() {
        super();
    }

    public Human(String name, int age) {
        super();

        this.name = name;
        this.age = age;
    }
}
