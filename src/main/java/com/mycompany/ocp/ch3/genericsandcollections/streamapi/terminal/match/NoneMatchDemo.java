package com.mycompany.ocp.ch3.genericsandcollections.streamapi.terminal.match;

import java.util.Arrays;
import java.util.Collection;

public class NoneMatchDemo {

    public static void main(String[] args) {

        //noneMatch() - возвращает true, если условие не выполняется ни для одного элемента

        //boolean noneMatch(Predicate<? super T> var1);
        //boolean noneMatch(IntPredicate var1);
        //boolean noneMatch(LongPredicate var1);
        //boolean noneMatch(DoublePredicate var1);

        Collection<String> strings = Arrays.asList("Jim", "Jimmy", "Sandy", "Sam");
        boolean res = strings.stream()
                .noneMatch("Jim"::equals);
        System.out.println("noneMatch \"Jim\" is " + res);

    }
}
