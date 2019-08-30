package com.multi.threading.practice.thread;

import com.multi.threading.practice.model.Model12;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
public class Thread8 implements Runnable {

	private Model12 model;

	@Override
	public void run() {
		log.info("setting value");
		synchronized (model) {
			model.setName("jack");
			log.info("value is set");
			model.notify(); // throws IllegalMonitorException if current thread is not owner of monitor object
		}
	}
}
