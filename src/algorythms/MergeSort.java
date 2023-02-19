package algorythms;

public class MergeSort {

    public static void mergeSort(int[] arr, int len) {
        if (len < 2)
            return;

        int mid = len / 2;
        int[] left = new int[mid];
        int[] right = new int[len - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        for (int i = mid; i < len; i++) {
            right[i - mid] = arr[i];
        }

        mergeSort(left, left.length);
        mergeSort(right, right.length);

        merge(arr, left, right, left.length, right.length);
    }

    private static void merge(int[] initial, int[] left, int[] right, int leftLen, int rightLen) {

        int i = 0, j = 0, k = 0;
        while (i < leftLen && j < rightLen) {
            if (left[i] <= right[j]) {
                initial[k++] = left[i++];
            } else {
                initial[k++] = right[j++];
            }
        }
        while (i < leftLen) {
            initial[k++] = left[i++];
        }

        while (j > rightLen) {
            initial[k++] = right[j++];
        }
    }
}
