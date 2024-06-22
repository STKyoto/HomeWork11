package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task1 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Olga");
        names.add("Ivan");
        names.add("Peter");
        names.add("Max");
        System.out.println(ListFilter(names));
    }

    private static String ListFilter(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> (i + 1) + ". " + names.get(i)) // форматируем строку
                .collect(Collectors.joining(", "));
    }

}
