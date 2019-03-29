package com.multi.threading.practice.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Thread6 extends Thread {

	public Thread6(String name) {
		super(name);
	}

	@Override
	public void run() {
		Thread currentThread = currentThread();
		log.info("current-thread={}", currentThread);
		log.info("current-thread-id={}", currentThread.getId());
		log.info("current-thread-name={}", currentThread.getName());
		log.info("current-thread-priority={}", currentThread.getPriority());
		log.info("current-thread-is-alive={}", currentThread.isAlive());
		log.info("current-thread-is-daemon={} ", currentThread.isDaemon());
		log.info("current-thread-is-interrupted={}", currentThread.isInterrupted());
		log.info("current-thread-stack-trace={}", currentThread.getStackTrace());

		State state = currentThread.getState();
		log.info("current-thread-state={}", state);

		ThreadGroup threadGroup = currentThread.getThreadGroup();
		log.info("current-thread-group={}", threadGroup);
		log.info("current-thread-group-name={}", threadGroup.getName());
		log.info("current-thread-group-max-priority={}", threadGroup.getMaxPriority());
		log.info("current-thread-group-parent={}", threadGroup.getParent());
		log.info("current-thread-group-uncaught-expcetion-handler={}", currentThread.getUncaughtExceptionHandler());
	}
}
