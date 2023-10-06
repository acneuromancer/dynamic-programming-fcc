package _02_tabulation;

import java.util.ArrayList;
import java.util.List;

public class _04_HowSumTabulation {

    public static List<Integer> howSum(int targetSum, List<Integer> numbers) {
        var table = new ArrayList<ArrayList<Integer>>();
        for (var i = 0; i <= targetSum; i++) {
            if (i == 0) table.add(new ArrayList<>());
            else table.add(null);
        }

        for (var i = 0; i < targetSum; i++) {
            if (table.get(i) != null) {
                for (var num : numbers) {
                    if (i + num <= targetSum) {
                        var oldList = new ArrayList<>(table.get(i));
                        oldList.add(num);
                        table.set(i + num, oldList);
                    }
                }
            }
        }

        return table.get(targetSum);
    }

    public static void main(String[] args) {
        var result = howSum(7, List.of(2, 3)); // [3, 2, 3]
        System.out.println(result);

        result = howSum(7, List.of(5, 3, 4, 7)); // [4, 3];
        System.out.println(result);

        result = howSum(7, List.of(2, 4)); // null
        System.out.println(result);

        result = howSum(8, List.of(2, 3, 5)); // [2, 2, 2, 2];
        System.out.println(result);

        result = howSum(300, List.of(7, 14)); // null
        System.out.println(result);
    }
}
