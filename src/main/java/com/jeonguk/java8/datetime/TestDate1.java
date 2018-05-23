package com.jeonguk.java8.datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class TestDate1 {
	public static void main(String[] args) {
		String now = "2018-05-23 14:12";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime formatDateTime = LocalDateTime.parse(now, formatter);

		log.info("Before : {}", now);
		log.info("After : {}", formatDateTime);
		log.info("After : {}", formatDateTime.format(formatter));
	}
}
