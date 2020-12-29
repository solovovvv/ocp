package com.mycompany.ocp.ch1.advancedclassdesign.equalshashcodeandtostring;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.*;

/**
 * toString()
 * Как мы знаем, если не переопределять метод toString() в консоль будет вывод что-то такое:
 * com.mycompany.ocp.ch1.advancedclassdesign.equalshashcodeandtostring.Hippo@6d6f6e28.
 * 4 способа переопределения toString():
 * 1. Переопределяем с помощью Intellij IDEA и получаем: Hippo{name='Harry', weight=3100.0}.
 * 2. Переопределяем с помощью commons-lang3 и получаем:
 * com.mycompany.ocp.ch1.advancedclassdesign.equalshashcodeandtostring.Hippo@34a245ab[name=Harry,weight=3100.0].
 * 3. Переопределяем с помощью аннотации Lombok @ToString и получаем: Hippo(name=Harry, weight=3100.0).
 * 4. Ручной, руками переопределяем, кстати, чтобы не создавать много String объектов можно
 * использовать StringBuilder, такой вариант тоже видел используется.
 * <p>
 * equals()
 * Как мы знаем, если не переопределять метод equals() все объекты будут false, поскольку ссылки в любом случае у них
 * разные. Но если правильно переопределить equals() можно сымитировать равенство по одинаковому состоянию объектов
 * (по одинаковым значениям полей, приведения объектов и пр.).
 * 4 способа переопределения equals():
 * 1. Переопределяем с помощью Intellij IDEA.
 * 2. Переопределяем с помощью commons-lang3 (return EqualsBuilder.reflectionEquals(this, obj);).
 * 3. Переопределяем с помощью аннотации Lombok @EqualsAndHashCode.
 * 4. Ручной, руками переопределяем.
 *
 * hashCode()
 * Как мы знаем, если не переопределять метод hashCode(), он возвращает какое-то уникальное число по умолчанию. hashCode()
 * используется, когда хранится объект в HashSet(), как key в HashMap().
 * Главные правила hashCode():
 * 1. С одной и той же программой, результат hashCode() должен не меняться. Это означает, что Вы не должны включать
 * переменные, которые меняются. В нашем Hippo name можно включить, weight - нет, поскольку вес регулярно меняется.
 * 2. Если equals() возвращает true, когда вызваны 2 объекта, вызов hashCode() на каждый из них должен вызывать один и
 * тот же результат. Это означает hashCode() может использовать подмножество переменных, которые использованы в equals().
 * Вы видели это в примере с классом Card. Мы использовали только одну переменную определить hashCode().
 * 3. Если equals() возвращает false, когда вызваны 2 объекта, вызов hashCode() на каждый из них может возвратить
 * одинаковый результат. Это означает результат hashCode() не нуждается быть уникальным, когда вызван на неравных
 * (equals()=false) объектах.
 * 4 способа переопределения hashCode():
 * 1. Переопределяем с помощью Intellij IDEA.
 * 2. Переопределяем с помощью commons-lang3 (return HashCodeBuilder.reflectionHashCode(this););.
 * 3. Переопределяем с помощью аннотации Lombok @EqualsAndHashCode.
 * 4. Ручной, руками переопределяем, но hashCode должен правильно вычисляться.
 *
 *
 */
//@ToString
//@EqualsAndHashCode
public class Hippo {
    private String name;
    private double weight;

    public Hippo(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        //return ToStringBuilder.reflectionToString(this);    //используем commons-lang3
        return "Hippo{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        //return EqualsBuilder.reflectionEquals(this, obj);     //используем commons-lang3
        if (obj == null) return false;
        if (!(obj instanceof Hippo)) return false;
        Hippo hippo = (Hippo) obj;
        return (hippo.name.equals(this.name) && hippo.weight == this.weight);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);    //используем commons-lang3
    }


    public static void main(String[] args) {
        Hippo hippo1 = new Hippo("Harry", 3100);
        System.out.println(hippo1);
        Hippo hippo2 = new Hippo("Harry", 3100);
        System.out.println("hippo1 equals hippo2?: " + hippo2.equals(hippo1));

        //Как проверить работу equals()?
        List<Hippo> list = new ArrayList<>();
        list.add(new Hippo("Harry", 3100));
        list.add(new Hippo("Jenny", 2700));
        list.add(new Hippo("Tom", 5500));
        list.remove(new Hippo("Jenny", 2700));  //если equals() правильно переопределен, объект с именем Jenny будет удален
        list.forEach(System.out::println);

        //Как проверить работу hashCode()?
        //1. если equals()=false, hashCode()=одинаковый, то объект будет добавлен (т.е. объекты якобы разные, неважно, что hash одинаковый)
        //2. если equals()=true, hashCode()=одинаковый, то объект не будет добавлен (т.е. объекты якобы одинаковые и hash одинаковый, объект точно не будет добавлен, это правильное переопределение и дубликаты не разрешается добавлять)
        //3. если equals()=true, hashCode()=разный, то объект будет добавлен (т.е. объекты якобы одинаковые, но hash разный)
        //4. если equals()=false, hashCode()=разный, то объект будет добавлен (т.е. объекты якобы разные и hash разный)
        Set<Dog> set = new HashSet<>();
        set.add(new Dog("Jim"));
        set.add(new Dog("Ji"));
        System.out.println(set.size());
        set.forEach(System.out::println);

        System.out.println(set.contains(new Dog("Ji")));
        //если equals()=false, hashCode()=одинаковый, объекты (new Dog("Jim"), new Dog("Ji")) добавятся оба (size()=2), но contains("Ji") вернет false (ТАК ДЕЛАТЬ НЕЛЬЗЯ!!!)
        //если equals()=true, hashCode()=одинаковый, объекты (new Dog("Jim"), new Dog("Ji") добавится только "Jim", но contains("Ji") вернет true (ТАК ДЕЛАТЬ НЕЛЬЗЯ!!!)
        //если equals()=true, hashCode()=разный, объекты (new Dog("Jim"), new Dog("Ji")) добавятся оба (size()=2), contains("Ji") вернет true (ЭТО ПРАВИЛЬНОЕ РЕШЕНИЕ!!!)
        //если equals()=false, hashCode()=разный, объекты (new Dog("Jim"), new Dog("Ji")) добавятся оба (size()=2), но contains("Ji") вернет false (ТАК ДЕЛАТЬ НЕЛЬЗЯ!!!)

        //то же самое мы наблюдаем в HashMap.
        Map<Dog, Integer> map = new HashMap<>();
        map.put(new Dog("Jim"),5);
        map.put(new Dog("Ji"),5);
        System.out.println(map.size());
        map.forEach((dog, integer) -> System.out.println(dog + " " + integer));
        System.out.println(map.containsKey(new Dog("Ji")));
        System.out.println(Integer.parseInt("3cbbc1e0",16));
    }

}

class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    //equals() указан неправильно, чисто в ознакомительных целях!
    @Override
    public boolean equals(Object o) {
        return false;
    }

    //hashCode() указан неправильно, чисто в ознакомительных целях!
    @Override
    public int hashCode() {
        return name.length();
    }

}