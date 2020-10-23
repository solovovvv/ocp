package com.mycompany.ocp.ch1.advancedclassdesign.imports;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;


public class ListHelper {
    public List<String> copyAndSortList(List<String> original) {
        List<String> list=new ArrayList<>(original);
        sort(list);
        return list;
    }
}
