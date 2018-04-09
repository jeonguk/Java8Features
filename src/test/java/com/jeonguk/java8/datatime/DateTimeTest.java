package com.jeonguk.java8.datatime;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class DateTimeTest {
	@Test
	public void dateTimeTest() {
		LocalDate localDate = LocalDate.of(2018, Month.APRIL, 9);
		LocalDate firstDayOfApril = localDate.with(TemporalAdjusters.firstDayOfMonth());
		Assert.assertEquals("2018-04-01", firstDayOfApril.toString());
	}
}
