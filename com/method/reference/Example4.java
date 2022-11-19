package com.method.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Example4 {

    public static void main(String[] args) {
        List numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16);
        List primeNumbers = Example4.findPrimeNumbers(
                numbers,(number) ->  Example4.isPrime((Integer) number)
        );

        System.out.println("Prime Numbers are " + primeNumbers);
    }

    public static boolean isPrime(int number) {
       boolean result = false;
        if (number == 1) {
            result = false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                result = false;
            }
        }
        result = true;
        return result;
    }

    public static List findPrimeNumbers(List list, Predicate predicate) {
        List sortedNumbers = new ArrayList();
        list.stream().filter((i) -> (predicate.test(i))).forEach((i) -> {
        sortedNumbers.add(i);
    });
        return sortedNumbers;

    }
}
