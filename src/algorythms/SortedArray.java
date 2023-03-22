package algorythms;

import java.util.ArrayList;

public class SortedArray<T extends Comparable<T>> {
    private final ArrayList<T> array = new ArrayList<T>();
    private int size = 0;

    public T get(int index) {
        return array.get(index);
    }

    public int add(T value) {
        if (array.isEmpty()) {
            array.add(value);
            size++;
            return 0;
        } else {
            int index = 0;
            while (array.get(index).compareTo(value) < 0 && index < size) {
                index++;
            }
            array.add(index, value);
            size++;
            return index;
        }
    }

    public int size() {
        return size;
    }

    public T remove(int index) {
        return array.remove(index);
    }

    public boolean remove(T value) {
        return array.remove(value);
    }

    public void print() {
        array.forEach(value -> System.out.print(value + " "));
    }
}
