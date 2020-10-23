package com.mycompany.ocp.ch2.designpatternsandprinciples.funcprogramming;

@FunctionalInterface
public interface Sprint {
    void sprint(Animal animal);
}

//это тоже функциональный интерфейс
@FunctionalInterface
interface Run extends Sprint {}

//это тоже функциональный интерфейс
@FunctionalInterface
interface SprintFaster extends Sprint {
    void sprint(Animal animal);
    String toString();
}

//это тоже функциональный интерфейс
@FunctionalInterface
interface Skip extends Sprint {
    default int getHopCount(Animal animal) {
        return 10;
    }
    static void skip(int speed) {}
}