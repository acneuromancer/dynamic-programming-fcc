package _01_memoization;
/*
 * Write a function allConstruct(target, wordBank) that accepts a target string and an array of strings.
 * The function should return a 2D array containing all of the ways that the target can be constructed by concatenating
 * elements of the wordBank array. Each element of the 2D array should represent one combination that constructs the
 * target.
 * You may reuse elements of wordBank as many times as needed.
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _08_AllConstructMemo {

    public static List<ArrayList<String>> allConstruct(String target, String[] wordBank) {
        if (target.isEmpty()) {
            var empty = new ArrayList<ArrayList<String>>();
            empty.add(new ArrayList<>());
            return empty;
        }

        var result = new ArrayList<ArrayList<String>>();
        for (var word : wordBank) {
            if (target.indexOf(word) == 0) {
                var suffix = target.substring(word.length());
                var suffixWays = allConstruct(suffix, wordBank);
                for (var elem : suffixWays) {
                    elem.add(0, word);
                    result.add(elem);
                }
            }
        }

        return result;
    }

    public static List<ArrayList<String>> allConstructMemo(String target, String[] wordBank) {
        return allConstructMemo(target, wordBank, new HashMap<>());
    }

    private static List<ArrayList<String>> allConstructMemo(String target, String[] wordBank,
                                                            HashMap<String, List<ArrayList<String>>> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target.isEmpty()) {
            var empty = new ArrayList<ArrayList<String>>();
            empty.add(new ArrayList<>());
            return empty;
        }

        var result = new ArrayList<ArrayList<String>>();
        for (var word : wordBank) {
            if (target.indexOf(word) == 0) {
                var suffix = target.substring(word.length());
                var suffixWays = allConstructMemo(suffix, wordBank, memo);
                for (var elem : suffixWays) {
                    var newElem = new ArrayList<>(elem);
                    newElem.add(0, word);
                    result.add(newElem);
                }
            }
        }

        memo.put(target, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(allConstructMemo("purple", new String[] { "purp", "p", "ur", "le", "purpl" }));
        // [['purp', 'le'], ['p', 'ur', 'p', 'le']]

        System.out.println(allConstructMemo("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd", "ef", "c" }));
        // [ ['ab', 'cd', 'ef'], ['ab', 'c', 'def'], ['abc', 'def'], ['abcd', 'ef'] ]

        System.out.println(allConstructMemo("skateboard",
                new String[] {"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        // []

        System.out.println(allConstructMemo("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaz",
                new String[] { "a", "aa", "aaaa", "aaaaa" })); // []
    }
}
