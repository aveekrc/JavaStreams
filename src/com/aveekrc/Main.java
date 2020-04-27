package com.aveekrc;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Person> people = getPeople();

        // Imperative approach ❌

        /*List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (person.getGender().equals(Gender.FEMALE)) {
                females.add(person);
            }
        }
        females.forEach(System.out::println);*/

        // Declarative approach ✅

        // Filter
        // filter takes a predicate which is boolean
        /*List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

        females.forEach(System.out::println);*/


        // Sort
        /*List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getName).reversed())
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);*/


        // All match
        /*boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 5);
        System.out.println(allMatch);*/

        // Any match
        /*boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 1 30);
        System.out.println(anyMatch);*/


        // None match
        /*boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Antonio"));
        System.out.println(noneMatch);*/

        // Max
        /*people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);*/

        // Min
        /*people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);*/



        // Group
        Map<Gender, List<Person>> group = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        group.forEach((gender, people1) ->
        {
            System.out.println(gender);
            people1.forEach(System.out::println);
        });

        Optional<String> oldestFemale = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);
        oldestFemale.ifPresent(System.out::println);
    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("Antoni", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 33, Gender.MALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE)
        );
    }
}
