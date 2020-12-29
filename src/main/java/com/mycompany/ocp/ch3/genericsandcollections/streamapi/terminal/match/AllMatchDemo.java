package com.mycompany.ocp.ch3.genericsandcollections.streamapi.terminal.match;

import java.util.Arrays;
import java.util.Collection;

public class AllMatchDemo {

    public static void main(String[] args) {

        //allMatch() - Возвращает true, если условие выполняется для всех элементов

        //boolean allMatch(Predicate<? super T> var1);
        //boolean allMatch(IntPredicate var1);
        //boolean allMatch(LongPredicate var1);
        //boolean allMatch(DoublePredicate var1);

        Collection<String> strings = Arrays.asList("Jim", "Jim1");
        boolean res = strings.stream()
                .allMatch("Jim"::contains);
        System.out.println("allMatch \"Jim\" is " + res);
        System.out.println("Jim".contains("Ji"));
    }
}
