package com.multi.threading.practice;

import java.util.stream.IntStream;

import com.multi.threading.practice.thread.Thread1;
import com.multi.threading.practice.thread.Thread2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateThread {

	private static final CreateThread createThread = new CreateThread();

	public static void main(String[] args) {
		//createThread.extendsThread();
		//createThread.illegalStateException();
		//createThread.implementsRunnable();
		//createThread.anonymousInnerClassWithThread();
		//createThread.callStartOnAnonymousInnerClassWithThread();
		//createThread.anonymousInnerClassWithRunnable();
		createThread.withLambda();
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
			log.info("Exception on starting thread twice", e);
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
				IntStream.range(1, 11).forEach(i -> log.info("i= {}", i));
			}
		};

		thread.start();
	}

	public void callStartOnAnonymousInnerClassWithThread() {
		new Thread() {
			@Override
			public void run() {
				IntStream.range(1, 11).forEach(i -> log.info("i={}", i));
			}
		}.start();
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
		Runnable runnable = () -> IntStream.range(1, 11).forEach(i -> log.info("i={}", i));
		new Thread(runnable).start();

		Runnable runnable2 = () -> {
		    IntStream.range(11, 21).forEach(i -> log.info("i={}", i));
        };
		new Thread(runnable2).start();
	}

}
