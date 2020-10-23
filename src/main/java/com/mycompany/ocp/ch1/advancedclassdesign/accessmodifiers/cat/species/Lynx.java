package com.mycompany.ocp.ch1.advancedclassdesign.accessmodifiers.cat.species;

import com.mycompany.ocp.ch1.advancedclassdesign.accessmodifiers.cat.BigCat;

public class Lynx extends BigCat {
    public static void main(String[] args) {
        BigCat bigCat = new BigCat();
        System.out.println(bigCat.name);
        //если в другом пакете и класс не наследник только public можно использовать
    }
}
