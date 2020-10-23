package com.mycompany.ocp.ch2.designpatternsandprinciples.designpatterns.factory;

/**
 * Проблема: как написать код, создаюющем объекты, где точный тип объекта неизвестен до рантайма?
 *
 * Решение: factory pattern, иногда называют factory method pattern - это creational pattern, сфокусированный на
 * поддержке класса полиморфизмом. Factory pattern часто, хотя не всегда, использует static method, возвращающий объекты.
 * Также хорошая практика после класса называть Factory, например, класс Animal называем метод AnimalFactory.
 *
 */
public abstract class Food {
    private int quantity;

    public Food(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract void consumed();

}

class Hay extends Food {

    public Hay(int quantity) {
        super(quantity);
    }

    public void consumed() {
        System.out.println("Hay eaten: " + getQuantity());
    }

}

class Pellets extends Food {

    public Pellets(int quantity) {
        super(quantity);
    }

    public void consumed() {
        System.out.println("Pellets eaten: " + getQuantity());
    }

}

class Fish extends Food {

    public Fish(int quantity) {
        super(quantity);
    }

    public void consumed() {
        System.out.println("Fish eaten: " + getQuantity());
    }

}

class FoodFactory {
    public static Food getFood(String animalName) {
        switch (animalName) {
            case "zebra":
                return new Hay(100);
            case "rabbit":
                return new Pellets(5);
            case "goat":
                return new Pellets(30);
            case "polar bear":
                return new Fish(10);
        }
        //good practice to throw an exception if not matching subclass could be found
        throw new UnsupportedOperationException("Unsupported animal: " + animalName);
    }
}

class ZooKeeper {
    public static void main(String[] args) {
        final Food food = FoodFactory.getFood("rabbit");
        food.consumed();
    }
}