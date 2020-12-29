package com.mycompany.ocp.ch3.genericsandcollections.streamapi.terminal.match;

import java.util.Arrays;
import java.util.Collection;

public class AnyMatchDemo {

    public static void main(String[] args) {

        //anyMatch() - возвращает true, если условие выполняется хотя бы для одного элемента

        //boolean anyMatch(Predicate<? super T> var1);
        //boolean anyMatch(IntPredicate var1);
        //boolean anyMatch(LongPredicate var1);
        //boolean anyMatch(DoublePredicate var1);

        Collection<String> strings = Arrays.asList("Jim", "Jimmy", "Sandy", "Sam");
        boolean res = strings.stream()
                .anyMatch("Jim"::equals);
        System.out.println("anyMatch \"Jim\" is " + res);

    }
}
