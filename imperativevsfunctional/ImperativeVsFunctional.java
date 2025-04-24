package io.adad.imperativevsfunctional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class ImperativeVsFunctional {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        int sumImperative = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                sumImperative += number * number;
            }
        }

        System.out.println("Sum Imperative: " + sumImperative);


        int sumFunctional = numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(number -> number * number)
                .sum();

        System.out.println("Sum Functional: " + sumFunctional);

        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number % 2 == 0;
            }
        };

        ToIntFunction<? super Integer> integerToIntFunction = number -> number * number;

        int sumFunctionalPredicate = numbers.stream()
                .filter(predicate)
                .mapToInt(integerToIntFunction)
                .sum();

        System.out.println("Sum Functional Predicate: " + sumFunctionalPredicate);

        // super vs extends in method signatures !!
        // super: Focus on parents/superclasses (safe for adding Person and subclasses).
        // extends: Focus on children/subclasses (safe for reading but restricted for adding).

        List<? super Person> personSuper = new ArrayList<>();
        personSuper.add(new Student("harry", 30, "Science"));
        personSuper.add(new Person("ahmed", 25));

        List<? extends Person> personExtends = new ArrayList<>(
                Arrays.asList(
                        new Student("harry", 30, "Science"),
                        new Person("ahmed", 25)
                )
        );

        personExtends.forEach(System.out::println);

        //personExtends.add(new Person("fares", 25));

    }
}
