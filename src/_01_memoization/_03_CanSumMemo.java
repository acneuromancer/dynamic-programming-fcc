package _01_memoization;
/*
* Write a function canSum(targetSum, numbers) that takes in a targetSum and an array of numbers and arguments.
* The function should return a boolean indicating whether or not it is possible to generate the targetSum usint numbers
* from the array.
* You may use an element as many times as needed.
* You may assume thet all input numbers are nonnegative.
* */

import java.util.HashMap;

public class _03_CanSumMemo {
    public static boolean canSum(int targetSum, int[] numbers) {
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        for (var num : numbers) {
            var remainder = targetSum - num;
            if (canSum(remainder, numbers)) return true;
        }

        return false;
    }

    public static boolean canSumMemo(int targetSum, int[] numbers) {
        return canSumMemo(targetSum, numbers, new HashMap<>());
    }

    private static boolean canSumMemo(int targetSum, int[] numbers, HashMap<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        for (var num : numbers) {
            var remainder = targetSum - num;
            if (canSumMemo(remainder, numbers, memo)) {
                memo.put(targetSum, true);
                return true;
            }
        }

        memo.put(targetSum, false);
        return false;
    }


    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{2, 3})); // true
        System.out.println(canSum(7, new int[]{5, 3, 4, 7})); // true
        System.out.println(canSum(7, new int[]{2, 4})); // false
        System.out.println(canSum(8, new int[]{2, 3, 5})); // true
        System.out.println(canSumMemo(300, new int[]{7, 14})); // false
        System.out.println(canSumMemo(300, new int[]{7, 2})); // true
    }
}
