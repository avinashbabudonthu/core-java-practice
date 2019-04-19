package com.multi.threading.practice;

import com.multi.threading.practice.thread.Thread3;
import com.multi.threading.practice.thread.Thread6;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadExamples {

	private static final ThreadExamples object = new ThreadExamples();

	public static void main(String[] args) {
		//threadName.withThread();
		//threadName.withThread2();
		//threadName.withRunnable();
		object.threadClassMethods();
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
		Runnable runnable = () -> log.info("name={}", Thread.currentThread().getName());
		Thread thread = new Thread(runnable, "app-thread-2");
		thread.start();
		log.info("main thread name={}", Thread.currentThread().getName());
	}

	@SneakyThrows
	public void threadClassMethods() {
		Thread t1 = new Thread6("thread-6");
		t1.setDaemon(true);

		log.info("{} thread is starting {}", Thread.currentThread().getName(), t1.getName());
		t1.start();

		t1.join();

		log.info("{} execution completed", t1.getName());
	}
}
