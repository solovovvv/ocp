package com.mycompany.ocp.ch2.designpatternsandprinciples.designpatterns.singleton;

/**
 * Дизайн паттерн Singleton
 * Плюсы:
 *  - lazy instantiation - задержка создания инстанс до тех пор, пока не будет вызван метод getInstance(). Это позволяет
 *  уменьшить использование памяти и повышает производительность.
 *  - модификатор synchronized позволяет сделать thread-safe mode (только один поток будет разрешен для создания инстанс).
 * Минусы:
 *  - переменная instance объявлена static, но не final (final не получится сделать с lazy instantiation).
 */
public class VisitorTicketTracker {
    private static VisitorTicketTracker instance = null;

    private VisitorTicketTracker() {
    }

    //NOT THREAD-SAFE!!!
    public static VisitorTicketTracker getInstance() {
        if (instance == null) {   //lazy instantiation - ленивое инстанциирование (не сразу, а по вызову метода)
            instance = new VisitorTicketTracker();
        }
        return instance;
    }

    //THREAD-SAFE!!!
    public synchronized static VisitorTicketTracker getInstanceWithThreadSafe() {
        if (instance == null) {   //lazy instantiation - ленивое инстанциирование (не сразу, а по вызову метода)
            instance = new VisitorTicketTracker();
        }
        return instance;
    }

}