package com.mycompany.ocp.ch2.designpatternsandprinciples.designpatterns.builder;

import com.mycompany.ocp.ch2.designpatternsandprinciples.designpatterns.immutableobject.Animal;

import java.util.Arrays;
import java.util.List;

/**
 * Дизайн паттерн Builder
 * <p>
 * Проблема: как создать объект, которые требует многочисленных значений быть настроенными во время инстанциировании
 * объекта?
 * <p>
 * Мотивация: конструктор может содержать много аттрибутов. Как решение, можно использовать сеттеры, но в immutable
 * объектах их нельзя использовать, поскольку, они могут изменить объект после инстанциирования.
 * <p>
 * Решение: builder pattern is creational pattern, в котором параметры переданы в builder объект, часто через method
 * chaining и затем объект генерирует с финальным вызовом. Этот паттерн часто используют с immutable объектами, поскольку
 * immutable объекты не имеют сеттеров и должны создаваться в конструкторе.
 * <p>
 * - класс AnimalBuilder в отличие от Animal mutable, мы можем модифицировать как хотим строить его и затем строим (метод
 * build()).
 * - сетеры можно вызывать в любом порядке. Можно не указывать все сетеры и написать бросать исключение, если,
 * например, age не был установлен.
 * - если меняются поля Animal, AnimalBuilder почти не меняется.
 * - как правило, builder pattern используют как статический inner класс
 */
public class AnimalBuilder {
    private String species;
    private int age;
    private List<String> favoriteFood;

    public AnimalBuilder setSpecies(String species) {
        this.species = species;
        return this;
    }

    public AnimalBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public AnimalBuilder setFavoriteFood(List<String> favoriteFood) {
        this.favoriteFood = favoriteFood;
        return this;
    }

    public Animal build() {
        return new Animal(species, age, favoriteFood);
    }

}

class TestBuilder {
    public static void main(String[] args) {
        Animal builder = new AnimalBuilder()
                .setAge(4)
                .setFavoriteFood(Arrays.asList("Meat", "More Meat"))
                .setSpecies("Lion")
                .build();   //как видно мы нигде не сохраняем инстанцию AnimalBuilder(), хотя можно, но не нужно
        System.out.println(builder.getSpecies());
    }
}