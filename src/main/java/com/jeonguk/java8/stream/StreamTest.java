package com.jeonguk.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {

        // Filtering Collection by using Stream
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Camera", 50000f));
        productList.add(new Product(2, "Lego", 25000f));
        productList.add(new Product(3, "Computer", 35000f));
        productList.add(new Product(4, "Key board", 20000f));
        productList.add(new Product(5, "Play station", 32000f));

        List<Float> productPriceList = productList.stream()
                                                  .filter(p -> p.price > 32000) // filtering data
                                                  .map(p -> p.price) // fetching price
                                                  .collect(Collectors.toList()); // collection as list

        System.out.println(productPriceList);

        // Iterating
        Stream.iterate(1, element -> element + 1)
                .filter(element -> element % 5 == 0)
                .limit(5)
                .forEach(System.out::println);

        // Filtering and Iterating Collection
        productList.stream()
                   .filter(product -> product.price == 35000)
                   .forEach(product -> System.out.println(product.name));

        // reduce() Method in Collection
        // This is more compact approach for filtering data
        Float totalPrice = productList.stream()
                                      .map(product -> product.price)
                                      .reduce(0.0f, (sum, price) -> sum + price); // accumulating price
        System.out.println(totalPrice);
        // More precise code
        float totalPrice2 = productList.stream()
                .map(product -> product.price)
                .reduce(0.0f, Float::sum); // accumulating price, by referring method of Float class
        System.out.println(totalPrice2);

        // Find Max and Min Product Price
        // max() method to get max Product price
        Product productA = productList.stream()
                                      .max((product1, product2) -> product1.price > product2.price ? 1: -2).get();

        System.out.println(productA.price);
        // min() method to get min Product price
        Product productB = productList.stream()
                                      .max((product1, product2) -> product1.price < product2.price ? 1: -1).get();
        System.out.println(productB.price);

        // count() Method in Collection
        // count number of products based on the filter
        long count = productList.stream()
                .filter(product -> product.price < 25000)
                .count();
        System.out.println(count);

        // Convert List into Set
        // Converting product List into Set
        Set<Float> productPriceSetList = productList.stream()
                                                .filter(product -> product.price < 25000) // filter product on the base of price
                                                .map(product -> product.price)
                                                .collect(Collectors.toSet()); // collect it as Set(remove duplicate elements)
        System.out.println(productPriceSetList);

        // Convert List into Map
        // Converting Product List into a Map
        Map<Integer, String> productPriceMap = productList.stream()
                                                          .collect(Collectors.toMap(p -> p.id, p -> p.name));
        System.out.println(productPriceMap);

        // Method Reference in stream
        List<Float> productPriceFloatList = productList.stream()
                                                       .filter(p -> p.price > 25000) // filtering data
                                                       .map(Product::getPrice) // fetching price by referring getPrice method
                                                       .collect(Collectors.toList()); // collecting as list
        System.out.println(productPriceFloatList);
    }
}

class Product {

    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public float getPrice() {
        return price;
    }
}
