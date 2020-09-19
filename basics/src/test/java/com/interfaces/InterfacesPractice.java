package com.interfaces;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InterfacesPractice {

	@Test
	public void callDefaultMethodOfInterface() {
		InterfaceWithDefaultMethodImpl interfaceWithDefaultMethod = new InterfaceWithDefaultMethodImpl();
		log.info("method1 result={}", interfaceWithDefaultMethod.method1());
	}
}
