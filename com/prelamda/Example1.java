package com.prelamda;

import java.util.function.Predicate;
/**
 * Created by Syed on 19/11/2022.
 */
interface IsReferable {
    public void MainFunctionCall();
}

class Example1 {

    public static void commonMethod() {
        System.out.println("This method is already defined.");
    }

    public  void implement() {

        // Anonymous class.
        IsReferable demoOne = new IsReferable() {
            @Override
            public void MainFunctionCall() {
                Example1.commonMethod();
            }
        };
        demoOne.MainFunctionCall();

        // Lambda implementaion.
        IsReferable demo = () -> Example1.commonMethod();
        demo.MainFunctionCall();

        // Method reference.
        IsReferable demoTwo = Example1::commonMethod;
        demoTwo.MainFunctionCall();


        // Lambda implementaion.
        IsReferable demoWithImplementation = () -> {System.out.printf("Here is the implementation");};
        demoWithImplementation.MainFunctionCall();


    }
    public static void main(String[] args) {
        Example1 R= new Example1();
        R.implement();


        Predicate<String> i  = (s)-> s.length() > 5;

        System.out.println(i.test("Hello Data! "));
    }
}