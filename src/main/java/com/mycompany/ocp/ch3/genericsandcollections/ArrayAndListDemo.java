package com.mycompany.ocp.ch3.genericsandcollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAndListDemo {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("Fluffy");
        list.add("Webby");

        //List to Array
        String[] array = new String[list.size()];
        array[0] = list.get(0);
        array[1] = list.get(1);
        for (String s : array) {
            System.out.println(s + "-");
        }

        //Array to List
        String[] array2 = {"gerbil", "mouse"};
        list = Arrays.asList(array2);
        list.set(1, "test");
        array2[0] = "new";
       // String[] array3 = (String[]) list.toArray();
      //  list.remove(1);     //java.lang.UnsupportedOperationException (asList() допускает только изменять массив, но не удалять или добавлять (not resizeable)

        String[] array4 = {"gerbil", "mouse"};
        List<String> list1 = List.of(array4);
       // list1.set(0, "test");   //java.lang.UnsupportedOperationException (List.of() immutable object и не допускает изменений)

    }
}
