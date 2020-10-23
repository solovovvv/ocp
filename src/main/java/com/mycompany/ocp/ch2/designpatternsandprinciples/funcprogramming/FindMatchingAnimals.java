package com.mycompany.ocp.ch2.designpatternsandprinciples.funcprogramming;

public class FindMatchingAnimals {
    private static void print(Animal animal, CheckTrait checkTrait) {
        if (checkTrait.test(animal))
            System.out.println(animal);
    }

    public static void main(String[] args) {
        Animal animal1 = new Animal("fish", false, true);
        print(animal1, a -> a.isCanSwim());      //lambda
        print(animal1, Animal::isCanSwim);   //ref
        Animal animal2 = new Animal("kangaroo", true, false);
        print(animal2, a -> a.isCanSwim());      //lambda
        print(animal2, Animal::isCanSwim);   //ref

    }
}
