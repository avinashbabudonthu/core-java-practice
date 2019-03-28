package com.multi.threading.practice.model;

import lombok.Getter;

public class Model4 {

	@Getter
	private long counter1 = 0;
	private Object lock1 = new Object();

	@Getter
	private long counter2 = 0;
	private Object lock2 = new Object();

	public void incrementCounter1() {
		synchronized (lock1) {
			counter1++;
		}
	}

	public void incrementCounter2() {
		synchronized (lock2) {
			counter2++;
		}
	}
}
