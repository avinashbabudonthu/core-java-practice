package com.multi.threading.practice.model;

public class Model11 {

	private static ThreadLocal<String> threadLocal = new ThreadLocal<String>() {
		@Override
		protected String initialValue() {
			return "thread local initial value";
		}
	};

	public static void put(String value) {
		threadLocal.set(value);
	}

	public static String get() {
		return threadLocal.get();
	}
}
