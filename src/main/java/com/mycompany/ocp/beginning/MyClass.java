package com.mycompany.ocp.beginning;

import java.util.Arrays;
import java.util.List;

public class MyClass {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("John", "Mayer", "Eric", "Clapton");

        list.stream()
                .map(s -> s.length())
                .forEach(i -> System.out.println(i));

        list.stream()
                .map(String::length)
                .forEach(System.out::println);
    }
}
