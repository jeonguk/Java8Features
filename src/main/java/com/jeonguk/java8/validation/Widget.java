package com.jeonguk.java8.validation;

import javax.validation.constraints.NotNull;

public class Widget {
	@NotNull
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
