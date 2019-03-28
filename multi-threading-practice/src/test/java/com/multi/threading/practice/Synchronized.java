package com.multi.threading.practice;

import com.multi.threading.practice.model.Model1;
import com.multi.threading.practice.model.Model2;
import com.multi.threading.practice.model.Model3;
import com.multi.threading.practice.model.Model4;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class Synchronized {

	private Synchronized() {
	}

	private static final Synchronized synchronizedObject = new Synchronized();

	public static void main(String[] args) {
		// synchronizedObject.criticalSectionExample();
		//synchronizedObject.avoidRaceConditionUsingSynchronizedMethod();
		//synchronizedObject.problemWithSynchronizedMethods();
		synchronizedObject.solutionToSynchronizedMethodsProblem();
	}

	/**
	 * If output of code varies depending on the order of threads executing that code 
	 * then that code is called critical section
	 * 
	 * After the execution of t1, t1
	 * Expected count value = 2000000
	 * Actual value can/cannot be the expected value
	 * 
	 */
	@SneakyThrows
	public void criticalSectionExample() {
		final Model1 model = new Model1();

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

		log.info("{} thread is starting threads -> t1, t2", Thread.currentThread().getName());

		t1.start();
		t2.start();

		t1.join();
		t1.join();

		log.info("threads execution completed. count={}", model.getCount());
	}

	@SneakyThrows
	public void avoidRaceConditionUsingSynchronizedMethod() {
		final Model2 model = new Model2();

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

		log.info("{} thread is starting threads -> t1, t2", Thread.currentThread().getName());

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		log.info("threads execution completed. count={}", model.getCount());
	}

	/**
	 * if model has 2 different variables. 2 different methods incrementing these values.
	 * declaring both methods as synchronized will cause contention(means preventing threads executing parallel)
	 * while t1 is increments t2 cannot increment because t1 already got a lock and t2 has to wait for the lock
	 * 
	 * Solution is have 2 locks, one for each variable
	 * use synchronized blocks in the method with respective lock
	 * @see #solutionToSynchronizedMethodsProblem()
	 */
	@SneakyThrows
	public void problemWithSynchronizedMethods() {
		Model3 model = new Model3();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000000; i++) {
				model.incrementCounter1();
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000000; i++) {
				model.incrementCounter2();
			}
		});

		log.info("{} thread is starting threads -> t1, t2", Thread.currentThread().getName());

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		log.info("threads execution completed. counter1={}, counter2={}", model.getCounter1(), model.getCounter2());
	}

	@SneakyThrows
	public void solutionToSynchronizedMethodsProblem() {
		Model4 model = new Model4();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000000; i++) {
				model.incrementCounter1();
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000000; i++) {
				model.incrementCounter2();
			}
		});

		log.info("{} thread is starting threads -> t1, t2", Thread.currentThread().getName());

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		log.info("threads execution completed. counter1={}, counter2={}", model.getCounter1(), model.getCounter2());
	}
}
