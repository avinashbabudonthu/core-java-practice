package com.interfaces;

public interface InterfaceWithDefaultMethod {

	default String method1() {
		return "hello default method1()";
	}

	static String method2() {
		return "method 2";
	}
}
