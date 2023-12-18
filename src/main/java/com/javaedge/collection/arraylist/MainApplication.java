package com.javaedge.collection.arraylist;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class MainApplication {
    public static void main(String args[]){
        List<test> list=new ArrayList<>();
        list.add(new test("1",new BigDecimal(2.1)));
        list.add(new test("1",new BigDecimal(2.2)));
        Collections.sort(list,(o1,o2)->o2.getB().compareTo(o1.getB()));
        //方法引用 遍历
        Stream.of(list).forEach(System.out::println);
    }
}
