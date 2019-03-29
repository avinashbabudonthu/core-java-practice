package com.multi.threading.practice.model;

import lombok.Getter;

public class Model5 {

	@Getter
	private static long count = 0;

	public static synchronized void increment() {
		count++;
	}
}
