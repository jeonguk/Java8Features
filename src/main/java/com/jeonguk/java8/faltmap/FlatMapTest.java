package com.jeonguk.java8.faltmap;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapTest {

    public static void main(String[] args) {

        String[][] data = new String[][]{{"a","b"}, {"c","d"}, {"e","f"}};

        // Stream<String[]>
        Stream<String[]> temp = Arrays.stream(data);

        // filter a stream of string[], and return a string[]
//        Stream<String[]> stream = temp.filter(x -> "a".equals(x.toString()));
//
//        stream.forEach(System.out::println);

        //Stream<String>, GOOD!
        Stream<String> stringStream = temp.flatMap(x -> Arrays.stream(x));

        Stream<String> stream = stringStream.filter(x -> "a".equals(x.toString()));

        stream.forEach(System.out::println);
    }
}
