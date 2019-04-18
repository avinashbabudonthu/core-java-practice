package com.multi.threading.practice.model;

import lombok.Getter;

public class Model12 {

	@Getter
	private String name;

	private boolean isNameSet = false;

	public void setName(String name) {
		this.name = name;
		isNameSet = true;
	}

	public boolean isNameSet() {
		return isNameSet;
	}

}
