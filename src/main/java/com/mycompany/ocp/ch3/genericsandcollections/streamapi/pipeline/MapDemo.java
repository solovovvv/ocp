package com.mycompany.ocp.ch3.genericsandcollections.streamapi.pipeline;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MapDemo {
    public static void main(String[] args) {
        //map() - Преобразует каждый элемент стрима
        //mapToInt(), mapToDouble(), mapToLong() - аналог map, но возвращает числовой стрим (то есть стрим из числовых примитивов)
        //как мы знаем от BaseStream наследуются 4 стрима: Stream<T>, IntStream, DoubleStream, LongStream

        //<R> Stream<R> map(Function<? super T, ? extends R> var1);
        //IntStream mapToInt(ToIntFunction<? super T> var1);
        //LongStream mapToLong(ToLongFunction<? super T> var1);
        //DoubleStream mapToDouble(ToDoubleFunction<? super T> var1);

        //IntStream map(IntUnaryOperator var1);
        //<U> Stream<U> mapToObj(IntFunction<? extends U> var1);
        //LongStream mapToLong(IntToLongFunction var1);
        //DoubleStream mapToDouble(IntToDoubleFunction var1);

        //LongStream map(LongUnaryOperator var1);
        //<U> Stream<U> mapToObj(LongFunction<? extends U> var1);
        //IntStream mapToInt(LongToIntFunction var1);
        //DoubleStream mapToDouble(LongToDoubleFunction var1);

        //DoubleStream map(DoubleUnaryOperator var1);
        //<U> Stream<U> mapToObj(DoubleFunction<? extends U> var1);
        //IntStream mapToInt(DoubleToIntFunction var1);
        //LongStream mapToLong(DoubleToLongFunction var1);

        Collection<String> strings = List.of("Hello", "World", "From", "Java");
        strings.stream()
                .map(s -> s.concat("1"))
                .forEach(System.out::println);

        //IntStream to DoubleStream
        Arrays.stream(new int[]{1, 2, 3, 4, 5})
                .mapToDouble(i -> i)
                .forEach(System.out::print);
        System.out.println();

        //Stream to IntStream
        Collection<Integer> integers = Arrays.asList(1, 2, 3, 4);
        integers.stream()
                .mapToInt(integer -> integer)
                .forEach(System.out::print);
        System.out.println();

        //Stream to LongStream
        integers.stream()
                .mapToLong(integer -> integer)
                .forEach(System.out::print);
        System.out.println();

    }
}
