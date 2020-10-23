package com.mycompany.ocp.ch2.designpatternsandprinciples.designprinciples.isrelationship;

public class Penguin {
    private final Flippers flippers;
    private final WebbedFeet webbedFeet;

    public Penguin() {
        flippers = new Flippers();
        webbedFeet = new WebbedFeet();
    }

    public void flap() {
        flippers.flap();
    }

    public void kick() {
        webbedFeet.kick();
    }

    public static void main(String[] args) {
        Penguin penguin = new Penguin();
        penguin.flap();
        penguin.kick();
    }

}

//ласты
class Flippers {
    public void flap() {
        System.out.println("The flippers flap back and forth");
    }
}

//перепончатые лапы
class WebbedFeet {
    public void kick() {
        System.out.println("The webbed feet kick to and fro");
    }
}