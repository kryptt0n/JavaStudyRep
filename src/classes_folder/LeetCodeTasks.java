package classes_folder;

import java.util.*;

public class LeetCodeTasks {
    public static int[] runningSum(int[] nums) {
        int sum = 0;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] + sum;
            sum = result[i];
        }
        return result;
    }

    public static int maximumWealth(int[][] accounts) {
        int wealth = 0;

        for (int[] person: accounts) {
            int current = 0;
            for (int bank: person) {
                current += bank;
            }
            if (current > wealth)
                wealth = current;
        }

        return wealth;
    }

    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }

    public static int numberOfSteps(int num) {
        int counter = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            counter++;
        }
        return counter;
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> dictRansom = new HashMap<>();
        HashMap<Character, Integer> dictMagazine = new HashMap<>();
        boolean contains = true;

        for (char ch: ransomNote.toCharArray()) {
            if (dictRansom.containsKey(ch)) {
                dictRansom.put(ch, dictRansom.get(ch) + 1);
            } else {
                dictRansom.put(ch, 1);
            }
        }

        for (char ch: magazine.toCharArray()) {
            if (dictMagazine.containsKey(ch)) {
                dictMagazine.put(ch, dictMagazine.get(ch) + 1);
            } else {
                dictMagazine.put(ch, 1);
            }
        }

        for (char ch: dictRansom.keySet()) {
            if (dictMagazine.containsKey(ch)) {
                if (dictMagazine.get(ch) < dictRansom.get(ch)) {
                    contains = false;
                    break;
                }
            } else {
                contains = false;
                break;
            }
        }

        return contains;
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCons = 0;
        int currentCons = 0;
        for (int i :nums) {
            if (i == 1)
                currentCons++;
            else {
                maxCons = Math.max(currentCons, maxCons);
                currentCons = 0;
            }
        }
        maxCons = Math.max(currentCons, maxCons);
        return maxCons;
    }

    public static int findNumbers(int[] nums) {
        int count = 0;

        for (int i :nums) {
            if (String.valueOf(i).length() % 2 == 0)
                count++;
        }

        return count;
    }

    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < res.length; i++) {
            res[i] = nums[i] * nums[i];
        }

        Arrays.sort(res);

        return res;
    }

    public static void duplicateZeros(int[] arr) {
        int[] array = new int[arr.length];

        int length = 0;

        for (int i = 0; i < arr.length; i++) {
            if (length >= arr.length)
                break;

            if (arr[i] != 0) {
                array[length] = arr[i];
                length++;
            } else {
                length += 2;
            }
        }

        for (int i = 0; i < array.length; i++) {
            arr[i] = array[i];
        }

    }

    /*
        Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < m + n; i++) {
            if (i < m)
                continue;
            nums1[i] = nums2[i-m];
        }
        Arrays.sort(nums1);
    }

    /*
        Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     */

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int second = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == target - first) {
                    second = j;
                    break;
            }}
            if (second != Integer.MAX_VALUE) {
                result[0] = i;
                result[1] = second;
            }

        }

        return result;
    }


}
