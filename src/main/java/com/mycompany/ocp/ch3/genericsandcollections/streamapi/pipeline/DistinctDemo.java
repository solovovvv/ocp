package com.mycompany.ocp.ch3.genericsandcollections.streamapi.pipeline;

import java.util.List;
import java.util.stream.Collectors;

public class DistinctDemo {
    public static void main(String[] args) {
        //distinct() - возвращает стрим без дубликатов (для метода equals)

        //Stream<T> distinct();
        //IntStream distinct();
        //LongStream distinct();
        //DoubleStream distinct();

        List.of(1, 2, 3, 1, 3, 7).stream()
                .distinct()
                .forEach(System.out::println);

        List<Integer> integers = List.of(1, 2, 3, 1, 3, 7).stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(integers);


    }
}
