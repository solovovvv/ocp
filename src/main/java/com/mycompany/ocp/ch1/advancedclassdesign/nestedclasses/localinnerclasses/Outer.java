package com.mycompany.ocp.ch1.advancedclassdesign.nestedclasses.localinnerclasses;

public class Outer {
    private int length = 5;

    //Local Inner Classes.
    //Локальный внутренний класс - это вложенный класс с методом.
    //Следующие характеристики:
    //- они не имеют спецификаторов доступа
    //- они не могут быть задекларированы static и не могут декларировать static variables ans methods.
    //- они имеют доступ ко всем полям внешнего класса
    public void calculate() {
        final int width = 20;
        class Inner {
            public void multiply() {
                System.out.println(length * width);
            }
        }

        Inner inner = new Inner();
        inner.multiply();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.calculate();
    }

}
