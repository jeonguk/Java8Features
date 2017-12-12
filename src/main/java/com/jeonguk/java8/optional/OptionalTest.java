package com.jeonguk.java8.optional;

import javax.swing.text.html.Option;
import java.util.Optional;

public class OptionalTest {

  public static void main(String[] args) {

    Optional<String> gender = Optional.of("MALE");
    String answer1 = "Yes";
    String answer2 = null;

    System.out.println("Non-Empty Optional : " + gender);
    System.out.println("Non-Empty Optional : Gender value : " + gender.get());
    System.out.println("Empty Optional : " + Optional.empty());

    System.out.println("ofNullable on Non-Empty Optional : " + Optional.ofNullable(answer1));
    System.out.println("ofNullbale on Empty Optional : " + Optional.ofNullable(answer2));

    // java.lang.NullPointerException
    //System.out.println("ofNullable on Non-Empty Optional : " + Optional.of(answer2));
    System.out.println("================================================================");
    Optional<String> nonEmptyGender = Optional.of("male");
    Optional<String> emptyGender = Optional.empty();

    System.out.println("Non-Empty Optional :: " + nonEmptyGender.map(String::toUpperCase));
    System.out.println("Empty Optional ::" + emptyGender.map(String::toUpperCase));

    System.out.println("================================================================");
    Optional<Optional<String>> nonEmptyOptionalGender = Optional.of(Optional.of("male"));
    System.out.println("Optional value :: " + nonEmptyOptionalGender);
    System.out.println("Optional.map :: " + nonEmptyOptionalGender.map(g -> g.map(String::toUpperCase)));
    System.out.println("Optional.flatMap :: " + nonEmptyOptionalGender.flatMap(g -> g.map(String::toUpperCase)));

    System.out.println("================================================================");
    // Filter on Optional , Optional.filter
    System.out.println(gender.filter(g -> g.equals("male"))); // Optional.empty
    System.out.println(gender.filter(g -> g.equalsIgnoreCase("MALE"))); // Optional[MALE]
    System.out.println(emptyGender.filter(g -> g.equalsIgnoreCase("MALE"))); // Optional.empty

    System.out.println("================================================================");
    // Optional isPresent and ifPresent
    if (gender.isPresent()) {
      System.out.println("Value available.");
    } else {
      System.out.println("Value not available.");
    }

    gender.ifPresent(g -> System.out.println("In gender Option, value available."));

    // condition failed, no output print
    emptyGender.ifPresent(g -> System.out.println("In emptyGender Option, value available."));

    System.out.println("================================================================");
    // Optional orElse methods
    System.out.println(gender.orElse("<N/A>")); // MALE
    System.out.println(emptyGender.orElse("<N/A>")); // <N/A>

    System.out.println(gender.orElseGet(() -> "<N/A>")); // MALE
    System.out.println(emptyGender.orElseGet(() -> "<N/A>")); // <N/A>

    System.out.println("================================================================");
    // With Java 8 Optional
    ScreenResolution resolution = new ScreenResolution(750,1334);
    DisplayFeatures dfeatures = new DisplayFeatures("4.7", Optional.of(resolution));
    Mobile mobile = new Mobile(2015001, "Apple", "iPhone 6s", Optional.of(dfeatures));

    MobileService mService = new MobileService();

    int width = mService.getMobileScreenWidth(Optional.of(mobile));
    System.out.println("Apple iPhone 6s Screen Width = " + width);

    Mobile mobile2 = new Mobile(2015001, "Apple", "iPhone 6s", Optional.empty());
    int width2 = mService.getMobileScreenWidth(Optional.of(mobile2));
    System.out.println("Apple iPhone 16s Screen Width = " + width2);
  }

}
