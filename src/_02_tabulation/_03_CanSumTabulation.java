package _02_tabulation;

public class _03_CanSumTabulation {

    public static boolean canSum(int targetSum, int[] numbers) {
        boolean[] table = new boolean[targetSum + 1];
        table[0] = true;

        for (var i = 0; i <= targetSum; i++) {
            if (table[i]) {
                for (var num : numbers) {
                    if (i + num <= targetSum) table[i + num] = true;
                }
            }
        }

        return table[targetSum];
    }

    public static void main(String[] args) {
        System.out.println(canSum(7, new int[] { 2, 3 })); // true
        System.out.println(canSum(7, new int[] { 5, 3, 4, 7 })); // true
        System.out.println(canSum(7, new int[] { 2, 4 })); // false
        System.out.println(canSum(8, new int[] { 2, 3, 5 })); // true
        System.out.println(canSum(300, new int[] { 7, 14 })); // false
    }
}
