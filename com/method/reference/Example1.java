package com.method.reference;
/**
 * Created by Syed on 19/11/2022.
 */
interface IsReferable {
    public void referenceDemo();
}

class Example1 {

    public static void commonMethod() {
        System.out.println("This method is already defined.");
    }

    public  void implement() {

        // Anonymous class.
        IsReferable demoOne = new IsReferable() {
            @Override
            public void referenceDemo() {
                Example1.commonMethod();
            }
        };
        demoOne.referenceDemo();

        // Lambda implementaion.
        IsReferable demo = () -> Example1.commonMethod();
        demo.referenceDemo();

        // Method reference.
        IsReferable demoTwo = Example1::commonMethod;
        demoTwo.referenceDemo();
    }
    public static void main(String[] args) {
        Example1 R= new Example1();
        R.implement();
    }
}