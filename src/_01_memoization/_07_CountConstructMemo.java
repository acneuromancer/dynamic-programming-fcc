package _01_memoization;
/*
 * Write a function countConstruct(target, wordBank) that accepts a target string and an array of strings.
 * The function should return the number of ways that the target can be constructed by concatenating elements
 * of the wordBank array.
 * You may reuse elements of wordBank as many times as needed.
 * */

import java.util.HashMap;

public class _07_CountConstructMemo {

    public static int countConstruct(String target, String[] wordBank) {
        if (target.isEmpty()) return 1;

        var totalCount = 0;
        for (var word : wordBank) {
            if (target.indexOf(word) == 0) {
                var numWaysOfRest = countConstruct(target.substring(word.length()), wordBank);
                totalCount += numWaysOfRest;
            }
        }

        return totalCount;
    }

    public static int countConstructMemo(String target, String[] wordBank) {
        return countConstructMemo(target, wordBank, new HashMap<>());
    }

    private static int countConstructMemo(String target, String[] wordBank, HashMap<String, Integer> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target.isEmpty()) return 1;

        var totalCount = 0;
        for (var word : wordBank) {
            if (target.indexOf(word) == 0) {
                var numWaysOfRest = countConstructMemo(target.substring(word.length()), wordBank, memo);
                totalCount += numWaysOfRest;
            }
        }

        memo.put(target, totalCount);
        return totalCount;
    }

    public static void main(String[] args) {
        System.out.println(countConstruct("purple", new String[] { "purp", "p", "ur", "le", "purpl" })); // 2
        System.out.println(countConstruct("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" })); // 1
        System.out.println(countConstruct("skateboard",
                new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" })); // 0
        System.out.println(countConstruct("enterapotentpot",
                new String[] { "a", "p", "ent", "enter", "ot", "o", "t", })); // 4
        System.out.println(countConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[] { "e", "ee", "eee", "eeee", "eeeee", "eeeeee", })); // 0
    }
}
