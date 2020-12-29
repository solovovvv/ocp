package com.mycompany.ocp.ch3.genericsandcollections;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericBounds {

    //Unbounded Wildcards <?> (работает только на чтение)
    //без даймонда или <?> (любой тип) так мы укажем, что можно использовать любой тип,
    //но изменить не сможем без указания <? super ___>
    private static void printList(List<?> list) {      //если указать List<Object>, то только Object можно будет хранить, поэтому лучше без типа или <?>
        for (Object o : list) {
            System.out.println(o);
        }
        //list.forEach(System.out::println);    //java 8
    }

    //Upper-Bounded Wildcards <? extends _______> (работает только на чтение)
    //если просто указать List или List<?>, то можно будет добавить любой объект, мы можем ограничить тип в даймонде
    private static long total(List<? extends Number> list) {    //все потомки от Number, включая Number
        long count = 0;
        for (Number n : list) {
            count += n.longValue();
        }
        return count;
    }

    private static void print(List<? extends Bird> list) {
        list.forEach(System.out::println);
    }

    //Lower-Bounded Wildcards <? super _______> (работает и на чтение, и на запись)
    //если указать без границ <?> или <? extends String> или <? extends Object> будет ошибка компиляции, для изменения
    //данных в коллекции надо использовать lower bound (<? super ___>)
    private static void addSound(List<? super String> list) {   //суперкласс от String (включая String)
        list.add("quack");
    }

    private static void add(List<? super Sparrow> list) {
        list.add(new Sparrow());
        list.forEach(System.out::println);
    }

    private static void addAnimal(List<? super Animal> list) {
        list.add(new Cat());
        list.add(new Dog());
        list.forEach(System.out::println);
    }

    public static void main(String[] args) {
        //Unbounded Wildcards <?>
        List<String> keywords = new ArrayList<>();
        keywords.add("java");
        printList(keywords);

        //Upper-Bounded Wildcards <? extends _______>
        List<Integer> integers = Arrays.asList(1, 3, 2);
        System.out.println(total(integers));
        List<Number> numbers = new ArrayList<>();
        System.out.println(total(numbers));

        List<Bird> birds = Arrays.asList(new Bird(), new Sparrow());
        print(birds);

        //Lower-Bounded Wildcards <? super _______>
        //напишем метод, который добавляет string "quack" в 2 листа:
        List<String> strings = new ArrayList<>();
        addSound(strings);
        List<Object> objects = new ArrayList<>();
        addSound(objects);

        //для изменения коллекции надо использовать lower bound <? super _______>
        List<? super String> list = new ArrayList<>();
        list.add("d");

        List<Bird> birds1 = new ArrayList<>();
        List<Sparrow> sparrows = new ArrayList<>();
        add(birds1);
        add(sparrows);

        List<Animal> animals = new ArrayList<>();
        addAnimal(animals);

        List<? super IOException> exceptions = new ArrayList<>();   //мы не сможем добавить new Exception()
        exceptions.add(new IOException());
        exceptions.add(new FileNotFoundException());

    }

    static class Bird {}
    static class Sparrow extends Bird {}

    abstract static class Animal {}
    static class Dog extends Animal {}
    static class Cat extends Animal {}

}

