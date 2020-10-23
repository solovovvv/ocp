package com.mycompany.ocp.ch1.advancedclassdesign.nestedclasses;

/**
 * Table 1.2 Types of nested classes
 * ---------------------------------------------------------------------------------------------------------------------
 *                      Inner           Local           Anonymous           Static
 *                      class           inner           inner               nested
 *                                      class           class               class
 * ---------------------------------------------------------------------------------------------------------------------
 * Access               All             None.           All                 All
 * modifiers                            Already
 * allowed                              local to
 *                                      method
 *
 * Can extend           Yes             Yes             No - must have      Yes
 * or implements?                                       one superclass
 *                                                      or one interface
 *
 * Can be abstract?     Yes             Yes             No - because no     Yes
 *                                                      class definition
 *
 * Can be final?        Yes             Yes             Yes                 Yes
 *
 * Can access instance  Yes             Yes             Yes                 Not (not directly:
 * members of enclosing                                                     requires an
 * class                                                                    instance of the
 *                                                                          enclosing class)
 *
 * Can access local     No              Yes - if        Yes - if            No
 * variables of                         final or        final or
 * enclosing class                      effectively     effectively
 *                                      final           final
 *
 * Can declare          No              No              No                  Yes
 * static methods
 * ---------------------------------------------------------------------------------------------------------------------
 *
 */
public class MyRules {
    private int age = 5;
    private static String name = "John";


    //inner class
    protected final class StudentInner extends Human implements CanFly {
        protected long id;
        private String name;
        public int age;
        boolean flag;

        @Override
        void sleep() {

        }

        private void f() {
            System.out.println("f() " + this.age);
        }
    }

    //factory method
    public StudentInner getStudentInner() {
        return new StudentInner();
    }

    //local inner class
    public void f() {
        int width = 2;
        //local inner class
        abstract class Animal {}
        //local inner class
        final class LocalInnerClass extends Animal implements CanFly {
            void f() {
                System.out.println("width: " + width + " name: " + name);
            }
        }
        new LocalInnerClass().f();
    }

    //anonymous inner class
    public void f2() {
        //anonymous inner class
        final Human human = new Human() {
            private int i = 3;
            @Override
            void sleep() {
                System.out.println("Sleep " + name + " " + i);
            }
        };
        human.sleep();
    }

    //static nested class
    static class User extends Human implements CanFly {
        private String login;
        protected static String password;
        String name;

        @Override
        void sleep() {

        }

        void f() {
            password = "*_#kd";
            System.out.println(password + " " + name);
            System.out.println(new MyRules().name); //получить instance variables enclosing class не получится, можно создать новую инстанс
        }

        static void f2() {
            password = "sse";
            System.out.println(password);
        }

    }


    public static void main(String[] args) {
        //inner
        MyRules m = new MyRules();
        StudentInner inner = m.new StudentInner();
        System.out.println(inner.name);
        inner.f();
        inner = m.getStudentInner();    //factory method (получаем ссылку на внутренний класс)

        //local inner class
        m.f();

        //anonymous inner class
        m.f2();

        //static nested class
        User.f2();
        User user = new User();
        user.f();
    }

}

interface CanFly {

}

abstract class Human {
    abstract void sleep();
}