package com.mycompany.ocp.ch3.genericsandcollections;

import java.util.ArrayList;
import java.util.List;

public class WrapperClassesAndAutoboxing {
    public static void main(String[] args) {
        //если используется лист с типом Integer, удаление, указав примитив, будет по объекту!!!
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1); //autoboxing
        numbers.add(new Integer(3));
        numbers.add(new Integer(5));
        numbers.remove(1);      //JVM принимает примитив как индекс и удаляет индекс 1, т.е. ссылку на объект 3
        numbers.remove(new Integer(5));     //JVM принимает это как объект и удаляет объект, т.е. ссылку на 5
        System.out.println(numbers);    //остается в коллекции [1]
        //ИНДЕКС ВОЗВРАЩАЕТ ОБЪЕКТ, ОБЪЕКТ ВОЗВРАЩАЕТ BOOLEAN (это надо запомнить)

        //если используется лист с типом Character, удаление, указав примитив, как почти везде, будет по индексу листа
        List<Character> characters = new ArrayList<>();
        characters.add('1');    //autoboxing
        characters.add('2');    //autoboxing
        characters.add('3');    //autoboxing
        characters.remove(1);   //будет удален '2' (по индексу)
        characters.remove(new Character('3'));  //а так будет удален объект '3'
        System.out.println(characters); //останется [1]

    }
}
