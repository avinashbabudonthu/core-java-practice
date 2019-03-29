package com.multi.threading.practice.model;

import lombok.Getter;

public class Model6 {

	@Getter
	private static long count;

	public static void increment() {
		synchronized (Model6.class) {
			count++;
		}
	}
}
