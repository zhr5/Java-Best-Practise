package com.javaedge.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class MainApplication {

    private static Pattern p_fg=Pattern.compile("(?i).*(J1|JM|GM|G)$"); //正则
    public static void main(String args[]){
        List<test> list=new ArrayList<>();
        list.add(new test("第一个J1"));
        list.add(new test("第二个JM"));
        list.add(new test("第三个GM"));
        list.add(new test("第四个G"));
        list.add(new test("还个-G"));
        list.add(new test("最后个-GM"));
        list.stream().filter(a->!p_fg.matcher(a.getName()).matches()).forEach(System.out::println);;
    }
}
