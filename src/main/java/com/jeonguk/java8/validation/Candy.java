package com.jeonguk.java8.validation;

import javax.validation.constraints.NotNull;

public class Candy {
	@NotNull(message = "{Candy.name.NotNull}")
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
