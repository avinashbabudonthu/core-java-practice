package com.multi.threading.practice.model;

import java.util.Map;

public class Model10 {

	private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

	public static void put(Map<String, Object> value) {
		threadLocal.set(value);
	}

	public static Map<String, Object> get() {
		return threadLocal.get();
	}
}
