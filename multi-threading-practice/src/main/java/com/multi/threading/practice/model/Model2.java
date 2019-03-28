package com.multi.threading.practice.model;

import lombok.Getter;

/**
 * Using synchronized method to avoid race condition on critical section
 */
public class Model2 {

	@Getter
	private long count = 0;

	public synchronized void increment() {
		count++;
	}
}
