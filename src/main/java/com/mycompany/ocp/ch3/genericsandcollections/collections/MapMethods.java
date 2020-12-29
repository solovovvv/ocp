package com.mycompany.ocp.ch3.genericsandcollections.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapMethods {
    public static void main(String[] args) {
        //Мы используем map, когда хотим идентифицировать значение по ключу (например, телефонный справочник ИМЯ:ТЕЛЕФОН)

        //Map реализации

        //HashMap хранит ключи в хэш-таблице. Это означает, что используется hashCode(). Главная выгода добавления и
        //получения элементов по ключу имеет constant time (O(1)). Обратная сторона медали в том, что мы теряем порядок
        //вставленных элементов.

        //LinkedHashMap - ключи добавляются и хранятся согласно очереди (queue).

        //TreeMap хранит ключи отсортированные. Главная выгода в том, что ключи всегда отсортированы. Обратная сторона
        //медали в том, что добавление и проверка если ключ существует имеет O(log n).

        //HashTable как и Vector реально старые и потокобезопасные. Если сравнивать со старой школой по аналогии
        // ArrayList есть Vector, HashMap есть HashTable.

        //Map не наследуется от Collection!!! Соответственно, здесь другие методы.

        Map<String, String> map1 = new HashMap<>();
        map1.put("koala", "bamboo");
        map1.put("lion", "meat");
        map1.put("giraffe", "leaf");
        System.out.println(map1.get("lion"));    //meat
        map1.forEach((k, v) -> System.out.print(k + ":" + v + ","));    //koala:bamboo,giraffe:leaf,lion:meat,
        System.out.println();

        Map<String, String> map2 = new TreeMap<>();
        map2.put("koala", "bamboo");
        map2.put("lion", "meat");
        map2.put("giraffe", "leaf");
        System.out.println(map2.get("lion"));    //meat
        map2.forEach((k, v) -> System.out.print(k + ":" + v + ","));    //giraffe:leaf,koala:bamboo,lion:meat,
        System.out.println();

        Map<String, String> map3 = new LinkedHashMap<>();
        map3.put("koala", "bamboo");
        map3.put("lion", "meat");
        map3.put("giraffe", "leaf");
        System.out.println(map3.get("lion"));    //meat
        map3.forEach((k, v) -> System.out.print(k + ":" + v + ","));    //koala:bamboo,lion:meat,giraffe:leaf,
        System.out.println();

        System.out.println(map1.containsKey("lion"));   //true
        System.out.println(map1.containsValue("bamboo"));   //true
        System.out.println(map1.size());    //3

    }
}
