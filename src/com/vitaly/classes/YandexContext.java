package com.vitaly.classes;

import java.util.*;

public class YandexContext {
    public static void main(String[] args) {
        figureCount();
    }

    public static void figureCount() {
        int res = 0;
        Scanner scanner = new Scanner(System.in);
        int totalCount = scanner.nextInt();
        int perfectWeight = scanner.nextInt();
        int timer = scanner.nextInt();
        ArrayList<Map.Entry<Integer, Integer>> resMap = new ArrayList<>();

        HashMap<Integer, Integer> figures = new HashMap<>();
        for (int i = 0; i < totalCount; i++) {
            figures.put(i, Math.abs(scanner.nextInt() - perfectWeight));
        }

        Integer[] items = figures.values().toArray(new Integer[0]);
        Arrays.sort(items);

        for (int i = 0; i < items.length && timer > 0; i++) {
            Map.Entry<Integer, Integer> key = null;
            for (Map.Entry<Integer, Integer> entry : figures.entrySet()) {
                if (entry.getValue().equals(items[i])) {
                    key = entry;
                    break;
                }
            }
            int localCount;
            while ((localCount = key.getValue()) > 0 && timer > 0) {
                key.setValue(--localCount);
                --timer;
            }

            if (key.getValue() == 0) {
                resMap.add(key);
                res++;
            }

        }

        System.out.println(res);
        resMap.forEach(integerIntegerEntry -> System.out.print(integerIntegerEntry.getKey() + 1 + " "));
    }

    public static int keyboardCounter() {
        Scanner scanner = new Scanner(System.in);
        int res = 0;
        int temp = 0;
        int elemCount = scanner.nextInt();
        LinkedHashMap<Integer, Integer> elems = new LinkedHashMap<>();
        for (int i = 0; i < elemCount; i++) {
            elems.put(scanner.nextInt(), 0);
        }
        for (Map.Entry<Integer, Integer> entry : elems.entrySet()) {
            entry.setValue(scanner.nextInt());
        }
        int totalWords = scanner.nextInt();
        for (int i = 0; i < totalWords; i++) {
            int current = scanner.nextInt();
            if (i == 0)
                temp = elems.get(current);

            if (temp != elems.get(current)) {
                temp = elems.get(current);
                res++;
            }
        }

        return res;
    }
}
