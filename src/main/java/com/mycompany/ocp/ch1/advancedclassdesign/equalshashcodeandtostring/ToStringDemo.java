package com.mycompany.ocp.ch1.advancedclassdesign.equalshashcodeandtostring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToStringDemo {
    public static void main(String[] args) {
        System.out.println(new String[]{"Hello", "world"});  //[Ljava.lang.String;@6d6f6e28 (в массиве toString() не переопределен, поэтому мы получим что-то невразумительное)
        System.out.println(new ArrayList<>());      //[]  (в коллекциях наоборот, метод toString() переопределен и выводит элементы коллекции)
        System.out.println(Arrays.asList(1, "Hello", false));   //[1, Hello, false]  (в коллекциях наоборот, метод toString() переопределен и выводит элементы коллекции)
        System.out.println(new Cat("Kitty", 2));
    }
}

class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder sb = Stream
                .generate(() -> '\u2764')
                .limit(10)
                .collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append);
        String s = "\nCat {\n" +
                "\tname='" + name + '\'' +
                ", \n\tage=" + age +
                "\n" + '}' + '\n';
        return sb.toString() + s + sb.toString();
    }

    public static void main(String[] args) {
        Collections.singletonList(new Cat("Kitty", 2)).forEach(System.out::println);
        System.out.println(String.valueOf(new Cat("K", 2)));
    }
}