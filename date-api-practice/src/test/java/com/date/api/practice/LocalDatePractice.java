package com.date.api.practice;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocalDatePractice {

	@Test
	public void createLocalDateWithCurrentDate() {
		LocalDate localDate = LocalDate.now();
		log.info("local-date={}", localDate);
	}

	/**
	 * java.time.LocalDate practice. This class will have only date part without time part
	 */
	@Test
	public void createLocalDate() {
		LocalDate localDate1 = LocalDate.now();
		System.out.println("localDate: " + localDate1);

		Clock clock1 = Clock.systemUTC();
		LocalDate localDate2 = LocalDate.now(clock1);
		log.info("localDate2={}", localDate2);
	}

	/**
	 * Add 1 day, 1 week, 1 month to date
	 */
	@Test
	public void addDayWeekMonth() {
		LocalDate localDate = LocalDate.now();
		System.out.println("localDate: " + localDate);

		// add 1 day
		LocalDate tomorrow = localDate.plus(1, ChronoUnit.DAYS);
		System.out.println("tomorrow: " + tomorrow);

		// add 1 week
		LocalDate nextWeek = localDate.plus(1, ChronoUnit.WEEKS);
		System.out.println("nextWeek: " + nextWeek);

		// add 1 month
		LocalDate nextMonth = localDate.plus(1, ChronoUnit.MONTHS);
		System.out.println("nextMonth: " + nextMonth);

		// add 1 year
		LocalDate nextYear = localDate.plus(1, ChronoUnit.YEARS);
		System.out.println("nextYear: " + nextYear);

		// add 10 years
		LocalDate nextDecade = localDate.plus(1, ChronoUnit.DECADES);
		System.out.println("nextDecade: " + nextDecade);
	}

	/**
	 * Get next Sunday
	 */
	@Test
	public void nextSunday() {
		LocalDate today = LocalDate.now();
		LocalDate nextSunday = today.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println("next sunday: " + nextSunday);
	}
}