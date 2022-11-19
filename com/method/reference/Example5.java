package com.method.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Example5 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 15, 16);
        List primeNumbers = Example5
                .findPrimeNumbers(numbers,
                        (n)->isPrime((Integer)n));

        numbers.stream().forEach(Example5::isPrime);
        System.out.println("Prime Numbers are "+ primeNumbers);
    }

    public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static List findPrimeNumbers(List list,
                                        Predicate predicate) {
        List sortedNumbers = new ArrayList();
        list.stream().filter(predicate).forEach(sortedNumbers::add);
        return sortedNumbers;

    }
}
