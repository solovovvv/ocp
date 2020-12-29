package com.mycompany.ocp.ch3.genericsandcollections.collections;

import java.util.*;

public class CollectionsMethods {
    public static void main(String[] args) {
        //add()
        System.out.println("---add()");
        List<String> list = new ArrayList<>();
        System.out.println(list.add("Sparrow"));    //true
        System.out.println(list.add("Sparrow"));    //true

        Set<String> set = new HashSet<>();
        System.out.println(set.add("Sparrow")); //true
        System.out.println(set.add("Sparrow")); //false


        //remove()
        System.out.println("---remove()");
        List<String> birds = new ArrayList<>();
        birds.add("hawk");  //true
        System.out.println(birds.remove("cardinal"));   //false
        System.out.println(birds.remove("hawk"));   //true
        System.out.println(birds.size());

        //теперь немного посложнее по удалению объектов (hashCode() и equals())
        //это также относится и к add() (Set), contains()
        List<Bird> birdList = new ArrayList<>();
        birdList.add(new Bird("hawk"));
        birdList.remove(new Bird("hawk"));  //если не переопределен hashCode() и equals() объект не удалится!!! Если переопределен только equals() объект удалится!
        birdList.forEach(System.out::println);

        Set<Bird> birdSet = new HashSet<>();
        birdSet.add(new Bird("cardinal"));
        birdSet.remove(new Bird("cardinal"));  //если не переопределен hashCode() и equals() объект не удалится!!! Если переопределен только equals() объект не удалится! Нужно переопределить hashCode()!
        birdSet.forEach(System.out::println);


        //isEmpty() and size()
        System.out.println("---isEmpty() and size()");
        list = new ArrayList<>();
        System.out.println(list.isEmpty());     //true
        System.out.println(list.size());    //0

        //clear()
        System.out.println("---clear()");
        list.add("hawk");
        list.clear();
        System.out.println(list.size());    //0

        //contains()
        System.out.println("---contains()");
        birdList = new ArrayList<>();
        birdList.add(new Bird("hawk"));
        System.out.println(birdList.contains(new Bird("hawk")));

        /**
         * Table 3.7 Java Collections Framework types
         * ------------------------------------------------------------------------------------------
         * Type     Duplicate?      Ordered?        Keys and Values?    Add/remove in specific order?
         * ------------------------------------------------------------------------------------------
         * List     Yes             Yes (by index)  No                  No
         * Map      Yes (for values)No              Yes                 No
         * Queue    Yes             Yes (in order)  No                  Yes
         * Set      No              No              No                  No
         * ------------------------------------------------------------------------------------------
         *
         * Table 3.8 Collection attributes
         * ------------------------------------------------------------------------------------------
         * Type         JCF interface   Sorted?     hashCode()? compareTo()?    add null?
         * ------------------------------------------------------------------------------------------
         * ArrayList    List            No          No          No              Yes
         * ArrayDeque   Queue           No          No          No              No (because poll() use null)
         * HashMap      Map             No          Yes         No              No (keys No, values Yes)
         * HashSet      Set             No          Yes         No              Yes
         * HashTable    Map             No          Yes         No              No (no null keys and values)
         * LinkedList   List            No          No          No              Yes
         * Stack        List            No          No          No              Yes
         * TreeMap      Map             Yes         No          Yes             No (no null keys and compare)
         * TreeSet      Set             Yes         No          Yes             No (because compare)
         * Vector       List            No          No          No              Yes
         * ------------------------------------------------------------------------------------------
         *
         * Table 3.9 Choosing the right collection type
         * ------------------------------------------------------------------------------------------
         * Situation                        Answer (single best type)   Reason
         * ------------------------------------------------------------------------------------------
         * Взять верхнюю карту зоопарка     ArrayDeque                  LIFO, нужен стэк, который есть
         * из стопки карт                                               в типе Queue (Stack legacy).
         *
         * Продать билеты людям, стоящим
         * в очереди                        LinkedList                  FIFO, нужна очередь.
         *
         * Записать имена всех слонов,      ArrayList                   Поскольку есть дубликаты, нужен лист, а не сет.
         * чтобы вы могли рассказывать их                               Мы будет получать данные чаще, чем записывать,
         * трехлетнему ребенку каждый раз,                              поскольку трехлетний ребенок запрашивает снова и
         * когда он спрашивает (слоны не                                снова, делая ArrayList лучше, чем LinkedList.
         * имеют уникальных имен).                                      Vector и Stack не используеются в new code.
         *
         * Лист уникальных животных,                                    Поскольку уникальных, значит Set. Поскольку здесь
         * которых Вы хотите увидеть в Zoo HashSet                      нет сортировки (так было бы TreeSet) или помнить
         *                                                              порядок вставки, нужно использовать HashSet.
         *
         * Просмотр уникальных животных по  HashMap                     Если просмотр по ключу, нужен map. Поскольку
         * уникальному идентификатору                                   здесь нет порядка или сортировки нужен HashMap.
         *
         */
    }
}

class Bird {
    private String name;

    public Bird(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name: " + name;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof Bird)) return false;
//        Bird bird = (Bird) o;
//        return bird.name.equals(this.name);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bird bird = (Bird) o;
        return name.equals(bird.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}