package com.mycompany.ocp.ch2.designpatternsandprinciples.polymorphism;

public class Lemur extends Primate implements HasTail {
    public int age = 10;

    @Override
    public boolean isTailStriped() {
        return false;
    }

    public static void main(String[] args) {
        Lemur lemur = new Lemur();
        Primate primate = lemur;
        HasTail hasTail = lemur;
        System.out.println(primate.hasHair());
        System.out.println(hasTail.isTailStriped());
        lemur = (Lemur) hasTail;
        System.out.println(lemur.age);

        Primate primate1 = new Primate();
        lemur = (Lemur) primate1;   //так мы получим ClassCastException
    }

}

class Primate {
    public boolean hasHair() {
        return true;
    }
}

interface HasTail {
    boolean isTailStriped();
}