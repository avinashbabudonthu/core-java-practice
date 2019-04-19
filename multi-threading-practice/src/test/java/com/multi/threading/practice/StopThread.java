package com.multi.threading.practice;

import com.multi.threading.practice.thread.Thread4;
import com.multi.threading.practice.thread.Thread5;

import lombok.SneakyThrows;

public class StopThread {

	private static final StopThread stopThread = new StopThread();

	public static void main(String[] args) {
		stopThread.stopThreadWithSignal();
		//stopThread.sleep();
	}

	@SneakyThrows
	public void stopThreadWithSignal() {
		Thread4 thread1 = new Thread4();
		Thread thread2 = new Thread(thread1);

		thread2.start();

		Thread.sleep(1000 * 10);
		thread1.doStop();
	}

	public void sleep() {
		Thread thread = new Thread5();
		thread.start();
	}
}
