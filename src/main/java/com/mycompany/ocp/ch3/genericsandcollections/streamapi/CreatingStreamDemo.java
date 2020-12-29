package com.mycompany.ocp.ch3.genericsandcollections.streamapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreatingStreamDemo {

    public static void main(String[] args) {
        //https://habr.com/ru/company/luxoft/blog/270383/

        //1. Классический: Создание стрима из коллекции
        Collection<Integer> integers = new ArrayList<>(Arrays.asList(3, 5, 2, 8));
        integers.stream()
                .filter(integer -> integer > 3)
                .forEach(System.out::println);

        //2. Создание стрима из значений
        Stream<String> stringStream = Stream.of("Hello", "World", "!!!");
        stringStream.forEach(System.out::println);

        //3. Создание стрима из массива
        Arrays.stream(new int[]{3, 5, 1})
                .limit(1)
                .forEach(System.out::println);


        //4. Создание стрима из чисел (IntStream, LongStream, DoubleStream)
        IntStream intStream = Arrays.stream(new int[]{3, 5, 2});
        intStream.forEach(System.out::println);

        LongStream longStream = Arrays.stream(new long[]{1000000000000000000L, 30, 10});
        longStream.forEach(System.out::println);

        DoubleStream doubleStream = Arrays.stream(new double[]{3.2, 5.1, 1.2});
        doubleStream.forEachOrdered(System.out::println);

        //5. Создание стрима из файла (каждая строка в файле будет отдельным элементом в стриме)
        try {
            Files.lines(Paths.get("src/main/resources/file.txt")).forEach(System.out::print);
            System.out.println();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //6. Создание стрима из строки
        "123".chars().forEach(System.out::print);
        System.out.println();

        //7. С помощью Stream.builder
        Stream.builder().add("1").add("2").add(true).build().forEach(System.out::print);
        System.out.println();

        //8. Создание параллельного стрима
        Arrays.asList(1,2,3).parallelStream().forEach(System.out::print);
        System.out.println();

        //9. Создание бесконечных стрима с помощью Stream.iterate
        Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n + 1);
        streamFromIterate.limit(5).forEach(System.out::print);
        System.out.println();

        //10. Создание бесконечных стрима с помощью Stream.generate
        //Stream.generate служит для генерации константных и случайных значений
        Stream<String> streamFromGenerate = Stream.generate(() -> "a1");
        streamFromGenerate.limit(5).forEach(System.out::print);
        System.out.println();

        final Random rand = new Random();   //приведем пример с генерацией стрима рандом значений
        Stream<Integer> streamFromGenerate2 = Stream.generate(() -> rand.nextInt(10));
        streamFromGenerate2.limit(10).forEach(System.out::print);
        System.out.println();


    }

}
