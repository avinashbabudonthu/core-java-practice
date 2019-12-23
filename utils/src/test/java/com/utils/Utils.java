package com.utils;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utils {

	@Test
	public void createBasicAuthHeader() throws UnsupportedEncodingException {
		final String credentials = "admin:admin123";
		String basicAuthorizationHeader = "Basic "
				+ DatatypeConverter.printBase64Binary(credentials.getBytes("UTF-8"));
		log.info("basic authorization header={}", basicAuthorizationHeader);
	}
}
