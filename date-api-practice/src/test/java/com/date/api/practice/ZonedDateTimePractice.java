package com.date.api.practice;

import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ZonedDateTimePractice {

	/**
	 * java.time.ZonedDateTime practice
	 */
	@Test
	public void createZonedDateTime() {
		ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
		log.info("zonedDateTime1={}", zonedDateTime1);

		Clock clock1 = Clock.systemUTC();
		ZonedDateTime zonedDateTime2 = ZonedDateTime.now(clock1);
		log.info("zonedDateTime2: ", zonedDateTime2);

		ZonedDateTime zonedDateTime3 = ZonedDateTime.now(ZoneId.of("Asia/Calcutta"));
		log.info("zonedDateTime3={}", zonedDateTime3);
	}
}
