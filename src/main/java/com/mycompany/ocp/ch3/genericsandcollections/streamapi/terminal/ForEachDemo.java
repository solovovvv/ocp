package com.mycompany.ocp.ch3.genericsandcollections.streamapi.terminal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ForEachDemo {
    public static void main(String[] args) {
        //forEach() - применяет функцию к каждому объекту стрима, порядок при параллельном выполнении не гарантируется

        //void forEach(Consumer<? super T> var1);
        //void forEach(IntConsumer var1);
        //void forEach(LongConsumer var1);
        //void forEach(DoubleConsumer var1);

        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>(Arrays.asList("One", "Two", "Three"));
        set.stream()
                .forEach(s -> sb.append(s.concat("!")));
        System.out.println(sb);


    }
}
