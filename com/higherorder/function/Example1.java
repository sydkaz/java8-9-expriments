package com.higherorder.function;

import java.util.Arrays;
import java.util.function.Function;
/**
 * Created by Syed on 7/31/2017.
 */
public class Example1 {

    public static void main(String[] args) {
        Function<Integer, Long> addOne = add(1L);

        System.out.println(addOne.apply(1)); //prints 2

        Arrays.asList("test", "new")
                .parallelStream()  // suggestion for execution strategy
                .map(camelize)     // call for static reference
                .forEach(System.out::println);

        Function<Function<Integer, Integer>,
                 Function<Integer, Integer>> twice = inComingVar -> inComingVar.andThen(inComingVar);
        System.out.println(twice.apply(x -> x + 3).apply(7));
    }

    private static Function<Integer, Long> add(long l) {
        return (Integer i) -> l + i;
    }

    private static Function<String, String> camelize = (str) -> str.substring(0, 1).toUpperCase() + str.substring(1);


}