package com.enums.lookup;

import org.junit.Test;

import com.enums.lookup.CardSuitEnum;

public class EnumLookUp {

	/**
	* Best implementation - using static HashMap
	* Steps: 
	* 1. Create static HashMap in Enum
	* 2. write static block and initialize HashMap
	* 3. write a static method lookupName(String name) and return the Enum object using name
	*/
	@Test
	public void lookupMap() {
		String name = "Heart";
		CardSuitEnum cardSuitEnum = CardSuitEnum.lookupByName(name);
		System.out.println("cardSuitEnum: " + cardSuitEnum);
	}
}
