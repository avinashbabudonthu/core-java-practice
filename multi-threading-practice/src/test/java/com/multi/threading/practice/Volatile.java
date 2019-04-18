package com.multi.threading.practice;

import com.multi.threading.practice.model.Model8;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class Volatile {

	private Volatile() {

	}

	private static final Volatile object = new Volatile();

	public static void main(String[] args) {
		object.volatileKeyword();
	}

	/**
	 * Volatile guarantees the all reads/writes of variable will be done from main memory instead of cpu cache
	 * But
	 * Imagine if Thread 1 reads a shared counter variable with the value 0 into its CPU cache, 
	 * increment it to 1 and not write the changed value back into main memory. 
	 * Thread 2 could then read the same counter variable from main memory where the value of the variable is still 0, 
	 * into its own CPU cache. Thread 2 could then also increment the counter to 1, 
	 * and also not write it back to main memory.
	 * Thread 1 and Thread 2 are now practically out of sync
	 * 
	 * To solve this problem we need to use synchronized @see {@link Synchronized#avoidRaceConditionUsingSynchronizedMethod()}
	 */
	@SneakyThrows
	public void volatileKeyword() {
		Model8 model = new Model8();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000000; i++) {
				model.increment();
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000000; i++) {
				model.increment();
			}
		});

		log.info("{} thread is starting t1, t2", Thread.currentThread().getName());

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		log.info("t1, t1 execution completed. count={}", model.getCount());
	}
}
