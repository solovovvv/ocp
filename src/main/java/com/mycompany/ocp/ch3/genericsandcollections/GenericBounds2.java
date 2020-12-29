package com.mycompany.ocp.ch3.genericsandcollections;

import java.util.ArrayList;
import java.util.List;

public class GenericBounds2 {
    public static void main(String[] args) {

        //<?>
        List<?> list1 = new ArrayList<B>();     //если указываем в ссылке ?, в new объекте можно указать тип любой
        for (Object o : list1) {    //в foreach указываем Object
            System.out.println((B) o); //здесь делаем явный каст
        }

        //Upper-Bounded Wildcards <? extends _______>
        List<? extends A> list2 = new ArrayList<A>();   //если указываем в ссылке ? extends, в new объекте можно указать этот или потомки
        List<? extends B> list3 = new ArrayList<C>();   //если указываем в ссылке ? extends, в new объекте можно указать этот или потомки

        //Lower-Bounded Wildcards <? super _______>
        List<? super A> list4 = new ArrayList<Object>();      //если указываем в ссылке ? super, в new объекте можно указать этот или суперкласс
        List<? super B> list5 = new ArrayList<A>();  //если указываем в ссылке ? super, в new объекте можно указать этот или суперкласс


    }

    static class A {}
    static class B extends A {}
    static class C extends B {}

    public <T> T method1(List<? extends T> list) {
        return list.get(0);
    }

    

}
