package _02_tabulation;

public class _06_CanConstructTabulation {
    public static boolean canConstruct(String target, String[] wordBank) {
        boolean[] table = new boolean[target.length() + 1];
        table[0] = true;

        for (var i = 0; i <= target.length(); i++) {
            if (table[i]) {
                for (var word: wordBank) {
                    if (i + word.length() > target.length()) continue;
                    if (target.substring(i, i + word.length()).equals(word)) {
                        table[i + word.length()] = true;
                    }
                }
            }
        }

        return table[target.length()];
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" })); // true
        System.out.println(canConstruct("skateboard",
                new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" })); // false
        System.out.println(canConstruct("enterapotentpot",
                new String[] { "a", "p", "ent", "enter", "ot", "o", "t" })); // true
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[] { "e", "ee", "eee", "eeee", "eeeee", "eeeeee", })); // false
    }
}
