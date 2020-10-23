package com.mycompany.ocp.ch2.designpatternsandprinciples.designpatterns.singleton;

/**
 * Дизайн паттерн Singleton
 * Плюсы:
 *  - переменная instance объявлена static и final - это лучший вариант для Singleton.
 * Минусы:
 *  - отсутствует lazy instantiation - изначально жестко фиксировано создание new HayStorage() (в стат. блоке инит.).
 *  - отсутствует thread-safe.
 */
public class StaffRegister {
    private static final StaffRegister instance;

    //можно создать инстанс в статическом блоке инициализации, тут дело вкуса
    static {
        instance = new StaffRegister();
    }

    private StaffRegister() {}

    public static StaffRegister getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        StaffRegister staffRegister = StaffRegister.getInstance();
        StaffRegister staffRegister1 = StaffRegister.getInstance();
        System.out.println(staffRegister == staffRegister1);    //true
    }

}
