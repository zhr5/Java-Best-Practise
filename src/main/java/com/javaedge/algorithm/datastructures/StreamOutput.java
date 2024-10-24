package com.javaedge.algorithm.datastructures;

import java.util.ArrayList;
import java.util.List;

public class StreamOutput {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> innerList1 = new ArrayList<>();
        innerList1.add(1);
        lists.add(innerList1);

        List<Integer> innerList2 = new ArrayList<>();
        innerList2.add(2);
        innerList2.add(3);
        lists.add(innerList2);

        lists.stream()
                .forEach(list -> {
                    list.stream()
                            .forEach(integer -> System.out.print(integer + " "));
                    System.out.println();
                });
    }
}
