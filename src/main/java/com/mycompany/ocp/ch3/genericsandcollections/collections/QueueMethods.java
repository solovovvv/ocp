package com.mycompany.ocp.ch3.genericsandcollections.collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueMethods {
    public static void main(String[] args) {
        //Queue - очередь.
        //FIFO (First-In, First-Out) и LIFO (Last-In, First-Out)
        //Пример: queue - очередь людей (зашел первый - вышел первый), stack - тарелки в раковине (кладешь последнюю - достаешь первую)

        //Queue реализации

        //Мы видели LinkedList, в добавлении к List, это есть двусторонняя очередь. Разница с обычной queue в том, что
        //что может вставлять и удалять элементы из начала и конца очереди. Главная выгода LinkedList в том, что он
        //реализовывает и List, и Queue интерфейсы. Обратная сторона медали в том, что LinkedList не "чистокровная"
        //очередь.

        //ArrayDeque - "чистокровная" двунаправленная очередь. Это было добавлено в JDK6 и хранит элементы в изменяемом
        //массиве. Главная выгода ArrayDeque в более эффективности, чем LinkedList. Deque полагается быть объявленным
        //"deck", но многие люди, включая автора книги говорят это неправильно как "d-queue".

        Queue<Integer> queue = new ArrayDeque<>();
        System.out.println(queue.offer(10));    //true положить
        System.out.println(queue.offer(4));    //true положить
        System.out.println(queue.peek());   //10 получить первый элемент
        System.out.println(queue.poll());   //10 вытащить
        System.out.println(queue.poll());   //4 вытащить
        queue.forEach(i -> System.out.print(i + ","));  //[]
        System.out.println();
        System.out.println(queue.add(10));  //true добавить элемент назад в очередь
        System.out.println(queue.add(20));  //true добавить элемент назад в очередь
        queue.forEach(i -> System.out.print(i + ","));  //10,20
        System.out.println();
        System.out.println(queue.element());    //10 получить первый элемент
        System.out.println(queue.peek());   //10 получить первый элемент
        System.out.println(queue.remove()); //10 удалить первый элемент
        queue.forEach(i -> System.out.print(i + ","));  //20
        System.out.println();

        //пример на ArrayDeque (методов больше, чем в интерфейсе Queue)
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(4);
        System.out.println(stack.peek());   //4 получить первый
        System.out.println(stack.poll());   //4 вытащить
        System.out.println(stack.poll());   //10 вытащить

    }
}
