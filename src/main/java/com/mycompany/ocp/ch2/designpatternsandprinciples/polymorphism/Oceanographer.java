package com.mycompany.ocp.ch2.designpatternsandprinciples.polymorphism;

public class Oceanographer {
    private void checkSound(LiveInOcean animal) {
        animal.makeSound();
    }

    public static void main(String[] args) {
        Oceanographer o = new Oceanographer();
        o.checkSound(new Dolphin());
        o.checkSound(new Whale());
        o.checkSound(() -> System.out.println("HI!"));  //lambda
    }
}

interface LiveInOcean {
    void makeSound();
}

class Dolphin implements LiveInOcean {
    public void makeSound() {
        System.out.println("whistle");
    }
}

class Whale implements LiveInOcean {
    public void makeSound() {
        System.out.println("sing");
    }
}