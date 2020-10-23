package com.mycompany.ocp.ch1.advancedclassdesign.nestedclasses.staticnestedclasses;

public class Enclosing {
    static class Nested {
        private int price = 6;
    }

    public static void main(String[] args) {
        System.out.println(new Nested().price);     //странно, но напрямую обращение Nested.price будет ошибка компиляции
    }
}
