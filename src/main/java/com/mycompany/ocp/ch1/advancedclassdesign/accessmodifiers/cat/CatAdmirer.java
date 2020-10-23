package com.mycompany.ocp.ch1.advancedclassdesign.accessmodifiers.cat;

public class CatAdmirer {
    public static void main(String[] args) {
        BigCat bigCat=new BigCat();
        System.out.println(bigCat.name);
        System.out.println(bigCat.hasFur);
        System.out.println(bigCat.hasPaws);
        //если в одном пакете, то можно использовать public, protected и default package access
    }
}
