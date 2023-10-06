package _02_tabulation;

public class _07_CountConstructTabulation {

    public static int countConstruct(String target, String[] wordBank) {
        int[] table = new int[target.length() + 1];
        table[0] = 1;

        for (var i = 0; i <= target.length(); i++) {
            for (var word: wordBank) {
                if (i + word.length() > target.length()) continue;
                if (target.substring(i, i + word.length()).equals(word)) {
                    table[i + word.length()] += table[i];
                }
            }
        }

        return table[target.length()];
    }


    public static void main(String[] args) {
        System.out.println(countConstruct("purple", new String[] { "purp", "p", "ur", "le", "purpl" })); // 2
        System.out.println(countConstruct("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" })); // 1
        System.out.println(countConstruct("skateboard",
                new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" })); // 0
        System.out.println(countConstruct("enterapotentpot",
                new String[] { "a", "p", "ent", "enter", "ot", "o", "t", })); // 4
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[] { "e", "ee", "eee", "eeee", "eeeee", "eeeeee", })); // 0
    }
}
