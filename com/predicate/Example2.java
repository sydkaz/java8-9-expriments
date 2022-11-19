package com.predicate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
/**
 * Created by Syed on 19/11/2022.
 */
public class Example2  {
    public static void main(String[] args) {
        List<Student> employees = Arrays.asList(
                new Student(1, 3, "John"),
                new Student(2, 3, "Jane"),
                new Student(3, 4, "Jack")
        );

        // with predicate
        System.out.println(findStudents(employees, createCustomPredicateWith(10_000)));

        // with function definition, both are same
        Function<Double, Predicate<Student>> customFunction = threshold -> (e -> e.gpa > threshold);
        System.out.println(findStudents(employees, customFunction.apply(10_000D)));
    }

    private static Predicate<Student> createCustomPredicateWith(double threshold) {
        return (e) -> e.gpa > threshold;
    }

    private static List<Student> findStudents(List<Student> employees, Predicate<Student> condition) {
        List<Student> result = new ArrayList<>();

        for (Student e : employees) {
            if (condition.test(e)) {
                result.add(e);
            }
        }

        return result;
    }

}
class Student {
    public int id;
    public long gpa;
    public String name;

    Student(int id, long g, String name) {
        this.id = id;
        this.gpa = g;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + ">" + name + ": " + gpa;
    }
}