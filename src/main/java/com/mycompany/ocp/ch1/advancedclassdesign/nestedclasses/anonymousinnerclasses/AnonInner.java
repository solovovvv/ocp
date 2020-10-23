package com.mycompany.ocp.ch1.advancedclassdesign.nestedclasses.anonymousinnerclasses;

//анонимный класс построен на абстрактном классе (абстрактный класс не может быть инстанциирован)
public class AnonInner {
    abstract class SaleTodayOnly {
        abstract int dollarsOff();
    }

    public int admission(int basePrice) {
        SaleTodayOnly saleTodayOnly = new SaleTodayOnly() {
            @Override
            int dollarsOff() {
                return 3;
            }
        };
        return basePrice - saleTodayOnly.dollarsOff();
    }

    public static void main(String[] args) {
        AnonInner a = new AnonInner();
        System.out.println(a.admission(5));
    }

}

//анонимный класс построен на интерфейсе (интерфейс не может быть инстанциирован)
class AnonInner2 {
    interface SaleTodayOnly {
        int dollarsOff();
    }

    public int admission(int basePrice) {
        SaleTodayOnly saleTodayOnly = new SaleTodayOnly() {
            @Override
            public int dollarsOff() {
                return 3;
            }
        };
        return basePrice - saleTodayOnly.dollarsOff();
    }

    //java 8
    public int admission2(int basePrice) {
        SaleTodayOnly saleTodayOnly = () -> 3;
        return basePrice - saleTodayOnly.dollarsOff();
    }

    public static void main(String[] args) {
        AnonInner2 a = new AnonInner2();
        System.out.println(a.admission(5));

        //с интерфейсом можно сделать лямбду, с абстрактным классом так не получится
        System.out.println(a.admission2(5));
    }

}
