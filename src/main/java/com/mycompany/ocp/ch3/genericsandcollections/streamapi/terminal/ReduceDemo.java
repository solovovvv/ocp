package com.mycompany.ocp.ch3.genericsandcollections.streamapi.terminal;

import com.mycompany.ocp.ch3.genericsandcollections.streamapi.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ReduceDemo {
    public static void main(String[] args) {
        //reduce() - позволяет выполнять агрегатные функции на всей коллекцией и возвращать один результат

        //T reduce(T var1, BinaryOperator<T> var2);
        //Optional<T> reduce(BinaryOperator<T> var1);
        //<U> U reduce(U var1, BiFunction<U, ? super T, U> var2, BinaryOperator<U> var3);
        //int reduce(int var1, IntBinaryOperator var2);
        //OptionalInt reduce(IntBinaryOperator var1);
        //long reduce(long var1, LongBinaryOperator var3);
        //OptionalLong reduce(LongBinaryOperator var1);
        //double reduce(double var1, DoubleBinaryOperator var3);
        //OptionalDouble reduce(DoubleBinaryOperator var1);

        int num = Stream.of(1, 2, 3, 4, 5)
                .reduce((i1, i2) -> i1 + i2).orElse(0); //без накопителя, только BinaryOperator
        System.out.println(num);

        num = Stream.of(1, 2, 3, 4, 5)
                .reduce(10, (i1, i2) -> i1 + i2);   //с накопителем + BinaryOperator
        System.out.println(num);

        //посложнее пример, найти общий возраст (сумму) персон в листе
        List<Person> persons = Arrays.asList(new Person("Jim", 22, 11),
                new Person("John", 33, 11),
                new Person("Sandy", 44, 11));
        int maxAge = persons.stream()
                .reduce(0, (integer, person) -> integer + person.getAge(), Integer::sum);   //с накопителем + BiFunction + BinaryOperator
        System.out.println(maxAge);

    }
}
