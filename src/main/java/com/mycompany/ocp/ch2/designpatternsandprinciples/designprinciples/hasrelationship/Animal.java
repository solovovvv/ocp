package com.mycompany.ocp.ch2.designpatternsandprinciples.designprinciples.hasrelationship;

public class Animal {
}

//кошачьи
class Feline extends Animal {

}

class Cat extends Feline implements Pet {

}

class Tiger extends Feline {

}

class Dog extends Animal implements Pet {

}

//домашние животные
interface Pet {

}