package classes_folder;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeetCodeTasks {
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          public TreeNode(int val) { this.val = val; }
          public TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }

          @Override
          public String toString() {
              return "Value = " + val;
          }
      }
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

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character character :s.toCharArray()) {
            if (character.equals(')') && !stack.isEmpty() && stack.peek().equals('('))
                stack.pop();
            else if (character.equals(']') && !stack.isEmpty() && stack.peek().equals('[')) {
                stack.pop();
            } else if (character.equals('}') && !stack.isEmpty() && stack.peek().equals('{')) {
                stack.pop();
            } else {
                stack.push(character);
            }
        }

        return stack.isEmpty();
    }

    public static class ListNode {
        int val;
        public ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode listNode = res;

        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        if (list1.val > list2.val) {
            listNode.val = list2.val;
            list2 = list2.next;
        } else {
            listNode.val = list1.val;
            list1 = list1.next;
        }

        while (list1 != null && list2 != null) {
            ListNode temp = new ListNode();
            if (list1.val > list2.val) {
                temp.val = list2.val;
                list2 = list2.next;
            } else {
                temp.val = list1.val;
                list1 = list1.next;
            }

            listNode.next = temp;
            listNode = temp;
        }

        while (list1 != null) {
            ListNode temp = new ListNode(list1.val);
            listNode.next = temp;
            list1 = list1.next;
        }

        while (list2 != null) {
            ListNode temp = new ListNode(list2.val);
            listNode.next = temp;
            listNode = temp;
            list2 = list2.next;
        }

        return res;
    }

    public static boolean isAnagram(String s, String t) {

        for (char ch: s.toCharArray()) {
            if (t.contains(String.valueOf(ch)))
                t = t.replaceFirst(String.valueOf(ch), "");
            else
                return false;
        }

        return t.isEmpty();
    }

    /** Count number of 1's in int number
     *
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
//        String temp = Integer.toBinaryString(n);
//        int count = 0;
//        temp.chars().filter(value -> value == '1').count();
//
//        return (int)temp.chars().filter(value -> value == '1').count();

        return n == 0 ? 0 : (n & 1) + hammingWeight(n >> 1);
    }


    /**
     * Your given an array of ints [0..n] n = nums.length
     * Find the missing number
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int totalSum =  nums.length * (nums.length - 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            totalSum -= nums[i];
        }
        return totalSum;
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> numbers = new HashMap<>();
        int max = nums.length;
        for (int i = 0; i < max; i++) {
            if (numbers.containsKey(nums[i])) {
                int local = numbers.get(nums[i]);
                numbers.put(nums[i], ++local);
                if (local > max / 2)
                    return nums[i];
            } else {
                numbers.put(nums[i], 1);
                if (1 > max / 2)
                    return nums[i];
            }
        }
        return 0;
    }

    /**
     * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     * <p>
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        int res = 0;
        for (int i :nums) {
            res ^= i;
        }

        return res;
    }


    /**
     * Write a function that reverses a string. The input string is given as an array of characters s.
     *<p>
     * You must do this by modifying the input array in-place with O(1) extra memory.
     * @param s
     */
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }

    /**
     * Given a string s consisting of words and spaces, return the length of the last word in the string.
     *
     * A word is a maximal
     * substring
     *  consisting of non-space characters only.
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        String[] arr = s.trim().split(" ");
        return arr[arr.length - 1].length();
    }

    /**
     * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each
     * unique element appears only once. The relative order of the elements should be kept the same.
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int result = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[result++] = nums[i];
            }
        }

        return result;
    }

    /**
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     */
    public int maxProfit(int[] prices) {

        if (prices.length == 0)
            return 0;
        int profit = 0;
        int minVal = prices[0];

        for (int price :prices) {
            if (price < minVal) {
                minVal = price;
                continue;
            }
            profit = Math.max(price - minVal, profit);
        }


        return profit;
    }

    public void moveZeroes(int[] nums) {
        int lastPointer = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == lastPointer)
                break;
            if (nums[i] == 0) {
                int temp = nums[lastPointer];
                nums[lastPointer] = nums[i];
                nums[i] = lastPointer;
                lastPointer--;
                i--;
            }
        }
    }

    /**
     * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
     * The relative order of the elements may be changed.
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[res] = nums[i];
                res++;
            }
        }

        return res;
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        int carry = 0;
        while (i < a.length() || j < b.length()) {
            int sum = carry;
            if (i < a.length()) {
                sum += a.charAt(a.length() - i++ - 1) - '0';
            }
            if (j < b.length()) {
                sum += b.charAt(b.length() - j++ - 1) - '0';
            }
            carry = sum > 1 ? 1 : 0;
            sb.insert(0,sum % 2);
        }
        if (carry == 1)
            sb.insert(0, carry);
        return sb.toString();
    }

    public static boolean isPalindrome(String s) {


        String clean = s.replaceAll("\\W|_", "").toLowerCase();
        int i = 0;
        int j = clean.length() - 1;
        while (i < j) {
            if (clean.charAt(i++) != clean.charAt(j--)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isHappy(int n) {
        int res = 0;
        Set<Integer> unique = new HashSet<>();
        while (res != 1) {
            res = 0;
            while (n > 0) {
                res += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (unique.contains(res)) {
                return false;
            } else {
                unique.add(res);
                n = res;
            }
        }

        return true;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        if (root.left == null && root.right == null) {
            result.add(root.val);
            return result;
        }

        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);

        result.addAll(left);
        result.add(root.val);
        result.addAll(right);

        return result;
    }

    /**
     * Excel title counter
     * @param columnTitle
     * @return
     */
    public static int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            result += (columnTitle.charAt(columnTitle.length() - 1 - i) - 64) * Math.pow(26, i);
        }
        return result;
    }

    /**
     * Function from API to determine bad version
     * @return
     */
    private static boolean isBadVersion(int version) {
        return version >= 1702766719;
    }

    public static int firstBadVersion(int n) {
        long left = 1;
        long result = (n + 1) / 2;

        if (left == n)
            return 1;

        while (left <= n) {
            if (isBadVersion((int)result)) {
                n = (int)(result - 1);
            } else {
                left = (int)(result + 1);
            }
            result = (left + n) / 2;
        }

        return (int)result + 1;
    }

}
