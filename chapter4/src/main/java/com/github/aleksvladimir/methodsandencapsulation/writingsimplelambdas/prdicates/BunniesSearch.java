package com.github.aleksvladimir.methodsandencapsulation.writingsimplelambdas.prdicates;

/*
В Java 8 даже интегрированы интерфейсы предикатав некоторые существующие классы. Вам нужно
знать только одно для экзамена. ArrayList объявляет метод removeIf(), который принимает
предикат.

Java 8 even integrated the Predicate interface into some existing classes. There is only
one you need to know for the exam. ArrayList declares a removeIf() method that takes a
Predicate.
 */

import java.util.List;
import java.util.ArrayList;

public class BunniesSearch {
    public static void main(String[] arg) {
        List<String> bunnies = new ArrayList<>();
        bunnies.add("long ear");
        bunnies.add("floppy");
        bunnies.add("hoppy");
        System.out.println(bunnies); // [long ear, floppy, hoppy]
        bunnies.removeIf(s -> s.charAt(0) != 'h');
        System.out.println(bunnies); // [hoppy]
    }
}
