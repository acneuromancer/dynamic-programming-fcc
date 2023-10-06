package _02_tabulation;

import java.util.ArrayList;
import java.util.List;

public class _05_BestSumTabulation {

    public static List<Integer> bestSum(int targetSum, int[] numbers) {
        var table = new ArrayList<ArrayList<Integer>>();
        for (var i = 0; i <= targetSum; i++) {
            if (i == 0) table.add(new ArrayList<>());
            else table.add(null);
        }

        for (var i = 0; i <= targetSum; i++) {
            if (table.get(i) != null) {
                for (var num : numbers) {
                    var combination = new ArrayList<>(table.get(i));
                    combination.add(num);
                    if (i + num <= targetSum) {
                        if (table.get(i + num) == null
                                || table.get(i + num).size() > combination.size()) {
                            table.set(i + num, combination);
                        }
                    }
                }
            }
        }

        return table.get(targetSum);
    }

    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[] { 5, 3, 4, 7 })); // [7]
        System.out.println(bestSum(8, new int[] { 2, 3, 5 })); // [3, 5]
        System.out.println(bestSum(8, new int[] { 1, 4, 5 })); // [4, 4]
        System.out.println(bestSum(100, new int[] { 1, 2, 5, 25 })); // [25, 25, 25, 25]
    }
}
