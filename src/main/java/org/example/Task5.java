package org.example;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Task5 {
    public static void main(String[] args) {
        Stream<String> womenNames = Stream.of("Nensy", "Lucy", "Rebecca");
        Stream<String> manNames = Stream.of("Vitold", "Jacob", "Robert");

        zip(womenNames, manNames).forEach(System.out::println);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(new Iterator<T>() {
            private boolean useFirst = true;

            @Override
            public boolean hasNext() {
                return firstIterator.hasNext() && secondIterator.hasNext();
            }

            @Override
            public T next() {
                if (useFirst) {
                    useFirst = false;
                    return firstIterator.next();
                } else {
                    useFirst = true;
                    return secondIterator.next();
                }
            }
        }, Spliterator.ORDERED);

        return StreamSupport.stream(spliterator, false);
    }
}
