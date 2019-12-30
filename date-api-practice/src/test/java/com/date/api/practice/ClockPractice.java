package com.date.api.practice;

import java.time.Clock;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClockPractice {

	@Test
	public void createClock() {
		Clock clock = Clock.systemUTC();
		log.info("instant={}, millis={}", clock.instant(), clock.millis());

		Clock clock2 = Clock.systemDefaultZone();
		log.info("instant={}, millis={}", clock2.instant(), clock2.millis());
	}

	/**
	 * java.time.Clock practice
	 */
	@Test
	public void clock() {
		Clock clock = Clock.systemUTC();
		System.out.println("clock.instant(): " + clock.instant());
		System.out.println("clock.millis(): " + clock.millis());
		System.out.println("clock.getZone(): " + clock.getZone());
	}
}
