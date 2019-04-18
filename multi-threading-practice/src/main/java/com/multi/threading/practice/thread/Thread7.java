package com.multi.threading.practice.thread;

import com.multi.threading.practice.model.Model12;

import lombok.Builder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
public class Thread7 implements Runnable {

	private Model12 model;

	@SneakyThrows
	@Override
	public void run() {
		synchronized (model) {
			if (!model.isNameSet()) {
				log.info("value not set so wait");
				model.wait();
			}
		}
		log.info("name={}", model.getName());
	}

}
