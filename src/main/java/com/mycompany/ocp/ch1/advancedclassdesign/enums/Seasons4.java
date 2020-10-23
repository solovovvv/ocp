package com.mycompany.ocp.ch1.advancedclassdesign.enums;

public enum Seasons4 {
    WINTER {
        public void printHours() {
            System.out.println("9am-3pm");
        }
    },
    SUMMER {
        public void printHours() {
            System.out.println("9am-7pm");
        }
    }, SPRING, FALL;

    public void printHours() {
            System.out.println("9am-5pm");
    }


    public static void main(String[] args) {
        Seasons4.WINTER.printHours();
        Seasons4.FALL.printHours();
    }

}
