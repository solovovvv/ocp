package com.mycompany.ocp.ch3.genericsandcollections.collections;

import java.util.*;

public class Duplicate {

    public static Map<Integer, Integer> findDuplicates(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        Collections.sort(list);     //при сортировке надо сначала отсортировать данные
        int count = 0;

        for (int i : list) {
            if (map.size() == 0) {      //если пустой map
                map.put(i, 1);      //добавляем первый элемент
            } else {    //если непустой map
                if (map.get(i) != null) {   //если объект есть в map
                    count = map.get(i);     //получаем объект-счетчик
                    map.put(i, ++count);    //добавляем (на самом деле перетираем) и инкрементируем счетчик
                } else {    //если объекта нет в map
                    map.put(i, 1);  //добавляем в map
                }
            }
        }

//        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
//        for (Map.Entry<Integer, Integer> m : set) {
//            System.out.println(m.getKey() + " " + m.getValue());
//        }
        return map;
    }

    //java 8
    public static void findDuplicates2(List<Integer> list) {

    }

    public static void print(List<?> list) {
        System.out.println("List printing:");
        list.forEach(o -> System.out.print(o + " "));
        System.out.println();
    }

    public static void print(Map<?, ?> map) {
        System.out.println("Map printing:");
        map.forEach((k, v) -> System.out.println(k + " " + v));
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 5, 3, 7, 3, 7);
        print(list);
        Map<Integer, Integer> map = findDuplicates(list);
        print(map);
    }

}
