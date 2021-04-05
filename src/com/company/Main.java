package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {

        List<String> list = asList("My", "name", "is", "John", "Doe");
        List<String> collect1 = list.stream()
                .map(string -> string.toUpperCase())
                .collect(Collectors.toList());
        System.out.println("1. " + collect1);

        List<String> collect2 = list.stream()
                .filter((string) -> string.length() < 4)
                .collect(Collectors.toList());
        System.out.println("2. " + collect2);

        List<List<String>> collection = asList(asList("Victor", "Farcis"), asList("John", "Doe"));
        List<String> collect = collection.stream()
                .flatMap((each) -> each.stream())
                .collect(Collectors.toList());
        System.out.println("3. " + collect);

        Person person1 = new Person(4, "Sara","Norway");
        Person person2 = new Person(42, "Eva","Norway");
        Person person3 = new Person(40, "Viktor","Serbia");
        Person person4 = new Person(5, "Anna","Armenia");
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        Integer integer = persons.stream()
                .map((each) -> each.getAge())
                .max((integer1, integer2) -> integer1.compareTo(integer2)).get();
        System.out.println("4. " + integer);

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        int sum = integers.stream()
                .mapToInt((each) -> each)
                .sum();
        System.out.println("5. " + sum);

        List<Person> collect3 = persons.stream()
                .filter((person -> person.getName().toLowerCase().equals("sara") | person.getName().toLowerCase().equals("anna")))
                .collect(Collectors.toList());
        System.out.println("6. " + collect3);

        Map<Boolean, List<Person>> collect4 = persons.stream()
                .collect(Collectors.groupingBy(person -> person.getAge() > 18));
        System.out.println("7. " + collect4);

        Map<String, List<Person>> collect5 = persons.stream()
                .collect(Collectors.groupingBy(Person::getNationality));
        System.out.println("8. " + collect5);

        String collect6 = persons.stream()
                .map(person -> person.getName())
                .collect(Collectors.joining(","));
        System.out.println("9. " + collect6);

    }
}
