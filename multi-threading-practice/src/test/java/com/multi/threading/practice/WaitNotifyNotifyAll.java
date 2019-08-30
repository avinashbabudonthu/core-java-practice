package com.multi.threading.practice;

import com.multi.threading.practice.model.Model12;
import com.multi.threading.practice.thread.Thread7;
import com.multi.threading.practice.thread.Thread8;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * 1. Thread class wait() on any object becomes inactive until another thread calls notify() on same object
 *
 */
@Slf4j
public class WaitNotifyNotifyAll {

	private static final WaitNotifyNotifyAll object = new WaitNotifyNotifyAll();

	public static void main(String[] args) {
		object.readIfNameIsSetElseWait();
	}

	@SneakyThrows
	public void readIfNameIsSetElseWait() {
		Model12 model = new Model12();
		Thread readingThread = new Thread(Thread7.builder().model(model).build(), "reading-thread");
		Thread writingThread = new Thread(Thread8.builder().model(model).build(), "writing-thread");

		readingThread.start();
		writingThread.start();

		readingThread.join();
		writingThread.join();

		log.info("{}, {} execution completed", readingThread.getName(), writingThread.getName());
	}
}
