package com.function.chain;

import java.util.function.Function;
/**
 * Created by Syed on 19/11/2022.
 */
interface Operation{
    public int operation(int a,int b);

    default Operation andThen(Operation o) {

        return (p1,p2) -> /*o.add(p1,p2);*/ {
            System.out.println(">>>>>>>>>>>>>>>> "+p1+" "+p2+" >>>>>>> "+o);
            return  o.operation(p1,p2) + this.operation(p1,p2);
        };
    }


}

public class Example1 {

    public static int subract(int a ,int b){
    return a-b;
    }


    public static void main(String[] args) {


       Operation o=Example1::subract;
        System.out.println(o.operation(10,4));

        Function<String, String> fn1 = (s1) -> s1+" 1 ";
        Function<String, String> fn2 = (s1) -> s1+" 2 ";
        Function<String, String> fn3 = (s1) -> s1+" 3 ";

        System.out.println(

                ((Function<String,String>)(s1) -> s1+" 1 ").andThen(
                            ((Function<String,String>)(s1) -> s1+" 2 ")
                ).apply("3")
        );

        Operation mul = (p1,p2)-> {
            System.out.println("In mul>>>>>>>"+p1+" "+p2+" ");
            return p1 * p2; };
        Operation add = (p1,p2)-> {  System.out.println("In add>>>>>>>"+p1+" "+p2+" ");
        return p1 + p2; };
        Operation sub = (p1,p2)-> p1 - p2;
        System.out.println(
                mul.andThen(add).operation(2,3)
        );
    }
}
