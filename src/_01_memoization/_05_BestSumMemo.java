package _01_memoization;

/*
 * Write a function howSum(targetSum, numbers) that takes in a targetSum and an array of numbers and arguments.
 * The function should return an array containing the shortest combination of numbers that add up to the targetSum.
 * If there is a tie for the shortest combination, you may return any one of the shortest.
 * */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _05_BestSumMemo {

    public static List<Integer> bestSum(int targetSum, int[] numbers) {
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        List<Integer> shortestCombination = null;
        for (var num : numbers) {
            var remainder = targetSum - num;
            var remainderResult = bestSum(remainder, numbers);
            if (remainderResult != null) {
                remainderResult.add(num);
                if (shortestCombination == null || remainderResult.size() < shortestCombination.size()) {
                    shortestCombination = remainderResult;
                }
            }
        }

        return shortestCombination;
    }

    public static List<Integer> bestSumMemo(int targetSum, int[] numbers) {
        return bestSumMemo(targetSum, numbers, new HashMap<>());
    }

    private static List<Integer> bestSumMemo(int targetSum, int[] numbers, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        List<Integer> shortestCombination = null;
        for (var num : numbers) {
            var remainder = targetSum - num;
            var remainderResult = bestSumMemo(remainder, numbers, memo);
            if (remainderResult != null) {
                var combination = new ArrayList<>(remainderResult);
                combination.add(num);
                if (shortestCombination == null || combination.size() < shortestCombination.size()) {
                    shortestCombination = combination;
                }
            }
        }

        memo.put(targetSum, shortestCombination);
        return shortestCombination;
    }

    public static void main(String[] args) {
        System.out.println(bestSumMemo(7, new int[]{5, 3, 4, 7})); // [7]
        System.out.println(bestSumMemo(8, new int[]{2, 3, 5})); // [5, 3]
        System.out.println(bestSumMemo(8, new int[]{1, 4, 5})); // [4, 4]
        System.out.println(bestSumMemo(100, new int[]{1, 2, 5, 25})); // [25, 25, 25, 25]
    }
}
