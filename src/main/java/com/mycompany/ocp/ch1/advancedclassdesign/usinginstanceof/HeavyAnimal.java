package com.mycompany.ocp.ch1.advancedclassdesign.usinginstanceof;

public class HeavyAnimal {
}

class Hippo extends HeavyAnimal {
}

class Elephant extends HeavyAnimal {
}

class Test {
    public static void main(String[] args) {
        HeavyAnimal hippo = new Hippo();
        System.out.println(hippo instanceof Hippo);     //true
        System.out.println(hippo instanceof HeavyAnimal);   //true
        System.out.println(hippo instanceof Elephant);  //false
        Hippo hippo1 = new Hippo();
        System.out.println(hippo1 instanceof HeavyAnimal);  //true
        System.out.println(hippo1 instanceof Hippo);    //true
        //System.out.println(hippo1 instanceof Elephant);     //does not compile (inconvertible types)
        hippo1 = null;
        System.out.println(hippo1 instanceof HeavyAnimal);  //false
    }
}

abstract class Animal {
    void addHay() {}
    void addSeed() {}
    void addMeat() {}
}

class Cow extends Animal {
    void addHay() {}
}

class Bird extends Animal {
    void addSeed() {}
}

class Lion extends Animal {
    void addMeat() {}
}

class Test1 {
    void feedAnimal(Animal animal) {
        if (animal instanceof Cow) {
            ((Cow) animal).addHay();
        } else if (animal instanceof Bird) {
            ((Bird) animal).addSeed();
        } else if (animal instanceof Lion) {
            ((Lion) animal).addMeat();
        } else {
            throw new RuntimeException("Unsupported animal");
        }
    }
}