package com.date.api.practice;

import java.time.Clock;
import java.time.LocalDateTime;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocalDateTimePractice {

	/**
	 * java.time.LocalDateTime practice. This class useful to work on date or time or both
	 */
	@Test
	public void createLocalDateTime() {
		LocalDateTime localDateTime1 = LocalDateTime.now();
		System.out.println("localDateTime1: " + localDateTime1);

		Clock clock1 = Clock.systemUTC();
		LocalDateTime localDateTime2 = LocalDateTime.now(clock1);
		System.out.println("localDateTime2: " + localDateTime2);

		Clock clock2 = Clock.systemDefaultZone();
		LocalDateTime localDateTime3 = LocalDateTime.now(clock2);
		System.out.println("localDateTime3: " + localDateTime3);
	}

}