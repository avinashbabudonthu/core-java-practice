package com.multi.threading.practice;

import com.multi.threading.practice.model.Model12;
import com.multi.threading.practice.thread.Thread7;
import com.multi.threading.practice.thread.Thread8;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WaitNotifyNotifyAll {

	private static final WaitNotifyNotifyAll object = new WaitNotifyNotifyAll();

	public static void main(String[] args) {
		object.readIfNameIsSetElseWait();
	}

	@SneakyThrows
	public void readIfNameIsSetElseWait() {
		Model12 model = new Model12();
		Thread readingThread = new Thread(Thread7.builder().model(model).build());
		Thread writingThread = new Thread(Thread8.builder().model(model).build());

		readingThread.start();
		writingThread.start();

		/*		readingThread.join();
				writingThread.join();
		
				log.info("treads execution completed");*/
	}
}
