package com.mycompany.ocp.ch1.advancedclassdesign.enums;

public enum OnlyOne {
    ONCE(true);

    private OnlyOne(boolean b) {
        System.out.println("constructing");
    }

    public static void main(String[] args) {
        OnlyOne o1 = OnlyOne.ONCE;      //prints constructing
        OnlyOne o2 = OnlyOne.ONCE;      //doesn't print anything
    }

}
