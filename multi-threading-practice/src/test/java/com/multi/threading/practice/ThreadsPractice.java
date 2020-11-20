package com.multi.threading.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.multi.threading.practice.thread.Thread24;
import com.multi.threading.practice.thread.Thread25;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadsPractice {

	/**
	 * @see java.util.concurrent.Callable practice
	 * @see java.util.concurrent.Future practice
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@Test
	public void callableFutures() throws InterruptedException, ExecutionException {

		Callable<List<Integer>> callable = new Callable<List<Integer>>() {
			@Override
			public List<Integer> call() throws Exception {
				List<Integer> list = new ArrayList<>();
				for (int i = 0; i < 10; i++) {
					list.add(i + 1);
				}
				return list;
			}
		};

		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<List<Integer>> resultFutures = executorService.submit(callable);
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.DAYS);

		List<Integer> resultList = resultFutures.get();

		log.info("{}", resultList);
	}

	/**
	 * Execute multiple callables at a time
	 * @throws InterruptedException 
	 * @throws ExecutionException 
	 */
	@Test
	public void executeMultipleCallables() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		Set<Callable<List<Integer>>> callables = new HashSet<>();
		List<Integer> finalResult = new ArrayList<>();

		Callable<List<Integer>> callable1 = new Thread24(10, 20);
		Callable<List<Integer>> callable2 = new Thread24(30, 40);
		Callable<List<Integer>> callable3 = new Thread24(50, 60);

		callables.add(callable1);
		callables.add(callable2);
		callables.add(callable3);

		List<Future<List<Integer>>> resultFutures = executorService.invokeAll(callables);

		for (Future<List<Integer>> resultFuture : resultFutures) {
			finalResult.addAll(resultFuture.get());
		}

		System.out.println(finalResult);
	}

	/**
	 * @see java.util.concurrent.Callable practice
	 * @see java.util.concurrent.Future practice
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@Test
	public void callableFuturesWithException() throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();

		Callable<List<Integer>> callable = new Callable<List<Integer>>() {
			@Override
			public List<Integer> call() throws Exception {
				throw new NullPointerException("callable Exception practice");
			}
		};

		Future<List<Integer>> resultFutures = executorService.submit(callable);
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.DAYS);

		try {
			List<Integer> resultList = resultFutures.get();
			System.out.println(resultList);
		} catch (ExecutionException e) {
			e.printStackTrace();

			NullPointerException ex = (NullPointerException) e.getCause();
			System.out.println(ex.getMessage());
		}

	}

	@Test
	public void multipleCallablesWithException() {
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		Callable<Integer> callable1 = new Thread25();
		Callable<Integer> callable2 = new Thread25();
		Callable<Integer> callable3 = new Thread25();

		List<Callable<Integer>> callableList = new ArrayList<>();
		callableList.add(callable1);
		callableList.add(callable2);
		callableList.add(callable3);
		try {
			List<Future<Integer>> futureList = executorService.invokeAll(callableList);
			futureList.get(0).get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
