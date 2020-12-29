package com.mycompany.ocp.ch3.genericsandcollections.streamapi.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class FindAnyDemo {
    public static void main(String[] args) {
        //findAny() - возвращает любой подходящий элемент из стрима (возвращает Optional)
        
        //Optional<T> findAny();
        //OptionalInt findAny();
        //OptionalLong findAny();
        //OptionalDouble findAny();

        OptionalInt firstInt = Arrays.stream(new int[]{1, 2, 3, 4, 5})
                .findAny();
        System.out.println(firstInt.getAsInt());

        Optional<Integer> optional = List.of(1, 2, 3, 4).stream()
                .findAny();
        optional.ifPresent(System.out::println);

        int num = Arrays.stream(new int[]{1, 2, 3, 4, 5})
                .findAny().orElse(5);
        System.out.println(num);

    }
}
