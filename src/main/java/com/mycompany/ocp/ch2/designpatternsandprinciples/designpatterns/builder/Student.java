package com.mycompany.ocp.ch2.designpatternsandprinciples.designpatterns.builder;

/**
 * Дизайн паттерн "Builder" на вложенном статическом классе
 */
public class Student {
    private String name;
    private int age;

    private Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //builder
    static class StudentBuilder {
        private String name;
        private int age;

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public Student builder() {
            if (name == null) throw new RuntimeException("Name is required!!!");
            if (age < 1) throw new RuntimeException("Age is < 1!!!");
            return new Student(name, age);
        }

    }

}

class Test {
    public static void main(String[] args) {
        Student student = new Student.StudentBuilder()
                .setName("John")
                .setAge(24)
                .builder();
        System.out.println("name: " + student.getName() + "\nage: " + student.getAge());
    }
}
