package com.jeonguk.java8.datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.time.temporal.ChronoUnit;

@Slf4j
public class LocalDateTimeTest {

	public static void main(String[] args) {
		//  APIs support an easy instantiation

		LocalDate date1 = LocalDate.of(2018,2,13);

		// Uses DateTimeformatter.ISO_LOCAL_DATE for which the format is: yyyy-MM-dd
		LocalDate date2 = LocalDate.parse("2018-02-13");

		LocalTime time3 = LocalTime.of(6,30);

		// Uses DateTimeFormatter.ISO_LOCAL_TIME for which the format is: HH:mm[:ss[.SSSSSSSSS]]
		// this means that both seconds and nanoseconds may optionally be present
		LocalTime time4 = LocalTime.parse("06:30");
		LocalDateTime dateTime5 = LocalDateTime.of(2018,2,13,6,30);

		// Uses DateTimeFormatter.ISO_LOCAL_DATE_TIME for which the format is the
		// combination of the ISO date and time format, joined by 'T': yyyy-MM-dd'T'HH:mm[:ss[.SSSSSSSSS]]
		LocalDateTime dateTime6 = LocalDateTime.parse("2018-02-13T06:30");

		// easy to convert

		// LocalDate to LocalDateTime
		LocalDateTime dateTime7 = LocalDate.parse("2018-02-13").atTime(LocalTime.parse("06:30"));

		// LocalTime to LocalDateTime
		LocalDateTime dateTime8 = LocalTime.parse("06:30").atDate(LocalDate.parse("2018-02-13"));

		// LocalDateTime to LocalDate/LocalTime
		LocalDate date9 = LocalDateTime.parse("2018-02-13T06:30").toLocalDate();
		LocalTime time10 = LocalDateTime.parse("2018-02-13T06:30").toLocalTime();


		// Difference in Time: Duration and Period

		Period period1 = Period.between(LocalDate.parse("2018-01-18"), LocalDate.parse("2018-02-14"));
		log.info("{}", period1.getDays());
		// represents a period of 27 days
		Period period2 = Period.parse("P27D");

		Duration duration1 = Duration.between(LocalDateTime.parse("2018-01-18T06:30"), LocalDateTime.parse("2018-02-14T22:58"));
		log.info("{}", duration1.getSeconds());

		// represents PT664H28M
		Duration duration = Duration.between(LocalDateTime.parse("2018-01-18T06:30"), LocalDateTime.parse("2018-02-14T22:58"));
		// returns 664
		long hours1 = duration.toHours();
		log.info("{}", hours1);
		// returns 664
		long hours2 = LocalDateTime.parse("2018-01-18T06:30").until(LocalDateTime.parse("2018-02-14T22:58"), ChronoUnit.HOURS);
		log.info("{}", hours2);


		final LocalDateTime startDateTime = LocalDateTime.of(2018, 04, 23, 11, 49);
		final LocalDateTime endDateTime = LocalDateTime.of(2018, 05, 24, 11, 49);

		log.info("DATE TIME WITHIN TEST {}" , isWithin(startDateTime, endDateTime, LocalDateTime.now()));
	}

	/**
	 *
	 * @param startDateTime
	 * @param endDateTime
	 * @param nowDateTime
	 * @return
	 */
	public static boolean isWithin(LocalDateTime startDateTime, LocalDateTime endDateTime, LocalDateTime nowDateTime) {
		return nowDateTime.isAfter(startDateTime) && nowDateTime.isBefore(endDateTime);
	}
}
