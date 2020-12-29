package com.mycompany.ocp.ch3.genericsandcollections;

import java.util.*;

public class ComparatorVsComparable {
    public static void main(String[] args) {
        //Мы говорили про порядок в TreeSet и TreeMap. Для чисел всё понятно - это числовой порядок. Для String объектов
        //порядок определяется так: сначала цифры, потом буквы в верхнем регистре, затем буквы в нижнем регистре.

        //Для сортировки объектов в java имеется интерфейс Comparable. Если мы реализовали Comparable, мы можем сравнить
        //объекты. Также есть класс Comparator, который использован для того, что Вы, например, хотите использовать
        // другой порядок, чем объект сам обеспечивает.

        //Comparable
        Duck duck1 = new Duck("Quack");
        Duck duck2 = new Duck("Puddles");
        Set<Duck> set = new TreeSet<>(Arrays.asList(duck1, duck2)); //TreeSet сразу отсортиртирует объекты
        set.forEach(System.out::print);   //PuddlesQuack
        List<Duck> list = new ArrayList<>(Arrays.asList(duck1, duck2));
        System.out.println();
        Collections.sort(list);     //Collections.sort также использует Comparable
        list.forEach(System.out::print);    //PuddlesQuack
        System.out.println();

        //Здесь надо знать 3 правила возврата метода compareTo():
        //1. Число 0 возвращается, когда текущий объект равен с аргументом в compareTo().
        //2. Число < 0 возвращается, когда текущий объект меньше аргумента в compareTo().
        //3. Число > 0 возвращается, когда текущий объект больше аргумента в compareTo().
        Set<Animal> set1 = new TreeSet<>(Arrays.asList(new Animal(5), new Animal(2)));
        set1.forEach(System.out::print);    //Animal{ id: 2}Animal{ id: 5}
        System.out.println();

        //compareTo() and equals() Consistency
        //Когда мы реализуем Comparable, мы вносим новую бизнес-логику для определения равенства. compareTo() возвращает
        //0, если 2 объекта равны, тогда как equals() возвращает true, если 2 объета равны. Естественный порядок, который
        //использует compareTo() говорит быть последовательным с equals() если и только если x.equals(y)=true всякий раз,
        //когда x.compareTo(y)=0.
        //В общем надо знать следующее: compareTo() должен быть последователен с equals(), т.е. есть класс Product и 2
        //поля: id, name. В equals() возвращаем сравнение ТОЛЬКО id (без name), а в compareTo() сравнение name. ЭТО
        //НЕПОСЛЕДОВАТЕЛЬНО!!! Мы должны сортировать объекты по имени, но имена неуникальны. Таким образом, compareTo()
        //не должен возвратить 0. Один путь фиксировать это использовать Comparator для определения сортировки.

        //Comparator
        //Иногда мы хотим сортировать объект, который НЕ ИСПОЛЬЗУЕТ Comparable или мы хотим сортировать объекты РАЗНЫМИ
        //СПОСОБАМИ и В РАЗНОЕ ВРЕМЯ.
        Comparator<Duck2> byWeight = new Comparator<>() {
            public int compare(Duck2 d1, Duck2 d2) {
                return d1.getWeight() - d2.getWeight();
            }
        };
        //java 8
        Comparator<Duck2> byWeight2 = (d1, d2) -> d2.getWeight() - d1.getWeight();  //descending weight
        Comparator<Duck2> byWeight3 = Comparator.comparing(d -> d.getWeight());     //lambda
        Comparator<Duck2> byWeight4 = Comparator.comparing(Duck2::getWeight);   //ref

        List<Duck2> ducks = new ArrayList<>(Arrays.asList(new Duck2("Quack", 7), new Duck2("Puddles", 10)));
        Collections.sort(ducks, byWeight2);     //важно понимать, если в классе не реализован Comparable, то Collections.sort(ducks) будет ошибка, нужен объект Comparator (сортировка)
        //ducks.sort(byWeight4);    //можно и так (передаем Comparator в метод)

        ducks.forEach(System.out::print);   //Duck2{name='Puddles', weight=10}Duck2{name='Quack', weight=7}
        System.out.println();

        /**
         * Table 3.10 Comparison of Comparable and Comparator
         * --------------------------------------------------------------
         * Difference                       Comparable      Comparator
         * --------------------------------------------------------------
         * Package name                     java.lang       java.util
         * Interface must be implemented    Yes             No
         * by class comparing?
         * Method name in interface         compareTo       compare
         * Number of parameters             1               2
         * Commons of declare using in      No              Yes
         * lambda
         * --------------------------------------------------------------
         */

        //Легкий путь сравнения множества полей
        //Если много полей и надо сделать сортировку, можно использовать old way (см. ниже MultiFieldComparator) или
        //new way (см. ниже ChainingComparator на лямбдах или ChainingComparator2 на ref - это лучший путь, используя
        // method chaining).

        //Searching and Sorting
        //Еще раз повторюсь, но так надо: если класс Dog не реализует Comparable, то Collections.sort(dog); будет ошибка
        //компиляции. Мы можем пофиксить это передав вторым параметром объект Comparator. ЗАПОМНИМ, Comparator полезен,
        //когда мы хотим специфическую сортировку без использования compareTo() метода.

        //sort() и binarySearch() разрешают передавать Comparator, когда Вам не нужен обычный порядок сортировки.
        List<Integer> integers = Arrays.asList(4, 7, 3, 1);
        Comparator<Integer> comparator = Comparator.reverseOrder();     //аналог (i1, i2) -> i2 - i1
        Collections.sort(integers, comparator);
        integers.forEach(System.out::print);
        System.out.println();
        int index = Collections.binarySearch(integers, 3, comparator);
        System.out.println(index);

    }
}

class Duck implements Comparable<Duck> {
    private String name;

    public Duck(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Duck duck) {
        return name.compareTo(duck.name);
    }

    @Override
    public String toString() {
        return name;
    }

}

class Animal implements Comparable<Animal> {
    private int id;

    public Animal(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Animal animal) {
        return this.id - animal.id;     //ascending order
        //return animal.id - this.id;     //descending order
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{ id: " + id + "}";
    }

}

class Duck2 {
    private String name;
    private int weight;

    public Duck2(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Duck2{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}

//белка
class Squirrel {
    private int weight;
    private String species;     //порода

    public Squirrel(int weight, String species) {
        if (species == null) throw new IllegalArgumentException();
        this.species = species;
    }

    public int getWeight() {
        return weight;
    }

    public String getSpecies() {
        return species;
    }

}

//это работает, это проверяет 1-е поле. Если они не совпадает, мы заканчиваем сортировку, если совпадают, проверяем
//следующее поле. Это не легкий путь чтения. Изменения != в == делают сортировку совершенной.
class MultiFieldComparator implements Comparator<Squirrel> {
    public int compare(Squirrel s1, Squirrel s2) {
        int result = s1.getWeight() - s2.getWeight();
        if (result != 0) return result;
        return s1.getSpecies().compareTo(s2.getSpecies());
    }
}

class ChainingComparator implements Comparator<Squirrel> {
    public int compare(Squirrel s1, Squirrel s2) {
        Comparator<Squirrel> c = Comparator.comparing(s -> s.getSpecies());    //можно Squirrel::getSpecies
        c = c.thenComparingInt(s -> s.getWeight());
        return c.compare(s1, s2);
    }
}

class ChainingComparator2 implements Comparator<Squirrel> {
    public int compare(Squirrel s1, Squirrel s2) {
        Comparator<Squirrel> c = Comparator.comparing(Squirrel::getSpecies)     //by ref
                .thenComparing(Squirrel::getWeight) ;    //by ref
        return c.compare(s1, s2);
    }
}