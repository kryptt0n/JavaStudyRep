package com.vitaly.classes;

import java.util.*;

public class Generics {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Hello", " world", "!!!");
//        CheckList<List> stringCheck = new CheckList<>(list);
//        stringCheck.printValues();

        MyNode myNode = new MyNode();
        myNode.setData(5);
        TypicalNode node = myNode;
        node.setData("gee");


    }

    private static class CheckList<T extends MyHashMap,Collection> {
        T value;

        public CheckList(T value) {
            this.value = value;
        }

        public void printType() {
            System.out.println(this.value.getClass().getSimpleName());
        }

        public void printValues() {

        }

    }

}

class MyHashMap<K, V> {

    private Set<Pair<K, V>> entrySet = new HashSet<>();

    public void put(K key, V value) {
        entrySet.add(new Pair<>(key, value));
    }

    public V getValue(K key) {
        for (Pair<K, V> kvPair :entrySet) {
            if (kvPair.getKey().equals(key))
                return kvPair.getValue();
        }

        return null;
    }

    public void printValues() {
        entrySet.forEach(System.out::println);
    }

    public static void countSum(List<? extends Number> val) {
        int res = 0;
        for (Number number :val) {
            res += number.intValue();
        }

        System.out.println(res);
    }

    public static void printElems(List<?> val) {
        for (Object o :val) {
            System.out.println(val);
        }

    }

}

class Pair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Pair of {" + key + "}: " + value;
    }
}

class Test<X> {
    public <T>Test(T t) {
    }
}

class TypicalNode<T> {
    T data;

    public void setData(T data) {
        this.data = data;
    }
}

class MyNode extends TypicalNode<Integer> {

    @Override
    public void setData(Integer data) {
        super.setData(data);
    }
}

