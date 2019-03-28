package com.multi.threading.practice.model;

import lombok.Getter;

public class Model3 {

	@Getter
	private long counter1 = 0;

	@Getter
	private long counter2 = 0;

	public synchronized void incrementCounter1() {
		counter1++;
	}

	public synchronized void incrementCounter2() {
		counter2++;
	}
}
