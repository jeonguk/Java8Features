package com.jeonguk.java8.lambda;

public class GreetingLambdaTest {
	private final static String salutation = "Hello!";

	public static void main(String[] args) {
		GreetingService<String> service = message -> System.out.println(salutation + message);
		service.sayHello("Jeonguk");

		lambdaExecutor(service);
	}

	public static void lambdaExecutor(GreetingService service) {
		service.sayHello("Say!");
	}
}

@FunctionalInterface
interface GreetingService<T> {
	void sayHello(T message);
}