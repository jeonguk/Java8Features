package com.jeonguk.java8.functional;

@FunctionalInterface
interface Calculator<T , R> {
	R calculate(T a, T b);
}
