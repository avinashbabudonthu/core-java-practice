package com.multi.threading.practice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Thread1 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			log.info("i={}", i);
		}
	}
}
