package _02_tabulation;

import java.util.ArrayList;
import java.util.List;

public class _08_AllConstructTabulation {

    public static List<List<String>> allConstruct(String target, String[] wordBank) {
        List<List<List<String>>> table = new ArrayList<>();
        for (var i = 0; i <= target.length(); i++) table.add(new ArrayList<>());
        table.get(0).add(new ArrayList<>());

        for (var i = 0; i <= target.length(); i++) {
            for (var word : wordBank) {
                if (i + word.length() > target.length()) continue;
                if (target.substring(i, i + word.length()).equals(word)) {
                    var oldCombinations = new ArrayList<>(table.get(i));
                    var newDestination = table.get(i + word.length());
                    for (var elem: oldCombinations) {
                        var newElem = new ArrayList<>(elem);
                        newElem.add(word);
                        newDestination.add(newElem);
                    }
                }
            }
        }

        return table.get(target.length());
    }

    public static void main(String[] args) {
        System.out.println(allConstruct("purple", new String[] { "purp", "p", "ur", "le", "purpl" }));
        // [ ['purp', 'le'], ['p', 'ur', 'p', 'le'] ]

        System.out.println(allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"}));
        // [ ['ab', 'cd', 'ef'], ['ab', 'c', 'def'], ['abc', 'def'], ['abcd', 'ef'] ]

        System.out.println(allConstruct("skateboard",
                new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"})); // []

        System.out.println(allConstruct("aaaaaaaaaaaaaaz",
                new String[]{"a", "aa", "aaaa", "aaaaa"})); // []
    }
}
