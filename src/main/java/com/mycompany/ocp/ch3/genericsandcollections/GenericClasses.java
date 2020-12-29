package com.mycompany.ocp.ch3.genericsandcollections;

public class GenericClasses {
    public static void main(String[] args) {
        Elephant elephant = new Elephant("Johny");
        Crate<Elephant> crate = new Crate<>();
        crate.setT(elephant);
        System.out.println(crate.getT().toString());

        Crate<Zebra> crate1 = new Crate<>();
        crate1.setT(new Zebra());
        System.out.println(crate1.getT());


        SizeLimitedCrate<Elephant, Integer> limitedCrate = new SizeLimitedCrate<>(
                new Elephant("Jim"), new Integer(15_000));
    }
}

//класс с типизированным параметром
class Crate<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

}

class Elephant {
    private String name;

    public Elephant(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class Zebra {}

class SizeLimitedCrate<T, U> {
    private T contents;
    private U sizeLimit;

    public SizeLimitedCrate(T contents, U sizeLimit) {
        this.contents = contents;
        this.sizeLimit = sizeLimit;
    }
}