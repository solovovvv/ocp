package com.mycompany.ocp.ch2.designpatternsandprinciples.designprinciples.isrelationship;

//клюв
public class Beak {
    private String color;
    private double length;
}

class RightFoot {

}

class LeftFoot {

}

class Bird {
    private Beak beak;
    private RightFoot rightFoot;
    private LeftFoot leftFoot;
}