package org.example;

import java.util.stream.Stream;

public class Task4 {
    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2,48);

        Stream<Long> randomStream = generateRandomStream(a, c, m,123456L);

        randomStream.limit(20).forEach(System.out::println);
    }

    private static Stream<Long> generateRandomStream(long a, long c, long m, long l) {
        return Stream.iterate(l, x -> ((a * x) + c) % m);
    }


}
