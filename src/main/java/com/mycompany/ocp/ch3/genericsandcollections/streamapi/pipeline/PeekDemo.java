package com.mycompany.ocp.ch3.genericsandcollections.streamapi.pipeline;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PeekDemo {
    public static void main(String[] args) {
        //peek() - возвращает тот же стрим, но применяет функцию к каждому элементу стрима

        //Stream<T> peek(Consumer<? super T> var1);
        //IntStream peek(IntConsumer var1);
        //LongStream peek(LongConsumer var1);
        //DoubleStream peek(DoubleConsumer var1);

        Collection<String> strings = Arrays.asList("Hello", "From");
        List<String> list = strings.stream()
                .peek(System.out::println)
                .collect(Collectors.toList());  //вернем лист без вывода на консоль, но peek() выведет на консоль каждый элемент
    }
}
