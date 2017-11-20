package com.jeonguk.java8.string;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringJoinerTest {

    public static void main(String[] args) {

        // Join String by a dilimiter
        StringJoiner sj1 = new StringJoiner(",");
                     sj1.add("aaa");
                     sj1.add("bbb");
                     sj1.add("ccc");
                     String result1 = sj1.toString();
        System.out.println(result1);

        // Join String by a delimiter and starting with a supplied prefix and ending with a supplied suffix.
        StringJoiner sj2 = new StringJoiner("/","prefix-","-suffix");
                     sj2.add("2016");
                     sj2.add("02");
                     sj2.add("26");
        String result2 = sj2.toString();
        System.out.println(result2);

        // String.join
        // Join String by a delimiter.
        String result3 = String.join("-", "2015", "10", "31");
        System.out.println(result3);

        List<String> list1 = Arrays.asList("java", "python", "scala", "nodejs", "ruby");
        String result4 = String.join(", ", list1);
        System.out.println(result4);

        // Collectors.joining
        // Join List<String> example.
        List<String> list2 = Arrays.asList("java", "python", "scala", "nodejs", "ruby");
        String result5 = list2.stream().map(x -> x).collect(Collectors.joining(" | "));
        System.out.println(result5);

    }

}
