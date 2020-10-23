package com.mycompany.ocp.ch1.advancedclassdesign.staticandfinal;

abstract public class Cat {
    String name = "cat";    //можно добавить static и final модификаторы
    void clean() {}     //можно добавить static, но также надо будет добавить и в Lion.clean()
}

class Lion extends Cat {    //final можно добавить в класс, а static только во внутренний класс
    void clean() {}     //можно добавить static, но также надо будет добавить и в Cat.clean(). Можно также добавить final
}
