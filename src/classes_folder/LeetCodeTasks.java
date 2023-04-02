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

    public static int[] twoSumEasy(int[] nums, int target) {
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
    public static int hammingWeightOld(int n) {
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

    /**
     * Given an integer array nums, move all 0's to the end of it
     * while maintaining the relative order of the non-zero elements.
     *
     * Note that you must do this in-place without making a copy of the array.
     * @param nums
     */

    public void moveZeroes(int[] nums) {
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pointer++] = nums[i];
            }
        }

        for (int i = 0; i <= nums.length - pointer - 1; i++) {
            nums[nums.length - i - 1] = 0;
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

    /**
     * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] result = new int[nums.length];
        for (int i = 0; i < k; i++) {
            result[i] = nums[nums.length - k + i];
        }

        for (int i = 0; i <= nums.length - k - 1; i++) {
            result[i + k] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        int firstPointer = 0;
        int secondPointer = numbers.length - 1;

        int temp = numbers[firstPointer] + numbers[secondPointer];
        while (temp != target) {
            if (temp > target) {
                secondPointer--;
            } else {
                firstPointer++;
            }
            temp = numbers[firstPointer] + numbers[secondPointer];
        }
        result[0] = ++firstPointer;
        result[1] = ++secondPointer;
        return result;
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        for (String s1 :s.split(" ")) {
            StringBuilder temp = new StringBuilder(s1);
            sb.append(temp.reverse()).append(" ");
        }


        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static ListNode middleNode(ListNode head) {
        int counter = 0;
        ListNode result = head;
        int middle = 0;

        while (head != null) {
            if (++counter / 2 > middle) {
                result = result.next;
                middle = counter / 2;
            }
            head = head.next;
        }


        return result;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = head;
        ArrayList<ListNode> arrayList = new ArrayList<>();

        while (head != null) {
            arrayList.add(head);
            head = head.next;
        }

        int index = arrayList.size() - n;

        if (index == 0)
            return res.next;

        if (n == 1) {
            arrayList.get(arrayList.size() - 2).next = null;
        } else {
            arrayList.get(index - 1).next = arrayList.get(index + 1);
        }

        return res;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    public static boolean checkInclusion(String s1, String s2) {

        HashMap<Character, Integer> initMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            int num = initMap.getOrDefault(s1.charAt(i), 0);
            initMap.put(s1.charAt(i), ++num);
        }
        int counter = 0;

        HashMap<Character, Integer> testMap = new HashMap<>(initMap);

        for (int i = 0; i < s2.length(); i++) {
            Character ch = s2.charAt(i);
            if (testMap.containsKey(ch)) {
                int num = testMap.get(ch);
                if (num == 1) {
                    testMap.remove(ch);
                } else {
                    testMap.put(ch, --num);
                }
            } else {
                if (counter < initMap.get(ch)) {
                    testMap.put(ch, ++counter);
                }
                testMap = new HashMap<>(initMap);
            }

            if (testMap.isEmpty()) {
                return true;
            }
        }

        return false;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;

        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }

        return newHead;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode result = head;

        while (head != null) {
            ListNode next = head.next;

            if (head.val == next.val) {
                head.next = next.next;
            } else {
                head = next;
            }
        }

        return result;
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static boolean isPowerOfTwo(int n) {
        return n < 0 && Integer.bitCount(n) == 1;
    }

    public static int hammingWeight(int n) {
        int ones = 0;

        while (n != 0) {
            ones += n & 1;
            n = n >>> 1;
        }
        return ones;
    }

    public static int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += n & 1;
            n >>= 1;
        }

        return result;
    }

    public static int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            result[i] = Integer.bitCount(i);
        }

        return result;
    }

    public static int fib(int n) {
        int a = 0;
        int b = 1;
        int result = 1;
        if (n == 1)
            return a;

        if (n == 2)
            return b;

        while (n > 2) {
            result = a + b;
            a = b;
            b = result;
            n--;
        }

        return result;
    }

    public static boolean isPowerOfThree(int n) {
        long res = 1;

        if (n <= 2)
            return false;

        if (n == 3)
            return true;

        while (res < n) {
            res *= 3;
            if (res == n)
                return true;
        }

        return false;

    }

    public boolean isPalindrome(ListNode head) {
        int counter = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();

        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
            counter++;
        }

        for (int i = 0; i < counter / 2; i++) {
            if (arrayList.get(i) != arrayList.get(counter - i - 1))
                return false;
        }

        return true;
    }

    public static int firstUniqChar(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int result = -1;

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 0);
                result = i;
            } else {
                map.put(ch, map.get(ch) + 1);
                result = -1;
            }
        }

        return result;
    }

    public static boolean divisorGame(int n) {
        return n % 2 == 0;
    }

    public static void deleteNode(ListNode node) {

        while (node != null && node.next != null) {
            ListNode next = node.next;
            node.val = next.val;
            if (next.next == null) {
                node.next = null;
            }
            node = next;
        }
    }

    private static void deleteNodeAlternative(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 1) {
            result.add(new ArrayList<>() {{add(nums[0]);}});
            return result;
        }



        return result;
    }

    // TODO: 02.04.2023 Finish the implementation
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        ArrayList<Integer> result = new ArrayList<>();
        int temp = arr[0];
        int firstPointer = 0;
        int lastPointer = 1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > n) {
                sum -= temp;
                temp = arr[++firstPointer];
            }

            if (sum == s) {
                Collections.addAll(result, firstPointer - 1, i);
                return result;
            }
        }

        result.add(-1);
        return result;
    }

    public static int maxDAC(int[] arr, int index, int length) {
        if (length - 1 == 0) {
            return index;
        }

        if (length - index == 0) {
            return arr[index] > arr[index + 1] ? index : index + 1;
        }

        int max = maxDAC(arr, index + 1, length - 1);

        return arr[index] > arr[max] ? index : max;

    }



}
