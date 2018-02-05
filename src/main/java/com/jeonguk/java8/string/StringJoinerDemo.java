package com.jeonguk.java8.string;

import java.util.*;
import java.util.stream.Collectors;

public class StringJoinerDemo {

  public static void main(String[] args) {
    // Simple Delimiter Join
    joinDelimiter();

    System.out.println();

    // Join using Prefix and Suffix
    joinerWithPrefixSuffix();

    System.out.println();

    // Join using ListJoiner
    listJoiner();

    System.out.println();

    // Collection Joiner
    collectorJoiner();

    System.out.println();

    // Merging two StringJoiner objects
    mergeJoiner();
  }

  public static void joinDelimiter() {
    // Passing The Delimiter
    StringJoiner myString = new StringJoiner("-");

    // Joining Mulitple Strings By Using 'add()' Method
    myString.add("Logan");
    myString.add("Magneto");
    myString.add("Storm");
    myString.add("Rogue");

    // Displaying The Output String
    System.out.println("StringJoiner with simple delimiter : " + myString);
  }

  public static void joinerWithPrefixSuffix() {
    // Passing Hyphen(-) As Delimiter & Opening Bracket "(" As Prefix & Closing Bracket ")" As Suffix
    StringJoiner myDate = new StringJoiner("-", "(", ")");

    // Joining Multiple Strings By Using 'add()' Method
    myDate.add("2018");
    myDate.add("Feb");
    myDate.add("01");

    // Displaying The Output String
    System.out.println("StringJoiner with Prefix and Suffix : " + myDate);
  }

  public static void listJoiner() {
    List<String> dList = new ArrayList<>();
    dList.add("SUNDAY");
    dList.add("MONDAY");
    dList.add("TUESDAY");
    dList.add("WEDNESDAY");
    dList.add("THURSDAY");
    dList.add("FRIDAY");
    dList.add("SATURDAY");

    // Passing The Delimiter
    String days = String.join(",", dList);

    // Displaying The Output String
    System.out.println("Join List with Delimiter : " + days);
  }

  public static void collectorJoiner() {
    List<String> tList = Arrays.asList("Spring", "Java", "Hibernate", "Angularjs", "MongoDb");

    // Passing The Delimiter
    String tutorials = tList.stream().map(t -> t).collect(Collectors.joining(","));

    // Displaying The Output String
    System.out.println("Collector Joining : " + tutorials);
  }

  public static void mergeJoiner() {
    // Passing Comma(,) AS Delimiter & Opening Bracket "{" As Prefix & Closing Bracket "}" As Suffix
    StringJoiner joiner1 = new StringJoiner(",", "{", "}");
    joiner1.add("One");
    joiner1.add("Two");

    // Passing Comma(:) AS Delimiter & Opening Bracket "[" As Prefix & Closing Bracket "]" As Suffix
    StringJoiner joiner2 = new StringJoiner(":", "[", "]");
    joiner2.add("Three");
    joiner2.add("Four");
    joiner2.add("Five");

    // Displaying The Output String
    StringJoiner mergeStr = joiner1.merge(joiner2);
    System.out.println("Merge two StringJoiners : " + mergeStr);
  }

}