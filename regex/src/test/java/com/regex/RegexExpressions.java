package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegexExpressions {

	@Test
	public void maximum9Digits() {
		final String regex = "[0-9]{9}";
		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher("123456789");
		Boolean result1 = matcher.matches();
		log.info("123456789 matched={}", result1);

		Matcher matcher2 = pattern.matcher("1234567890");
		Boolean result2 = matcher2.matches();
		log.info("1234567890 matched={}", result2);

		final String regex2 = "\\d{9}";
		final Pattern pattern2 = Pattern.compile(regex2);

		Matcher matcher3 = pattern2.matcher("123456789");
		Boolean result3 = matcher3.matches();
		log.info("123456789 matched={}", result3);

		Matcher matcher4 = pattern2.matcher("1234567890");
		Boolean result4 = matcher4.matches();
		log.info("1234567890 matched={}", result4);

		final String regex3 = "^\\d{9}$";
		final Pattern pattern3 = Pattern.compile(regex3);

		Matcher matcher5 = pattern3.matcher("123456789");
		Boolean result5 = matcher5.matches();
		log.info("123456789 matched={}", result5);

		Matcher matcher6 = pattern3.matcher("1234567890");
		Boolean result6 = matcher6.matches();
		log.info("1234567890 matched={}", result6);
	}
}
