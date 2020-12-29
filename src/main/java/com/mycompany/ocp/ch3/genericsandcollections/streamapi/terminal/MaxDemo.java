package com.mycompany.ocp.ch3.genericsandcollections.streamapi.terminal;

import com.mycompany.ocp.ch3.genericsandcollections.streamapi.Person;

import java.util.*;

public class MaxDemo {
    public static void main(String[] args) {
        //min() - возвращает максимальный элемент, в качестве условия использует компаратор

        //Optional<T> max(Comparator<? super T> var1);
        //OptionalInt max();
        //OptionalLong min();
        //OptionalDouble min();

        Set<Integer> set = new HashSet<>(Arrays.asList(4, 1, 2, 3));
        Optional<Integer> maxOptional = set.stream()
                .max(Integer::compareTo);
        maxOptional.ifPresent(System.out::println);

        Collection<Person> people = Arrays.asList(new Person("Jim", 22, 160),
                new Person("Sandy", 15,170),
                new Person("Jimmy", 20,200),
                new Person("Molly", 20, 180));

        Optional<Person> optionalPerson=people.stream()
                .max(Comparator.comparing(Person::getAge));
        optionalPerson.ifPresent(System.out::println);

    }
}