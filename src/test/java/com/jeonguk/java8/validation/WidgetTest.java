package com.jeonguk.java8.validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class WidgetTest {

	protected Validator validator;

	@Before
	public void before() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test
	public void violations_size() {
		// setup
		Widget w = new Widget();

		// action
		Set<ConstraintViolation<Widget>> violations = validator.validate(w);

		// assert
		Assert.assertEquals(1, violations.size());
	}

	@Test
	public void violation_message() {
		// setup
		Widget w = new Widget();

		// action
		Set<ConstraintViolation<Widget>> violations = validator.validate(w);

		// assert
		ConstraintViolation<Widget> v = violations.stream().findFirst().get();

		Assert.assertEquals("반드시 널(null)이 아니어야 합니다.", v.getMessage());
	}

	@Test
	public void violation_messageTemplate() {
		// setup
		Widget w = new Widget();

		// action
		Set<ConstraintViolation<Widget>> violations = validator.validate(w);

		// assert
		ConstraintViolation<Widget> v = violations.stream().findFirst().get();

		Assert.assertEquals("{javax.validation.constraints.NotNull.message}", v.getMessageTemplate());
	}

	@Test
	public void violation_propertyPath() {
		// setup
		Widget w = new Widget();

		// action
		Set<ConstraintViolation<Widget>> violations = validator.validate(w);

		// assert
		ConstraintViolation<Widget> v = violations.stream().findFirst().get();

		Assert.assertEquals("name", v.getPropertyPath().toString());
	}
}
