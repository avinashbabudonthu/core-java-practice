package com.multi.threading.practice.model;

import lombok.Getter;

public class Model7 {

	@Getter
	private long count;

	public void increment() {
		synchronized (this) {
			count++;
		}
	}
}
