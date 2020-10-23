package com.mycompany.ocp.ch1.advancedclassdesign.overloadingandoverriding;

public class Bobcat {
    public void findDen() {}
}

class BobcatKitten extends Bobcat {
    public void findDen() {}    //overriding
    public void findDen(boolean b) {}   //overloading
    public int findden() throws Exception {return 1;}    //not overriding and overloading
}
