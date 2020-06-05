package com.date.api.practice;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InstantPractice {

	@Test
	public void instantToOffsetDateTime() {
		Instant instant = Instant.now();
		OffsetDateTime offsetDateTime2 = instant.atOffset(ZoneOffset.ofHours(7));
		log.info("offsetDateTime2={}", offsetDateTime2);
	}
}
