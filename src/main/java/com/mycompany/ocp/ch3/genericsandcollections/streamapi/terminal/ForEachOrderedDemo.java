package com.mycompany.ocp.ch3.genericsandcollections.streamapi.terminal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ForEachOrderedDemo {
    public static void main(String[] args) {
        //forEachOrdered() - применяет функцию к каждому объекту стрима, сохранение порядка элементов гарантирует

        //void forEachOrdered(Consumer<? super T> var1);
        //void forEachOrdered(IntConsumer var1);
        //void forEachOrdered(LongConsumer var1);
        //void forEachOrdered(DoubleConsumer var1);

        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>(Arrays.asList("One", "Two", "Three"));
        set.stream()
                .forEach(s -> sb.append(s.concat("!")));
        System.out.println(sb);


    }
}
