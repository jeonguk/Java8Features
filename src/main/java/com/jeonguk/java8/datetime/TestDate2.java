package com.jeonguk.java8.datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class TestDate2 {
	public static void main(String[] args) {
		//Get current date time
		LocalDateTime now = LocalDateTime.now();
		log.info("Before : {}", now);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatDateTime = now.format(formatter);
		log.info("After : {}", formatDateTime);
	}
}
