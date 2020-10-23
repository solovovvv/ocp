package com.mycompany.ocp.ch2.designpatternsandprinciples.designpatterns.immutableobject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Проблема: как мы создаем read-only объекты, которые могут быть использованы множеством классов?
 * <p>
 * Мотивация: Иногда мы хотим создать simple objects, которые не должны быть модифицированы. Мы должны копировать объект
 * перед отправкой его в другой метод, но это создаёт большие накладные расходы, что дубликаты объекты всегда передаются.
 * Более того, если мы имеем множество потоков, получающих доступ в один объект, мы должны запустить в concurrency
 * решении.
 * <p>
 * Решение: immutable object pattern is creational pattern - создание объектов, чьё состояние не меняется, тут нет
 * setter'ов и поскольку они не меняются по своей природе они thread-safe (потокобезопасны).
 * <p>
 * Правила:
 * 1. Использовать конструктор для настройки всех полей объекта.
 * 2. Декларировать все instance variables private and final.
 * 3. Не определяь сеттеров.
 * 4. Не разрешать изменение или доступ напрямую к изменяемым ссылкам.
 * 5. Защитить методы от переопределения.
 *
 * Мои соображения по поводу использования коллекций в immutable классах:
 * 1. Использовать new для создания новой коллекции в конструкторе, т.е. указатели на обе коллекции неравны.
 * 2. Поскольку элементы в обоих коллекциях равны (т.е. объекты одинаковые) можно клонировать (но если коллекция большая,
 * будет дорого обходиться, либо в методе возвращать элемент по индексу - как самый лучший вариант).
 *
 */
public final class Animal {
    private final String species;
    private final int age;
    private final List<String> favoriteFoods;

    public Animal(String species, int age, List<String> favoriteFoods) {
        this.species = species;
        this.age = age;
        if (favoriteFoods == null) {
            throw new RuntimeException("favorite foods is requires!!!!");
        }
        this.favoriteFoods = favoriteFoods;     //так элементы листа будут MUTABLE (изменяемые)!!!
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    //Здесь проблема: данным могут быть изменены в листе, например, getFavoriteFoods().clear(), и источник лист, который
    //идет как параметр будет изменен. Данные могут быть изменены, удалены, отсортированы и пр.
    public List<String> getFavoriteFoods() {    //MAKES CLASS MUTABLE!!!    (ссылки на элементы одинаковые)
        return favoriteFoods;
    }

}

final class Animal2 {
    private final String species;
    private final int age;
    private final List<String> favoriteFoods;

    public Animal2(String species, int age, List<String> favoriteFoods) {
        this.species = species;
        this.age = age;
        if (favoriteFoods == null) {
            throw new RuntimeException("favorite foods is requires!!!!");
        }
        this.favoriteFoods = new ArrayList<>(favoriteFoods);    //MAKES CLASS IMMUTABLE!!! создаем новую коллекцию (ссылки на элементы одинаковые)
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public List<String> getFavoriteFoods() {    //при тестировании элементы не получилось изменить, но как пишут лучше не возвращать коллекцию с методами
        return favoriteFoods;
    }

    public int getFavoriteFoodCount() {
        return favoriteFoods.size();
    }

    public String getFavoriteFood(int index) {
        return favoriteFoods.get(index);
    }

}

class TestImmutableObject {
    public static void main(String[] args) {
        List<String> original = new ArrayList<>();
        original.add(new String("Hello"));
        original.add(new String("World"));

        Animal animal = new Animal("Lion", 3, original);
        System.out.println(original == animal.getFavoriteFoods());  //true, указатели на объект List одинаковые
        System.out.println(original.get(0) == animal.getFavoriteFoods().get(0));    //true, указатели на 1-й элемент колллекции true
        animal.getFavoriteFoods().add("!!!");   //добавим элемент
        original.forEach(System.out::println);
        animal.getFavoriteFoods().clear();      //очистим коллекцию
        System.out.println("Clear list: ");
        original.forEach(System.out::println);
        //в результате мы изменили данные в коллекции и объект класса Animal не может считаться immutable!!!

        System.out.println();

        //теперь протестируем класс Animal2
//        original = new ArrayList<>();
//        original.add(new String("Hello"));
//        original.add(new String("World"));
//
//        Animal2 animal2 = new Animal2("lion", 5, Arrays.asList("meat", "more meat"));
//        System.out.println(original == animal2.getFavoriteFoods());  //false, указатели на объект List разные
//        System.out.println(original.get(0) == animal2.getFavoriteFoods().get(0));    //true, указатели одинаковые на объекты колллекции
//        animal2.getFavoriteFoods().add("!!!");   //добавим элемент
//        original.forEach(System.out::println);
//        animal2.getFavoriteFoods().forEach(System.out::println);
//        animal2.getFavoriteFoods().clear();      //очистим коллекцию
//        original.forEach(System.out::println);
//
//        List<String> list = animal2.getFavoriteFoods();
//        list.sort(String::compareToIgnoreCase);
//        original.forEach(System.out::println);

        //как получить данные из коллекции immutable объекта?
        Animal2 lion = new Animal2("lion", 5, Arrays.asList("meat", "more meat"));
        List<String> favoriteFood = new ArrayList<>();
        for (int i = 0; i < lion.getFavoriteFoodCount(); i++) {
            favoriteFood.add(lion.getFavoriteFood(i));
        }
        Animal2 updateLion = new Animal2(lion.getSpecies(), lion.getAge() + 1, favoriteFood);
        System.out.println(favoriteFood.equals(updateLion.getFavoriteFoods()));     //true, мы получили равные по элементам коллекции

    }
}