package com.mycompany.ocp.ch3.genericsandcollections.streamapi.pipeline;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FilterDemo {

    public static void main(String[] args) {
        //filter() - отфильтровывает записи, возвращает только записи, соответствующие условию

        //Stream<T> filter(Predicate<? super T> var1);
        //IntStream filter(IntPredicate var1);
        //LongStream filter(LongPredicate var1);
        //DoubleStream filter(DoublePredicate var1);

        //отфильтровать, и посчитать сколько элементов осталось
        long res = IntStream.of(4, -1, 3, -7).filter(i -> i > 1).count();
        System.out.println("res: " + res);

        //отфильтровать и вывести на консоль
        Arrays.stream(new int[]{5, 2, 8})
                .filter(ints -> ints > 2)
                .forEach(System.out::println);


    }

}
