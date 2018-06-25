package com.jeonguk.java8.functional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalculatorLambdaTest {
	public static void main(String[] args) {
		Calculator<Integer, Integer> adder = (a, b) -> a + b;

		// lambda can be used to evaluate the expression
		Integer sum = adder.calculate(2, 3);
		log.info("sum {}", sum);

		//you can pass lambda expression as an argument
		printSum(adder);

		//you can return lambda expression as return
		Calculator<Integer, Integer> multiplier = getCalculatorFunc();
		log.info("multiplier {}", multiplier.calculate(6, 9));
	}

	static void printSum(Calculator cal) {
		log.info("printSum {}", cal.calculate(4, 5));
	}

	static Calculator getCalculatorFunc() {
		Calculator<Integer, Integer> multiplier = (a, b) -> a * b;
		return multiplier;
	}
}
