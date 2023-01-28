package com.vitaly.classes.computers;

import java.util.Comparator;

public class Computer {
    private int currentId;
    private static int id;
    private String name;
    private double power;

    public Computer(String name, double power) {
        this.name = name;
        this.power = power;
        this.currentId = ++id;
    }

    public int getCurrentId() {
        return currentId;
    }

    public String getName() {
        return name;
    }

    public double getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "currentId=" + currentId +
                ", name='" + name + '\'' +
                ", power=" + power +
                '}';
    }
}
