package com.mycompany.ocp.ch3.genericsandcollections.streamapi.pipeline;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class FlatMapDemo {
    public static void main(String[] args) {
        //flatMap - похоже на map, но может создавать из одного элемента несколько

        //<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> var1);
        //IntStream flatMapToInt(Function<? super T, ? extends IntStream> var1);
        //LongStream flatMapToLong(Function<? super T, ? extends LongStream> var1);
        //DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> var1);
        //IntStream flatMap(IntFunction<? extends IntStream> var1);
        //LongStream flatMap(LongFunction<? extends LongStream> var1);
        //DoubleStream flatMap(DoubleFunction<? extends DoubleStream> var1);

        Collection<String> integers = Arrays.asList("Hello", "World", "From", "Java", "!!!");
        String[] strings = integers.stream()
                .flatMap(s -> Arrays.stream(s.split(","))).toArray(String[]::new);  //коллекцию в массив
        System.out.println(Arrays.toString(strings));


    }
}
