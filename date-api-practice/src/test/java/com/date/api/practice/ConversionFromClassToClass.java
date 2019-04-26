package com.date.api.practice;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Test;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConversionFromClassToClass {

	@Test
	public void localDateToGregorianCalendar() {
		LocalDate localDate = LocalDate.now();
		GregorianCalendar gregorianCalendar = GregorianCalendar
				.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		log.info("date={}", gregorianCalendar.toString());
	}

	@SneakyThrows
	@Test
	public void localDateToXmlGregorianCalendar() {
		LocalDate localDate = LocalDate.now();
		GregorianCalendar gregorianCalendar = GregorianCalendar
				.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance()
				.newXMLGregorianCalendar(gregorianCalendar);
		log.info("date={}", xmlGregorianCalendar.toString());
	}
}
