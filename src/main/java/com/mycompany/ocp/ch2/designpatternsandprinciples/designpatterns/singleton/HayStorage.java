package com.mycompany.ocp.ch2.designpatternsandprinciples.designpatterns.singleton;

/**
 * Дизайн паттерн Singleton
 * Плюсы:
 *  - переменная instance объявлена static и final - это лучший вариант для Singleton.
 * Минусы:
 *  - отсутствует lazy instantiation - изначально жестко фиксировано создание new HayStorage().
 *  - отсутствует thread-safe.
 */
public class HayStorage {
    private int quantity = 0;
    private static final HayStorage instance = new HayStorage();

    private HayStorage() {
    }

    public static HayStorage getInstance() {
        return instance;
    }

    public synchronized void addHay(int amount) {
        quantity += amount;
    }

    public synchronized boolean removeHay(int amount) {
        if (quantity < amount) return false;
        quantity -= amount;
        return true;
    }

    public synchronized int getQuantity() {
        return quantity;
    }

}

