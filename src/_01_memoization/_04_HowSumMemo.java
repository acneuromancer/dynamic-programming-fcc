package _01_memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Write a function howSum(targetSum, numbers) that takes in a targetSum and an array of numbers and arguments.
 * The function should return an array containing any combination of elements that add up to exactly the targetSum.
 * If there is no combination that adds up to the targetSum, then return null.
 * If there are multiple combinations possible, you may return any single one.
 * */
public class _04_HowSumMemo {
    public static List<Integer> howSum(int targetSum, int[] numbers) {
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        for (var num : numbers){
            var remainder = targetSum - num;
            var remainderResult = howSum(remainder, numbers);
            if (remainderResult != null) {
                remainderResult.add(num);
                return remainderResult;
            }
        }

        return null;
    }

    public static List<Integer> howSumMemo(int targetSum, int[] numbers) {
        return howSumMemo(targetSum, numbers, new HashMap<>());
    }

    private static List<Integer> howSumMemo(int targetSum, int[] numbers, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        for (var num : numbers) {
            var remainder = targetSum - num;
            var remainderResult = howSumMemo(remainder, numbers, memo);
            if (remainderResult != null) {
                remainderResult.add(num);
                memo.put(targetSum, remainderResult);
                return remainderResult;
            }
        }

        memo.put(targetSum, null);
        return null;
    }

    public static void main(String[] args) {
        System.out.println(howSum(7, new int[]{2, 3})); // [3, 2, 2]
        System.out.println(howSum(7, new int[]{5, 3, 4, 7})); // [4, 3]
        System.out.println(howSum(7, new int[]{2, 4})); // null
        System.out.println(howSum(8, new int[]{2, 3, 5})); // [2, 2, 2, 2]
        System.out.println(howSum(300, new int[]{150, 7, 14})); // [150, 150]
        System.out.println(howSumMemo(300, new int[]{7, 14})); // null
    }
}
