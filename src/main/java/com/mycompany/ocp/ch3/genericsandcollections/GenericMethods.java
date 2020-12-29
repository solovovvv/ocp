package com.mycompany.ocp.ch3.genericsandcollections;

public class GenericMethods {

    public static <T> Crate_<T> ship(T t) {
        System.out.println("Preparing: " + t);
        return new Crate_<T>();
    }


    public static void main(String[] args) {
        Crate_<String> crate = new Crate_<>();
        crate.setT("Hello");
        ship(crate.getT());
        GenericMethods.<String>ship(crate.getT());  //такой стиль тоже может быть и знать его надо

    }

}

class Crate_<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

}