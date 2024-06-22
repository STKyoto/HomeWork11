package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Olga");
        names.add("Ivan");
        names.add("Peter");
        names.add("Max");
        System.out.println(ListFilter(names));
    }

    private static List<String> ListFilter(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .sorted((Comparator.reverseOrder()))
                .toList();
    }
}
