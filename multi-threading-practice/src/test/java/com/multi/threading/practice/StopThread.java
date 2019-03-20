package com.multi.threading.practice;

import lombok.SneakyThrows;

public class StopThread {

	public static void main(String[] args) {
		StopThread stopThread = new StopThread();
		//stopThread.stopThreadWithSignal();
		stopThread.sleep();
	}

	@SneakyThrows
	public void stopThreadWithSignal() {
		Thread4 thread2 = new Thread4();
		Thread thread1 = new Thread(thread2);

		thread1.start();

		Thread.sleep(1000 * 10);
		thread2.doStop();
	}

	public void sleep() {
		Thread thread = new Thread5();
		thread.start();
	}
}
