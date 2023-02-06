package leetcode;

import java.util.*;

public class EasyPeasy {
    public static boolean palindromeNumber(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        int init = 0;

        while (init < x) {
            init = init * 10 + (x % 10);
            x /= 10;
        }

        return init == x || init / 10 == x;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numbers = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (numbers.containsKey(temp)) {
                result[0] = i;
                result[1] = numbers.get(temp);
            }
            else
                numbers.put(nums[i], i);
        }
       return result;
    }
}
