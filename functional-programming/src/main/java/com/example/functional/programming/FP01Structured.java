package com.example.functional.programming;

import java.util.List;

public class FP01Structured {

    public static void main(String[] args) {
        List<Integer> integers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        printAllNumbersInList(integers);
        printEvenNumbersInList(integers);
    }

    private static void printAllNumbersInList(List<Integer> integers) {

        // By looping through the numbers
        for(Integer i: integers) {
            System.out.println(i);
        }



    }

    private static void printEvenNumbersInList(List<Integer> integers) {

        // By looping through the numbers
        for(Integer i: integers) {
            if(i % 2 == 0){
                System.out.println(i);
            }

        }



    }
}
