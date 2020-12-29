package com.mycompany.ocp.ch3.genericsandcollections.streamapi.terminal;

import java.util.Arrays;

public class CountDemo {
    public static void main(String[] args) {
        //count() - возвращает количество элементов в стриме

        //long count();

        int count = (int) Arrays.stream(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
                .count();
        System.out.println(count);

    }
}
