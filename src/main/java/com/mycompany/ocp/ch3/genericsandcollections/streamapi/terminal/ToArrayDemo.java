package com.mycompany.ocp.ch3.genericsandcollections.streamapi.terminal;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ToArrayDemo {
    public static void main(String[] args) {
        //toArray() - возвращает массив значений стрима

        //Object[] toArray();
        //int[] toArray();
        //long[] toArray();
        //double[] toArray();

        Collection<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Object[] objects = integers.stream()
                .toArray();
        Arrays.stream(objects)
                .forEach(System.out::print);
        System.out.println();

        int[] ints = IntStream.of(1, 2, 3)
                .toArray();
        Arrays.stream(ints)
                .forEach(System.out::print);

    }
}
