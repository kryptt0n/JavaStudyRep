package com.vitaly.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericExercises {
    public static void main(String[] args) {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        Collections.addAll(first, 1,2,3,2,5,1,2);
        Collections.addAll(second, 999,888,777,666);
//        exchangeFirstVals(first, second);
        System.out.println(max(first, 1, 6));
        Node<String> node = new Node<>();
        Comparable<String> comp = node;
    }

    public static <T extends Number> int countEvens(List<T> list) {
        int count = 0;
        for (T elem: list) {
            if (elem.intValue() % 2 == 0)
                count++;
        }

        return count;
    }

    public static <T extends Comparable> T max(T first, T second) {
        return first.compareTo(second) > 0 ? first : second;
    }

    public static <T> void exchangeFirstVals(List<T> first, List<T> second) {
        T temp = first.get(0);
        first.set(0, second.get(0));
        second.set(0, temp);
    }

    public static void print(List<? extends Number> list) {
        for (Number n : list)
            System.out.print(n + " ");
        System.out.println();
    }

    public static <T extends Comparable> T max(List<T> list, int begin, int end) {
        T max = list.get(begin);

        for (int i = begin; i < end; i++) {
            if (list.get(i).compareTo(max) > 0)
                max = list.get(i);
        }

        return max;
    }




}
class Node<T> implements Comparable<T> {
    public int compareTo(T obj) { return 1; }
    // ...
}