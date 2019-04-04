package com.string.practice;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringFormatPractice {

	@Test
	public void stringFormat() {
		String str1 = String.format("Welcome to number %d, %d, %d and %d", 1, 2, 3, 4);
		log.info("str1={}", str1);

		String str2 = String.format("Decimal value with 2 decimals: %.2f", 1.2356);
		log.info("str2={}", str2);

		String str3 = String.format("%d, %o, %x, %X", 32, 32, 32, 32);
		log.info("str3={}", str3);

		String str4 = String.format("%d, %#o, %#x, %#X", 32, 32, 32, 32);
		log.info("str4={}", str4);

		log.info("-- right justify -- ");
		String str5 = String.format("num1:%4d, num2:%4d ", 6, 287);
		String str6 = String.format("num1:%4d, num2:%4d ", 657, 7);
		String str7 = String.format("num1:%04d, num2:%04d ", 877, 6);
		log.info("str5={}", str5);
		log.info("str6={}", str6);
		log.info("str7={}", str7);

		log.info("-- left justify -- ");
		String str8 = String.format("num1:%-4d, num2:%-4d ", 6, 287);
		String str9 = String.format("num1:%-4d, num2:%-4d ", 657, 7);
		log.info("str8={}", str8);
		log.info("str9={}", str9);

		log.info("-- group separator");
		String str10 = String.format("%d", 1234567);
		String str11 = String.format("%,d", 1234567);
		String str12 = String.format("%,.2f", 123457.6);
		log.info("str10={}", str10);
		log.info("str11={}", str11);
		log.info("str12={}", str12);

		String s13 = String.format("%d", 123);
		String s14 = String.format("%d", -123);
		String s15 = String.format("% d", 123);
		String s16 = String.format("% d", -123);
		String s17 = String.format("%+d", 123);
		String s18 = String.format("%+d", -123);
		String s19 = String.format("%(d", 123);
		String s20 = String.format("%(d", -123);
		String s21 = String.format("% (d", 123);
		log.info("s13={}", s13);
		log.info("s14={}", s14);
		log.info("s15={}", s15);
		log.info("s16={}", s16);
		log.info("s17={}", s17);
		log.info("s18={}", s18);
		log.info("s19={}", s19);
		log.info("s20={}", s20);
		log.info("s21={}", s21);
	}
}
