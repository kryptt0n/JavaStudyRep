package algorythms;

public class SortingAlgorythms {

    public static void insertationSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            while (i > 0 && arr[i - 1] > val) {
                arr[i] = arr[i - 1];
                i--;
            }
            arr[i] = val;
        }
    }

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

    public static void quickSort(int[] arr, int start, int end) {
        if (end - start < 1) return;
        int i = start;
        int j = end;
        int mid = i + (j - i) / 2;
        int pivot = arr[mid];

        while (i <= j) {
            while (arr[i] < pivot) {i++;}
            while (arr[j] > pivot) {j--;}

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        quickSort(arr, start, j);
        quickSort(arr, i, end);

    }
}
