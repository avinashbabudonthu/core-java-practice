package com.date.api.practice;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Test;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UtilDate {

	@SneakyThrows
	@Test
	public void convertStringToDate() {
		String dateString = "2019-04-30 16:52:23";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = simpleDateFormat.parse(dateString);
		log.info("date={}", date);
	}

	@Test
	public void convertDateToString() {
		Date date = new Date();
		SimpleDateFormat targetSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String targetDateString = targetSimpleDateFormat.format(date);
		log.info(targetDateString);
	}

	@Test
	public void convertDateToLocalDateTime() {
		Date date = new Date();
		LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		log.info("localDateTime={}", localDateTime);

	}
}
