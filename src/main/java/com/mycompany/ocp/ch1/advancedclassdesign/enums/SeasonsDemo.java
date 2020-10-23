package com.mycompany.ocp.ch1.advancedclassdesign.enums;

public class SeasonsDemo {
    public static void main(String[] args) {
        Seasons s = Seasons.FALL;
        System.out.println(s);      //FALL
        System.out.println(s == Seasons.FALL);  //true

        //массив из enum (с порядком)
        Seasons[] seasons = Seasons.values();
        for (Seasons s1 : seasons) {
            System.out.println(s1.name() + " " + s1.ordinal());
        }

        //создание enum из String
        Colors s1 = Colors.valueOf("RED");  //значене должно быть в enum или будет ошибка java.lang.IllegalArgumentException: No enum constant
        Colors s2 = Colors.valueOf("BLUE"); //значене должно быть в enum или будет ошибка java.lang.IllegalArgumentException: No enum constant

        Colors[] colors = {s1, s2};
        for (Colors c : colors) {
            System.out.println(c.name() + " " + c.ordinal());
        }

        //enum и switch statement
        Seasons seasons1 = Seasons.FALL;
        switch (seasons1) {
            case WINTER:
                System.out.println("Winter!!");
                break;
            case SUMMER:
                System.out.println("Summer!!");
                break;
            default:
                System.out.println("Other season");
        }


    }
}

enum Colors {
    RED, BLUE,
}