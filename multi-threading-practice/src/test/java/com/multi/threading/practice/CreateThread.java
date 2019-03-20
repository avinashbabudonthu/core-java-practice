package com.multi.threading.practice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateThread {

	private static CreateThread createThread = new CreateThread();

	public static void main(String[] args) {
		//createThread.method1();
		createThread.illegalStateException();
		//createThread.implementsRunnable();
		//createThread.anonymousInnerClassWithThread();
		//createThread.anonymousInnerClassWithRunnable();
		//createThread.withLambda();
	}

	public void extendsThread() {
		Thread thread = new Thread1();
		thread.start();
	}

	public void illegalStateException() {
		try {
			Thread thread = new Thread1();
			thread.start();
			thread.start();
		} catch (Exception e) {
			log.info("Error", e);
		}
	}

	public void implementsRunnable() {
		Thread thread = new Thread(new Thread2());
		thread.start();
	}

	public void anonymousInnerClassWithThread() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					log.info("i={}", i);
				}
			}
		};

		thread.start();
	}

	public void anonymousInnerClassWithRunnable() {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					log.info("i={}", i);
				}
			}
		};

		new Thread(runnable).start();
	}

	public void withLambda() {
		Runnable runnable = () -> {
			for (int i = 0; i < 10; i++) {
				log.info("i={}", i);
			}
		};
		new Thread(runnable).start();
	}

}
