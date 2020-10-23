package com.mycompany.ocp.ch2.designpatternsandprinciples.designpatterns.singleton;

/**
 * Дизайн паттерн Singleton
 * Плюсы:
 *  - lazy instantiation - задержка создания инстанс до тех пор, пока не будет вызван метод getInstance(). Это позволяет
 *  уменьшить использование памяти и повышает производительность.
 *  - модификатор synchronized позволяет сделать thread-safe mode (только один поток будет разрешен для создания инстанс).
 *  - double checking locking (подробнее описано в методе)
 * Минусы:
 *  - переменная instance объявлена static, но не final (final не получится сделать с lazy instantiation).
 */
public class VisitorTicketTracker2 {
    private volatile static VisitorTicketTracker2 instance = null;

    private VisitorTicketTracker2() {
    }

    //THREAD-SAFE + double checking locking
    //synchronized реализиация, которая предотвращает множество синглтонов создания имеет проблему, ведь каждый вызов
    //метода будет требовать синхронизации. В практике, это может дорого стоить и может снизить производительность.
    //Синхронизация нужна только в первый раз, когда объект создан.
    //Решение - использование double checking locking.
    public static VisitorTicketTracker2 getInstance() {
        if (instance == null) {   //lazy instantiation - ленивое инстанциирование (не сразу, а по вызову метода)
            synchronized (VisitorTicketTracker2.class) {
                if (instance == null) {
                    instance = new VisitorTicketTracker2();
                }
            }
        }
        return instance;
    }

}