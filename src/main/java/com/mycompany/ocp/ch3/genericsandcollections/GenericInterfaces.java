package com.mycompany.ocp.ch3.genericsandcollections;

public class GenericInterfaces {
    public static void main(String[] args) {
        //#1 (жесткая привязка тип. параметра в конкретном классе)
        //интерфейс=класс
        Shippable shippable = new ShippableRobot();     //OK
        shippable.ship(new Robot());    //допускается, но без тип. параметра unchecked call в Object

        //интерфейс<>=класс
        Shippable<Robot> shippable1 = new ShippableRobot();     //OK
        shippable1.ship(new Robot());   //OK

        //класс=класс
        //используем класс как ссылка вместо интерфейса (не очень хороший вариант (конкретная привязка), зато не надо типизировать)
        ShippableRobot shippableRobot = new ShippableRobot();   //OK
        shippableRobot.ship(new Robot());   //OK


        //==============================================================
        //#2 универсальное решение (нет жесткой привязки к объекту)
        //интерфейс<>=класс
        Shippable<Robot> shippable2 = new ShippableAbstractRobot<>();   //OK
        shippable2.ship(new Robot());   //OK

        //интерфейс<>=класс (используем другой объект)
        Shippable<Robot2> shippable22 = new ShippableAbstractRobot<>();     //OK
        shippable22.ship(new Robot2()); //OK

        //класс=класс
        ShippableAbstractRobot shippableAbstractRobot = new ShippableAbstractRobot();   //OK
        shippableAbstractRobot.ship(new Robot());   //допускается, но без типизированного параметра unchecked call в Object

        //класс<>=класс
        ShippableAbstractRobot<Robot> shippableAbstractRobot2 = new ShippableAbstractRobot();   //допускается, но unchecked assignment (непроверенное присвоение)
        shippableAbstractRobot2.ship(new Robot());   //OK

        //класс<>=класс<>
        ShippableAbstractRobot<Robot> shippableAbstractRobot3 = new ShippableAbstractRobot<>();     //OK
        shippableAbstractRobot3.ship(new Robot());   //OK


        //==============================================================
        //#3 (используем Object вместо типизированного объекта)
        //интерфейс=класс
        Shippable shippable3 = new ShippableRobot2();   //OK
        shippable3.ship(new Robot());   //допускается, но без типизированного параметра unchecked call в Object

        //интерфейс<>=класс
        Shippable<Robot> shippable4 = new ShippableRobot2();    //допускается, но unchecked assignment (непроверенное присвоение)
        shippable4.ship(new Robot());   //OK

        //класс=класс
        ShippableRobot2 shippableRobot3 = new ShippableRobot2();    //OK
        shippableRobot3.ship(new Robot());  //OK
    }

}

class Robot {}
class Robot2 {}

interface Shippable<T> {
    void ship(T t);
}

//3 способа объявить класс с реализацией типизированного интерфейса
//#1 Указываем тип интерфейсу, который релизовываем (жестко)
class ShippableRobot implements Shippable<Robot> {
    @Override
    public void ship(Robot robot) {
        System.out.println(robot);
    }
}

//#2 Указываем абстрактный тип интерфейсу, который релизовываем + этот же абстрактный тип классу (не жесткая привязка)
class ShippableAbstractRobot<T> implements Shippable<T> {
    @Override
    public void ship(T t) {
        System.out.println(t);
    }
}

//№3 Не указываем параметризованный тип нигде, но в параметре overriding метода нужно указать тип Object (без
// типизированных параметров) не очень хороший вариант
class ShippableRobot2 implements Shippable {
    @Override
    public void ship(Object robot) {
        System.out.println(robot);
    }
}