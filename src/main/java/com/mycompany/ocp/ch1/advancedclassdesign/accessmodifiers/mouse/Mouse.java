package com.mycompany.ocp.ch1.advancedclassdesign.accessmodifiers.mouse;

import com.mycompany.ocp.ch1.advancedclassdesign.accessmodifiers.cat.BigCat;

public class Mouse {
    public static void main(String[] args) {
        BigCat bigCat = new BigCat();
        System.out.println(bigCat.name);
    }
}
