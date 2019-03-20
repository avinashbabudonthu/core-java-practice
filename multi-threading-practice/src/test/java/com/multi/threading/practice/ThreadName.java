package com.multi.threading.practice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadName {

	public static void main(String[] args) {
		ThreadName threadName = new ThreadName();
		//threadName.withThread();
		threadName.withThread2();
		//threadName.withRunnable();
	}

	public void withThread() {
		Thread thread = new Thread3("app-thread-1");
		thread.start();
	}

	public void withThread2() {
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread3(String.format("app-thread-%d", i));
			thread.start();
		}
	}

	public void withRunnable() {
		Runnable runnable = () -> {
			log.info("name={}", Thread.currentThread().getName());
		};
		Thread thread = new Thread(runnable, "app-thread-2");
		thread.start();
		log.info("name={}", thread.getName());
	}
}
