package com.multi.threading.practice;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Thread5 extends Thread {

	@SneakyThrows
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			log.info("i={}", i);
			Thread.sleep(1000 * 2);
		}
	}
}
