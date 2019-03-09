package com.string.practice;

import java.lang.invoke.MethodHandles;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringFormatPractice {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Test
	public void stringFormat() {
		String str1 = String.format("Welcome to number %d, %d, %d and %d", 1, 2, 3, 4);
		LOGGER.info("str1={}", str1);

		String str2 = String.format("Decimal value with 2 decimals: %.2f", 1.2356);
		LOGGER.info("str2={}", str2);

		String str3 = String.format("%d, %o, %x, %X", 32, 32, 32, 32);
		LOGGER.info("str3={}", str3);

		String str4 = String.format("%d, %#o, %#x, %#X", 32, 32, 32, 32);
		LOGGER.info("str4={}", str4);

		LOGGER.info("-- right justify -- ");
		String str5 = String.format("num1:%4d, num2:%4d ", 6, 287);
		String str6 = String.format("num1:%4d, num2:%4d ", 657, 7);
		String str7 = String.format("num1:%04d, num2:%04d ", 877, 6);
		LOGGER.info("str5={}", str5);
		LOGGER.info("str6={}", str6);
		LOGGER.info("str7={}", str7);

		LOGGER.info("-- left justify -- ");
		String str8 = String.format("num1:%-4d, num2:%-4d ", 6, 287);
		String str9 = String.format("num1:%-4d, num2:%-4d ", 657, 7);
		LOGGER.info("str8={}", str8);
		LOGGER.info("str9={}", str9);

		LOGGER.info("-- group separator");
		String str10 = String.format("%d", 1234567);
		String str11 = String.format("%,d", 1234567);
		String str12 = String.format("%,.2f", 123457.6);
		LOGGER.info("str10={}", str10);
		LOGGER.info("str11={}", str11);
		LOGGER.info("str12={}", str12);

		String s13 = String.format("%d", 123);
		String s14 = String.format("%d", -123);
		String s15 = String.format("% d", 123);
		String s16 = String.format("% d", -123);
		String s17 = String.format("%+d", 123);
		String s18 = String.format("%+d", -123);
		String s19 = String.format("%(d", 123);
		String s20 = String.format("%(d", -123);
		String s21 = String.format("% (d", 123);
		LOGGER.info("s13={}", s13);
		LOGGER.info("s14={}", s14);
		LOGGER.info("s15={}", s15);
		LOGGER.info("s16={}", s16);
		LOGGER.info("s17={}", s17);
		LOGGER.info("s18={}", s18);
		LOGGER.info("s19={}", s19);
		LOGGER.info("s20={}", s20);
		LOGGER.info("s21={}", s21);
	}
}
