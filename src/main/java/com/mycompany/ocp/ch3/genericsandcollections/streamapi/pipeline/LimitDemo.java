package com.mycompany.ocp.ch3.genericsandcollections.streamapi.pipeline;

import java.util.Arrays;
import java.util.stream.Stream;

public class LimitDemo {
    public static void main(String[] args) {
        //limit() - позволяет ограничить выборку определенным количеством первых элементов

        //Stream<T> limit(long var1);
        //IntStream limit(long var1);
        //LongStream limit(long var1);
        //DoubleStream limit(long var1);

        Stream.generate(() -> "A1")
                .limit(5)
                .forEach(System.out::println);

        Stream.iterate(1, n -> n + 1)
                .limit(5)
                .forEach(System.out::println);

        Arrays.asList("Hello", "World").stream()
                .limit(1)
                .forEach(System.out::println);
    }
}
