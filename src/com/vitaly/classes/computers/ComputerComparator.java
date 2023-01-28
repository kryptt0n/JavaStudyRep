package com.vitaly.classes.computers;

import java.util.Comparator;

public class ComputerComparator implements Comparator<Computer> {

    public Type comparatorType;

    public enum Type {
        ID,
        NAME,
        POWER
    }

    public Type getComparatorType() {
        return comparatorType;
    }

    public void setComparatorType(Type comparatorType) {
        this.comparatorType = comparatorType;
    }


    public ComputerComparator(Type comparatorType) {
        this.comparatorType = comparatorType;
    }

    @Override
    public int compare(Computer o1, Computer o2) {
        switch (comparatorType) {
            case ID:
                return Integer.compare(o1.getCurrentId(), o2.getCurrentId());
            case NAME:
                return String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName());
            case POWER:
                return Double.compare(o1.getPower(), o2.getPower());
            default:
                throw new IllegalStateException("Unexpected value: " + comparatorType);
        }
    }
}