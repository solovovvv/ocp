package com.mycompany.ocp.ch2.designpatternsandprinciples;

public interface Fly {
    int getWingSpan() throws Exception;

    int MAX_SPEED = 100;

    default void land() {
        System.out.println("Animal is landing");
    }

    static double calculateSpeed(float distance, double time) {
        return distance/time;
    }

}

class Eagle implements Fly {

    @Override
    public int getWingSpan() {
        return 5;
    }

    public void land() {
        System.out.println("Eagle is landing");
    }

}