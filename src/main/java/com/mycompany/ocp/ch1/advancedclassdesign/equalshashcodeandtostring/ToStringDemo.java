package com.mycompany.ocp.ch1.advancedclassdesign.equalshashcodeandtostring;

import java.util.ArrayList;
import java.util.Arrays;

public class ToStringDemo {
    public static void main(String[] args) {
        System.out.println(new String[]{"Hello","world"});  //[Ljava.lang.String;@6d6f6e28 (в массиве toString() не переопределен, поэтому мы получим что-то невразумительное)
        System.out.println(new ArrayList<>());      //[]  (в коллекциях наоборот, метод toString() переопределен и выводит элементы коллекции)
        System.out.println(Arrays.asList(1, "Hello", false));   //[1, Hello, false]  (в коллекциях наоборот, метод toString() переопределен и выводит элементы коллекции)
    }
}
