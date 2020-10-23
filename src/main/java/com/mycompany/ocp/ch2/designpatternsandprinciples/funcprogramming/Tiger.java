package com.mycompany.ocp.ch2.designpatternsandprinciples.funcprogramming;

public class Tiger implements Sprint {

    @Override
    public void sprint(Animal animal) {
        System.out.println("Animal is sprinting fast! " + animal.toString());
    }

}
