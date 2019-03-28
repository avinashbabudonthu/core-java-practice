package com.multi.threading.practice.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Thread3 extends Thread {

	public Thread3(String threadName) {
		super(threadName);
	}

	@Override
	public void run() {
		log.info("name1={}, name2={}", getName(), Thread.currentThread().getName());
	}
}
