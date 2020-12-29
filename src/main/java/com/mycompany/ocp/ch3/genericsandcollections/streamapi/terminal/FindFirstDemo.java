package com.mycompany.ocp.ch3.genericsandcollections.streamapi.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class FindFirstDemo {
    public static void main(String[] args) {
        //findFirst() - возвращает первый элемент из стрима (возвращает Optional)

        //Optional<T> findFirst();
        //OptionalInt findFirst();
        //OptionalLong findFirst();
        //OptionalDouble findFirst();

        OptionalInt optionalInt = Arrays.stream(new int[]{1, 2, 3, 4, 5})
                .findFirst();
        System.out.println(optionalInt.getAsInt());

        int firstInt = Arrays.stream(new int[]{1, 2, 3, 4, 5})
                .findFirst().orElse(5);
        System.out.println(firstInt);


        Optional<Integer> optional = List.of(1, 2, 3, 4).stream()
                .findFirst();
        optional.ifPresent(System.out::println);

        int num = List.of(1, 2, 3, 4).stream()
                .findFirst().orElse(5);
        System.out.println(num);


    }
}
