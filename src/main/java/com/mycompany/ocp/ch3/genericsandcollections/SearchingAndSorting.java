package com.mycompany.ocp.ch3.genericsandcollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class SearchingAndSorting {
    public static void main(String[] args) {
        int[] numbers = {6, 9, 1, 8};
        Arrays.sort(numbers);   //1, 6, 8, 9
        System.out.println(Arrays.binarySearch(numbers, 6));    //1
        System.out.println(Arrays.binarySearch(numbers, 3));    //-2

        List<Integer> list = Arrays.asList(9, 7, 5, 3);
        Collections.sort(list);     //3, 5, 7, 9
        System.out.println(Collections.binarySearch(list, 3));  //0
        System.out.println(Collections.binarySearch(list, 2));  //-1


    }
}
