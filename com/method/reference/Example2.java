package com.method.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Syed on 7/31/2017.
 */
public class Example2 { /** * @param args the command line arguments */
    public static void main(String[] args) {
// TODO code application logic here
        List  numbers = Arrays.asList(4, 9, 16, 25, 36);
        List squaredNumbers = Example2.findSquareRoot(numbers,Integer::new);
        System.out.println("Square root of numbers = "+squaredNumbers);
    }

    private static List findSquareRoot(List list, Function<Integer,Integer> f){
        List result = new ArrayList<>();
        list.forEach(x -> result.add(Math.sqrt(f.apply((Integer) x))));
        return result;
    }
}
