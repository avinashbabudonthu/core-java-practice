package com.date.api.practice;

import java.time.Clock;
import java.time.LocalTime;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocalTimePractice {

	/**
	 * java.time.LocalTime practice. This class will have only time part without date
	 */
	@Test
	public void createLlocalTime() {
		LocalTime localTime1 = LocalTime.now();
		log.info("localTime1={}", localTime1);

		Clock clock1 = Clock.systemUTC();
		LocalTime localTime2 = LocalTime.now(clock1);
		log.info("localTime2={}", localTime2);

		Clock clock2 = Clock.systemDefaultZone();
		LocalTime localTime3 = LocalTime.now(clock2);
		log.info("localTime3: ", localTime3);
	}
}