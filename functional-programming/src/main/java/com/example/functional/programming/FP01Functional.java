package com.example.functional.programming;

import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {
        List<Integer> integers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        printAllNumbersInList(integers);
        printEvenNumbersInList(integers);
        printSquaresOfEvenNumbersInList(integers);
    }

    private static void printAllNumbersInList(List<Integer> integers) {

        // Convert list of numbers into a stream of elements
        integers.stream().forEach(System.out::println); // Method reference

    }

    private static void printEvenNumbersInList(List<Integer> integers) {

        // Convert list of numbers into a stream of elements
        integers.stream().filter(i -> i % 2 == 0).forEach(System.out::println); // Method reference

    }

    private static void printSquaresOfEvenNumbersInList(List<Integer> integers) {

        // Convert list of numbers into a stream of elements
        integers.stream().map(i -> i*i).forEach(System.out::println); // Method reference

    }
}
