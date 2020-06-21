package streams;


import org.practice.App;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Alice", FEMALE),
                new Person("Alicia", FEMALE),
                new Person("Alan", MALE),
                new Person("Wright", PREFER_NOT_TO_SAY),
                new Person("Wright", MALE)
        );


        people.stream()
                .map(person -> person.name)
                .collect(Collectors.toSet())
                .forEach(System.out::println);


        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        boolean containsOnlyFemales = people.stream()
                .allMatch(person -> FEMALE.equals(person.gender));
        System.out.println(containsOnlyFemales);

        boolean containsAtLeastOneFemale = people.stream()
                .anyMatch(person -> FEMALE.equals(person.gender));
        System.out.println(containsAtLeastOneFemale);

        boolean containsNoFemales = people.stream()
                .noneMatch(person -> FEMALE.equals(person.gender));
        System.out.println(containsNoFemales);
    }


    enum Gender {
        MALE,
        FEMALE,
        PREFER_NOT_TO_SAY
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender){
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
}
