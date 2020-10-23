package com.mycompany.ocp.ch1.advancedclassdesign.enums;

public enum Seasons2 {
    WINTER("Low"), SPRING("Medium"), SUMMER("High"), FALL("Medium");
    private String expectedVisitors;

    private Seasons2(String expectedVisitors) {
        this.expectedVisitors = expectedVisitors;
    }

    public void printExpectedVisitors() {
        System.out.println(expectedVisitors);
    }

    public static void main(String[] args) {
        //вызов метода в Enum, мы только говорим, что хотим вызвать enum value.
        Seasons2.SUMMER.printExpectedVisitors();
        Seasons2.SPRING.printExpectedVisitors();
    }

}
