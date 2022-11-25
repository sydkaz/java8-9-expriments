package com.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Student{
    int[] number;
    String name;

    public Student(int[] number, String name) {
        this.number = number;
        this.name = name;
    }

    public int[] getNumber() {
        return number;
    }

    public void setNumber(int[] number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class MapExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList(){{
            add(new Student(new int[]{10,20,30},"S1"));
            add(new Student(new int[]{30,40,50},"S2"));
            add(new Student(new int[]{60,70,80},"S3"));
            add(new Student(new int[]{90,100,110},"S3"));
        }};


        //Arrays.asList(new Student(new int[]{90,100,110},"S3"));
        System.out.println("Map Example");
        students.stream().flatMapToInt(e-> Arrays.stream(e.getNumber())).forEach(System.out::println);
        System.out.println("Flat Map Example");
        students.stream().map(e-> Arrays.stream(e.getNumber()).sum()).forEach(System.out::println);
    }
}
