package algorythms;

public class InsertationSort {
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            while (i > 0 && arr[i - 1] > val) {
                arr[i] = arr[i - 1];
                i--;
            }
            arr[i] = val;
        }
    }
}
