package com.mycompany.ocp.ch3.genericsandcollections.streamapi.terminal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectDemo {

    public static void main(String[] args) {
        //Большинство операций класса Stream, которые модифицируют набор данных, возвращают этот набор в виде потока.
        // Однако бывают ситуации, когда хотелось бы получить данные не в виде потока, а в виде обычной коллекции,
        // например, ArrayList или HashSet. И для этого у класса Stream определен метод collect.

        //<R> R collect(Supplier<R> var1, BiConsumer<R, ? super T> var2, BiConsumer<R, R> var3);
        //<R, A> R collect(Collector<? super T, A, R> var1);
        //<R> R collect(Supplier<R> var1, ObjIntConsumer<R> var2, BiConsumer<R, R> var3);
        //<R> R collect(Supplier<R> var1, ObjLongConsumer<R> var2, BiConsumer<R, R> var3);
        //<R> R collect(Supplier<R> var1, ObjDoubleConsumer<R> var2, BiConsumer<R, R> var3);

        List<Integer> list = new ArrayList<>(Arrays.asList(4, 4));
        Collections.addAll(list, 3, 2, 5, 3);

        //отфильтровать и вывести в новый List
        List<Integer> list1 = list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        System.out.println("List: " + list1);

        //отфильтровать и вывести в новый Set
        Set<Integer> set = list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
        System.out.println("Set: " + set);

        //вывести в Map
        Stream<Person> stream = Stream.of(new Person("Jim", 4, false),
                new Person("Sandy", 14, false));
        Map<String, Integer> map = stream.collect(Collectors.toMap(Person::getName, Person::getAge));
        System.out.println(map);

        //Collectors.toCollection
        //вывести конкретно в новый HashSet (реализацию Set)
        Set<Integer> set1 = list.stream().collect(Collectors.toCollection(HashSet::new));
        System.out.println("HashSet: " + set1);

        //вывести конкретно в новый ArrayList (реализацию List)
        List<Integer> list2 = list.stream().collect(Collectors.toCollection(ArrayList::new));

        //Вторая форма метода collect имеет три параметра:
        //supplier: создает объект коллекции
        //accumulator: добавляет элемент в коллекцию
        //combiner: бинарная функция, которая объединяет два объекта
        List<Integer> list3 = list.stream().filter(Objects::nonNull).collect(() -> new ArrayList<>(),    //создаем ArrayList
                (lst, item) -> lst.add(item),  //добавляем в список элемент
                (lst1, lst2) -> lst1.addAll(lst2));     //добавляем в список другой список
        System.out.println(list3);

        //то же самое, заменим лямбды на ссылки на методы
        List<Integer> list4 = list.stream().collect(ArrayList::new, //создаем ArrayList
                (lst, item) -> lst.add(item),  //добавляем в список элемент
                ArrayList::addAll);     //добавляем в список другой список
        System.out.println(list4);

        //поиск дубликатов
        Map<Integer, Integer> map1 = list.stream().collect(HashMap::new,
                (mp, value) -> mp.merge(value, 1, Integer::sum),
                HashMap::putAll);
        System.out.println(map1);

        //поиск дубликатов
        Collection<Integer> integers = Arrays.asList(1, 3, 5, 1, 7, 3, 7);
        Map<Integer, List<Integer>> integerMap = integers.stream()
                .collect(Collectors.groupingBy(Integer::intValue));
        integerMap.forEach((k, v) -> System.out.println(k + " " + v));

        //поиск дубликатов возраста
        Collection<Person> persons = Arrays.asList(new Person("Jim", 10, false),
                new Person("John", 20, true),
                new Person("Sandy", 22, true));
        Map<Integer, List<Person>> map2 = persons.stream()
                .collect(Collectors.groupingBy(Person::getAge));
        map2.forEach((i, p) -> System.out.println(i + " " + p));

        //поиск дубликатов студент (true/false)
        Map<Boolean, List<Person>> map3 = persons.stream()
                .collect(Collectors.partitioningBy(Person::isStudent));
        map3.forEach((i, p) -> System.out.println(i + " " + p));

    }

    @Data
    @AllArgsConstructor
    @ToString
    private static class Person {
        private String name;
        private int age;
        private boolean isStudent;
    }

}