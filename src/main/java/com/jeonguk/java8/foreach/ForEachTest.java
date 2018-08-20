package com.jeonguk.java8.foreach;

import java.util.*;
import java.util.function.Consumer;

public class ForEachTest {

    public static void main(String[] args) {
        // creating Collection
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        list.forEach(System.out::println);

        // traversing through forEach method of Iterable with anonymous class
        list.forEach(t -> System.out.println("forEach anonymous class Value:: " + t));

        // traversing with Consumer interface implementation
        MyConsumer action = new MyConsumer();
        list.forEach(action);


        // forEach and Map
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);
        // In Java 8, you can loop a Map with forEach + lambda expression.
        items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));

        items.forEach((k,v)->{
            System.out.println("Item : " + k + " Count : " + v);
            if("E".equals(k)){
                System.out.println("Hello E");
            }
        });

        // forEach and List
        List<String> itemList = new ArrayList<>();
        itemList.add("A");
        itemList.add("B");
        itemList.add("C");
        itemList.add("D");
        itemList.add("E");
        // In Java 8, you can loop a List with forEach + lambda expression or method reference.
        //lambda
        //Output : A,B,C,D,E
        itemList.forEach(System.out::println);

        //Output : C
        itemList.forEach(item->{
            if("C".equals(item)){
                System.out.println(item);
            }
        });

        //method reference
        //Output : A,B,C,D,E
        itemList.forEach(System.out::println);

        //Stream and filter
        //Output : B
        itemList.stream()
                .filter(s->s.contains("B"))
                .forEach(System.out::println);

        
    }

}

class MyConsumer implements Consumer<Integer> {

    @Override
    public void accept(Integer t) {
        System.out.println("Consumer implment value :: " + t);
    }
}