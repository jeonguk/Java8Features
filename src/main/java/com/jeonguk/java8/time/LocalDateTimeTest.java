package com.jeonguk.java8.time;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTest {

    public static void main(String[] args) {

        // Current Date
        LocalDateTime today = LocalDateTime.now();
        System.out.println("Current DateTime = " + today);

        // Current Date using LocaDate and LocalTime
        today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("Current DateTime = " + today);

        // Creating LocaDateTime by providing input arguments
        LocalDateTime specificDate = LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30);
        System.out.println("Specific Date = " + specificDate);

        //Try creating date by providing invalid inputs
        //LocalDateTime feb29_2014 = LocalDateTime.of(2014, Month.FEBRUARY, 28, 25,1,1);
        //Exception in thread "main" java.time.DateTimeException:
        //Invalid value for HourOfDay (valid values 0 - 23): 25

        // Current date in "Asia/Seoul", you can get it from ZoneId javadoc
        LocalDateTime todaySeoul = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println("Current Date in IST = " + todaySeoul);

        //java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
        //LocalDateTime todayIST = LocalDateTime.now(ZoneId.of("IST"));

        // Getting data from the base date i.e 01/01/1970
        LocalDateTime dateFromBase = LocalDateTime.ofEpochSecond(10000, 0, ZoneOffset.UTC);
        System.out.println("10000th second time from 01/01/1970 = " + dateFromBase);

        // How to format dates with LocalDateTime
        String date1 = "2017-03-08T12:30:54";
        LocalDateTime localdatetime = LocalDateTime.parse(date1);
        System.out.println("origional date as string: " + date1);
        System.out.println("generated LocalDateTime: " + localdatetime);

        String date2 = "2017-03-08 12:30:54";
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date2, format);
        System.out.println("origional date as string: " + date2);
        System.out.println("generated LocalDateTime: " + dateTime);

    }

}
