package com.multi.threading.practice.model;

import lombok.Getter;

public class Model8 {

	@Getter
	private volatile long count = 0;

	public void increment() {
		count++;
	}
}
