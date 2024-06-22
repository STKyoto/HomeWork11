package org.example;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task5 {
    public static void main(String[] args) {
        Stream<String> womenNames = Stream.of("Nensy", "Lucy", "Rebecca");
        Stream<String> manNames = Stream.of("Vitold", "Jacob", "Robert");

        zip(womenNames, manNames).forEach(System.out::println);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iterator = first.iterator();
        return second
                .filter(e -> iterator.hasNext())
                .map(e -> {
                    return List.of(iterator.next(), e);
                    })
                .flatMap(List::stream);
    }
}
