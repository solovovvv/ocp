package com.mycompany.ocp.ch3.genericsandcollections.streamapi.pipeline;

import java.util.stream.Stream;

public class SkipDemo {
    public static void main(String[] args) {
        //skip() - позволяет пропустить N первых элементов

        //Stream<T> skip(long var1);
        //IntStream skip(long var1);
        //LongStream skip(long var1);
        //DoubleStream skip(long var1);

        Stream.of(2, 5, 1, 9, 2)
                .skip(2)
                .forEach(System.out::println);


    }
}
