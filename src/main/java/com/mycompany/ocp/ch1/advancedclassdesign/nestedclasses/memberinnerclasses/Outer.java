package com.mycompany.ocp.ch1.advancedclassdesign.nestedclasses.memberinnerclasses;

/**
 * Nested classes - это вложенные классы.
 * Если класс не статический, то он называется inner (внутренний).
 *
 * В java есть 4 типа nested classes:
 * - member inner classes (non static);
 * - local inner classes, определенне в методе;
 * - anonymous inner classes;
 * - static nested classes;
 */
public class Outer {

    //Member Inner Class (non static)
    //может быть public, private, protected, default access
    //может быть расширен от другого класса или реализовать интерфейс
    //может быть абстратным или final
    //не может декларировать статические поля или методы
    //может получить доступ к внешнему классу, включая private члены
    protected class Inner {
        public int repeat = 3;
        public void go() {
            for (int i = 0; i < repeat; i++)
                System.out.println(i);
        }
    }

    public void callInner() {
        Inner inner = new Inner();
        inner.go();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.callInner();  //вызов метода из Outer класса
        Inner inner = outer.new Inner();    //создаем экземпляр Inner класса
        inner.go();     //вызов метода из Inner класса
    }

}
