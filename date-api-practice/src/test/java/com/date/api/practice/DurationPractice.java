package com.date.api.practice;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DurationPractice {

	@Test
	public void durationBetweenTwoDates() {
		LocalDateTime from = LocalDateTime.of(2018, Month.JULY, 20, 0, 0, 0);
		LocalDateTime to = LocalDateTime.of(2019, Month.JULY, 20, 23, 59, 59);

		final Duration duration = Duration.between(from, to);

		log.info("days={}, months={}, years={}, hours={}, minutes={}, milli-seconds={}, nano-seconds={}",
				duration.toDays(), (duration.toDays() / 30), ((duration.toDays() / 30) / 12), duration.toHours(),
				duration.toMinutes(), duration.toMillis(), duration.toNanos());

	}
}
