package com.multi.threading.practice.thread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Thread4 implements Runnable {

	private Boolean doStop = false;

	public synchronized void doStop() {
		this.doStop = true;
	}

	public synchronized Boolean continueExecution() {
		return this.doStop == false;
	}

	@SneakyThrows
	@Override
	public void run() {
		int i = 0;
		while (continueExecution()) {
			log.info("i={}", i++);
			Thread.sleep(1000 * 2);
		}
	}

}
