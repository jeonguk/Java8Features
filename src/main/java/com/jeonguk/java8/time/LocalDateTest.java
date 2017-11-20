package com.jeonguk.java8.time;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

public class LocalDateTest {

    public static void main(String[] args) {

        // Current Date
        LocalDate today = LocalDate.now();
        System.out.println("Current Date = " + today);

        // Creating LocalDate by providing input arguments
        LocalDate firstDay_2017 = LocalDate.of(2017, Month.JANUARY, 1);
        System.out.println("Sepcific Date = " + firstDay_2017);

        // Current date in "Asia/Seoul", you can get it from ZoneId javadoc
        LocalDate todaySeoul = LocalDate.now(ZoneId.of("Asia/Seoul"));
        System.out.println("Current Date in IST = " + todaySeoul);

        // Getting date from the base date i.e 01/01/1970
        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println("365th day from base date = " + dateFromBase);

        LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
        System.out.println("100th day of 2014 = " + hundredDay2014);
    }

}
