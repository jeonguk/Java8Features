package com.jeonguk.java8.readfile;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * reads a text file line-by-line using java 8
 */
public class ReadFileLineByLine {

  public static void main(String[] args) {
    String fileName = "/Users/jeonguk/TEMP/testfile.txt";

    fileStreamUsingFiles(fileName);

    System.out.println();

    filterFileData(fileName);

    System.out.println();

    fileStreamUsingBufferedReader(fileName);
  }

  /* OUTPUT
  <!------ Read all lines as a Stream ----->
  sunday
  monday
  tuesday
  wednesday
  thursday
  friday
  saturday


  <!----- Filtering the file data using Java8 filtering ----->
  sunday
  saturday

  <!----- Read all lines by using BufferedReader ----->
  SUNDAY
  MONDAY
  TUESDAY
  WEDNESDAY
  THURSDAY
  FRIDAY
  SATURDAY
  */


  private static void fileStreamUsingFiles(String fileName) {
    try {
      Stream<String> lines = Files.lines(Paths.get(fileName));
      System.out.println("<!------ Read all lines as a Stream ----->");
      lines.forEach(System.out::println);
      lines.close();
    } catch (IOException ie) {
      ie.printStackTrace();
    }
  }

  private static void filterFileData(String fileName) {
    try {
      Stream<String> lines = Files.lines(Paths.get(fileName)).filter(line -> line.startsWith("s"));
      System.out.println("<!----- Filtering the file data using Java8 filtering ----->");
      lines.forEach(System.out::println);
      lines.close();
    } catch (IOException ie) {
      ie.printStackTrace();
    }
  }

  private static void fileStreamUsingBufferedReader(String fileName) {
    try {
      BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
      Stream<String> lines = br.lines().map(str -> str.toUpperCase());
      System.out.println("<!----- Read all lines by using BufferedReader ----->");
      lines.forEach(System.out::println);
      lines.close();
    } catch (IOException ie) {
      ie.printStackTrace();
    }
  }

}
