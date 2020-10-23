package com.mycompany.ocp.ch1.advancedclassdesign.enums;

public enum Seasons3 {
    WINTER {
        public void printHours() {
            System.out.println("9am-3pm");
        }
    }, SPRING {
        public void printHours() {
            System.out.println("9am-5pm");
        }
    }, SUMMER {
        public void printHours() {
            System.out.println("9am-7pm");
        }
    }, FALL {
        public void printHours() {
            System.out.println("9am-5pm");
        }
    };
    public abstract void printHours();

    public static void main(String[] args) {
        Seasons3.WINTER.printHours();
    }

}
