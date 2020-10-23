package com.mycompany.ocp.ch1.advancedclassdesign.vmmethodinvocation;

import java.util.Arrays;

abstract public class Animal {
    abstract void feed();
}

class Cow extends Animal {
    void feed() {addHay();}
    private void addHay() {}
}

class Bird extends Animal {
    void feed() {addSeed();}
    private void addSeed() {}
}

class Lion extends Animal {
    void feed() {addMeat();}
    private void addMeat() {}
}

class Test {
    private static void feedAnimal(Animal animal) {
        animal.feed();
    }

    public static void main(String[] args) {
        Animal[] animals = {new Cow(), new Bird(), new Lion()};
        Arrays.stream(animals).forEach(Animal::feed);
        Arrays.stream(animals).forEach(Test::feedAnimal);
    }

}