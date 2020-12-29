package com.mycompany.ocp.ch3.genericsandcollections.collections;

import java.util.*;

public class SetMethods {
    public static void main(String[] args) {
        //Set - это набор, который не хранит дубликаты.

        //Реализации Set

        //HashSet хранит элементы в виде хэш-таблицы. Это означает, что используется hashCode() метод для получения
        //объектов более эффективно. Главная выгода хэш-таблицы в том, что добавление элементов (add()) и проверка есть ли
        //элемент в сете (contains()) оба имеют временную сложность constant time (O(1)). Обратная сторона медали -
        //мы теряем порядок (order), в котором добавляем элементы.

        //TreeSet хранит элементы отсортированными в tree структуре. Главная выгода в том, что набор всегда отсортирован.
        //Однако добавление и проверка есть ли элемент оба рассчитываются как O(log n).

        //Как работает метод hashCode() с HashSet показан в com.mycompany.ocp.ch1.advancedclassdesign.equalshashcodeandtostring.Hippo.java;

        Set<Integer> set1 = new HashSet<>();
        System.out.println(set1.add(66));   //true
        System.out.println(set1.add(10));   //trie
        System.out.println(set1.add(66));   //false
        System.out.println(set1.add(8));    //true
        System.out.print("HashSet() printing: ");
        set1.forEach(i -> System.out.print(i + ","));   //66,8,10,

        System.out.println();

        //TreeSet реализует специальный интерфейс NavigableSet. Этот интерфейс обеспечивает некоторые интересные методы.
        //Эти методы следующие: lower(), floor(), ceiling(), higher().
        Set<Integer> set2 = new TreeSet<>();
        System.out.println(set2.add(66));   //true
        System.out.println(set2.add(10));   //true
        System.out.println(set2.add(66));   //false
        System.out.println(set2.add(8));    //true
        System.out.print("TreeSet() printing: ");
        set2.forEach(i -> System.out.print(i + ","));   //8,10,66,

        System.out.println();

        //TreeSet реализован NavigableSet интерфейсом. Этот интерфейс обеспечивает интересные методы:
        NavigableSet<Integer> set3 = new TreeSet<>();
        for (int i = 7; i < 10; i++) {
            set3.add(i);
        }
        System.out.println(set3.lower(5));  //4 (наивысший элемент, который ниже 5)
        System.out.println(set3.floor(5));  //5 (floor = пол, наивысший элемент, который не выше 5, т.е. включает target элемент, если число больше макс. числа коллекции, вернет макс. число)
        System.out.println(set3.ceiling(5));    //5 (ceiling=потолок, наименьший элемент, который выше, чем 5)
        System.out.println(set3.higher(9)); //null (наименьший элемент, который выше, чем 5, если число меньше мин. числа коллекции, вернет мин. число)

    }
}