package com.multi.threading.practice.model;

public class Model9 {

	private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

	public static void put(String value) {
		threadLocal.set(value);
	}

	public static String get() {
		return threadLocal.get();
	}
}
