package com.mycompany.ocp.ch1.advancedclassdesign.abstractclasses;

abstract public class Cat {
    //------------------какой метод здесь указать?------------------
    //1. можно не указывать метод
    //abstract void clean();    //2. можно указать абстрактный метод
    //void clean() {}     //3. можно указать не абстрактный метод
}

class Lion extends Cat {
    void clean() {}
}