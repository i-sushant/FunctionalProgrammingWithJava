package org.practice;



import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App 
{
    public static void main( String[] args ) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Alice", Gender.FEMALE),
                new Person("Alicia", Gender.FEMALE),
                new Person("Alan", Gender.MALE),
                new Person("Wright", Gender.MALE)
        );
        //Declarative approach
        people.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender))
                .collect(Collectors.toList())
                .forEach(System.out::println);

    //with another variable
        List<Person> females = people.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender))
                .collect(Collectors.toList());

        females.forEach(System.out::println);

        //Improved
        people.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender))
                .forEach(System.out::println);
        //Predicate example
        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);
        List<Person> females2 = people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());

        females2.forEach(System.out::println);
    }
    enum Gender {
        MALE,
        FEMALE
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

