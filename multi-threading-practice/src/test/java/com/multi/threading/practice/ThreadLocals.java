package com.multi.threading.practice;

import java.util.HashMap;
import java.util.Map;

import com.multi.threading.practice.model.Model10;
import com.multi.threading.practice.model.Model11;
import com.multi.threading.practice.model.Model9;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@SuppressWarnings({ "rawtypes", "unchecked" })
@Slf4j
public class ThreadLocals {

	private static final ThreadLocal threadLocal = new ThreadLocal();
	private static final ThreadLocals object = new ThreadLocals();

	public static void main(String[] args) {
		//object.putValuesToThreadLocal();
		//object.threadLocalWithGenericString();
		//object.threadLocalWithGenericMap();
		object.threadLocalInitialValue();
	}

	@SneakyThrows
	public void putValuesToThreadLocal() {
		Thread t1 = new Thread(() -> {
			try {
				log.info("executing t1");
				threadLocal.set("thread1");
				Thread.sleep(1000 * 2);
				log.info("t1.threadlocal={}", threadLocal.get());
			} catch (InterruptedException e) {
				log.error("Exception", e);
			}
		});

		Thread t2 = new Thread(() -> {
			try {
				log.info("executing t2");
				threadLocal.set("thread2");
				Thread.sleep(1000 * 3);
				log.info("t2.threadlocal={}", threadLocal.get());
			} catch (InterruptedException e) {
				log.error("Exception", e);
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		log.info("threads execution completed");
	}

	@SneakyThrows
	public void threadLocalWithGenericString() {
		Thread t1 = new Thread(() -> {
			try {
				log.info("executing t1");
				Model9.put("thread1");
				Thread.sleep(1000 * 2);
				log.info("t1.threadLocal={}", Model9.get());
			} catch (Exception e) {
				log.error("Exception", e);
			}
		});

		Thread t2 = new Thread(() -> {
			try {
				log.info("executing t2");
				Model9.put("thread2");
				Thread.sleep(1000 * 3);
				log.info("t2.threadLocal={}", Model9.get());
			} catch (Exception e) {
				log.error("Exception", e);
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		log.info("threads execution completed");
	}

	@SneakyThrows
	public void threadLocalWithGenericMap() {
		Thread t1 = new Thread(() -> {
			try {
				log.info("executing t1");

				Map<String, Object> map = new HashMap<>();
				map.put("1", "one");
				map.put("two", 2);
				Model10.put(map);

				Thread.sleep(1000 * 2);
				log.info("t1.threadLocal={}", Model10.get());
			} catch (Exception e) {
				log.error("Exception", e);
			}
		});

		Thread t2 = new Thread(() -> {
			try {
				log.info("executing t2");

				Map<String, Object> map = new HashMap<>();
				map.put("3", "three");
				map.put("four", 4);
				Model10.put(map);

				Thread.sleep(1000 * 2);
				log.info("t2.threadLocal={}", Model10.get());
			} catch (Exception e) {
				log.error("Exception", e);
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		log.info("threads execution completed");
	}

	@SneakyThrows
	public void threadLocalInitialValue() {
		Thread t1 = new Thread(() -> {
			try {
				log.info("executing t1");
				Model11.put("thread1");
				Thread.sleep(1000 * 3);
				log.info("t1.threadLocal={}", Model11.get());
			} catch (Exception e) {
				log.error("Exception", e);
			}
		});

		Thread t2 = new Thread(() -> {
			try {
				log.info("executing t2");
				Thread.sleep(1000 * 2);
				log.info("t2.threadLocal={}", Model11.get());
			} catch (Exception e) {
				log.error("Exception", e);
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		log.info("threads execution completed");
	}
}
