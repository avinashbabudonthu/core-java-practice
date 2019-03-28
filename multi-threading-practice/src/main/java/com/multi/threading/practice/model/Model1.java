package com.multi.threading.practice.model;

import lombok.Getter;

/**
 * Model to repicate critical section
 * @see Synchronized#criticalSectionExample()
 *
 */
public class Model1 {

	@Getter
	private long count = 0;

	public void increment() {
		count++;
	}

}
