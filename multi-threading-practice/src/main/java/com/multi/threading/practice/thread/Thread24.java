package com.multi.threading.practice.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Thread24 implements Callable<List<Integer>> {

    private int min;
    private int max;

    public Thread24(int min, int max) {
	this.min = min;
	this.max = max;
    }

    @Override
    public List<Integer> call() throws Exception {
	List<Integer> list = new ArrayList<>();
	for (; min <= max; min++) {
	    list.add(min);
	}
	return list;
    }
}
