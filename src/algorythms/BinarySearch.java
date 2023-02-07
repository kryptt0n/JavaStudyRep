package algorythms;

public class BinarySearch {

    public static int search(int[] arr, int val) {

        int firstPointer = 0;
        int lastPointer = arr.length;
        int res = (lastPointer + firstPointer) / 2;
        while (firstPointer < lastPointer) {
            if (arr[res] < val) {
                firstPointer = res + 1;
            } else if (arr[res] > val) {
                lastPointer = res - 1;
            } else {
                break;
            }
            res = (lastPointer + firstPointer) / 2;
        }


        return res;
    }
}
