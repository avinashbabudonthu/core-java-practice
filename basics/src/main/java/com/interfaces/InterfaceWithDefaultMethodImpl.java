package com.interfaces;

public class InterfaceWithDefaultMethodImpl implements InterfaceWithDefaultMethod {

	public String method1() {
		InterfaceWithDefaultMethod.super.method1();

		InterfaceWithDefaultMethodImpl object = new InterfaceWithDefaultMethodImpl();
		object.method1();

		InterfaceWithDefaultMethod.method2();

		return "method1";
	}
}
