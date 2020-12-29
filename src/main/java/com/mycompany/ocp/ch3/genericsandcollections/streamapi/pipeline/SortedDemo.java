package com.mycompany.ocp.ch3.genericsandcollections.streamapi.pipeline;

import com.mycompany.ocp.ch3.genericsandcollections.streamapi.Person;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Stream;

public class SortedDemo {
    public static void main(String[] args) {
        //sorted() - позволяет сортировать значения либо в натуральном порядке, либо задавая Comparator

        //Stream<T> sorted();
        //Stream<T> sorted(Comparator<? super T> var1);
        //IntStream sorted();
        //LongStream sorted();
        //DoubleStream sorted();

        //простая сортировка
        Stream.of(9, 2, 5, 1, 3)
                .sorted()
                .forEach(System.out::print);
        System.out.println();

        Collection<Person> people = Arrays.asList(new Person("Jim", 22, 160),
                new Person("Sandy", 15,170),
                new Person("Jimmy", 20,200),
                new Person("Molly", 20, 180));

        //сортировка компаратором (по 1 полю)
        people.stream()
                .sorted(Comparator.comparing(Person::getAge))    //указывем Comparator или будет java.lang.ClassCastException
                .forEach(System.out::println);
        System.out.println();

        //сортировка компаратором (по 2 полям)
        people.stream()
                .sorted(Comparator.comparing(Person::getAge)    //указывем Comparator или будет java.lang.ClassCastException
                        .thenComparing(Person::getHeight))
                .forEach(System.out::println);


    }
}