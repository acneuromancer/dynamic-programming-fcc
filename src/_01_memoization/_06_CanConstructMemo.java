package _01_memoization;

import java.util.HashMap;
import java.util.Map;

/*
 * Write a function canConstruct(target, wordBank) that accepts a target string and an array of strings.
 * The function should return a boolean indicating whether or not the target can be constructed by concatenating elements
 * of the wordBank array.
 * You may reuse elements of wordBank as many times as needed.
 * */
public class _06_CanConstructMemo {

    public static boolean canConstruct(String target, String[] wordBank) {
        if (target.isEmpty()) return true;
        for (var word : wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                if (canConstruct(suffix, wordBank)) return true;
            }
        }

        return false;
    }

    public static boolean canConstructMemo(String target, String[] wordBank) {
        return canConstructMemo(target, wordBank, new HashMap<>());
    }

    private static boolean canConstructMemo(String target, String[] wordBank, Map<String, Boolean> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target.isEmpty()) return true;

        for (var word : wordBank) {
            if (target.indexOf(word) == 0) {
                var suffix = target.substring(word.length());
                if (canConstructMemo(suffix, wordBank, memo)) {
                    memo.put(target, true);
                    return true;
                }
            }
        }

        memo.put(target, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canConstructMemo("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"})); // true
        System.out.println(canConstructMemo("skateboard", new String[]{"bo","rd","ate","t",
                "ska",
                "sk",
                "boar"
        })); // false
        System.out.println(canConstructMemo("enterapotentpot",
                new String[]{"a", "p", "ent", "enter", "ot", "o", "t"})); // true
        System.out.println(canConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e",
                "ee",
                "eee",
                "eeee",
                "eeeee",
                "eeeeee"})); // false
    }
}
