package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        String[] array = {"1, 2, 0", "4, 5"};
        System.out.println(arrayChanger(array));
    }

    private static String arrayChanger(String[] array) {
        return Arrays.stream(array)
                .flatMap(arrayElement -> Arrays.stream(arrayElement.split(", ")))
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }


}
