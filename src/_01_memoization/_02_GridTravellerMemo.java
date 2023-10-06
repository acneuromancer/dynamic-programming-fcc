package _01_memoization;
/*
* You are a traveller on a 2D grid. You begin in the top-left corner and your goal is to travel to the bottom-right
* corner. You may only move down or right.
* In how many ways can you travel to the goal on a grid with dimensions m * n?
* */

import java.util.HashMap;
import java.util.Map;

public class _02_GridTravellerMemo {

    public static int travel(int m, int n) {
        // O(2^n+m) time
        // O(n+m) space
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        return travel(m - 1, n) + travel(m, n - 1);
    }

    public static long travelMemo(int m, int n) {
        return travelMemo(m, n, new HashMap<>());
    }

    public static long travelMemo(int m, int n, Map<String, Long> memo) {
        String key = m + "," + n;

        if (memo.containsKey(key)) return memo.get(key);
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;

        var numWays = travelMemo(m - 1, n, memo) + travelMemo(m, n - 1, memo);
        memo.put(key, numWays);
        return numWays;
    }


    public static void main(String[] args) {
        System.out.println(travel(2, 3)); // 3
        System.out.println(travel(3, 2)); // 3
        System.out.println(travel(1, 1)); // 1
        System.out.println(travel(3, 3)); // 6
        System.out.println(travelMemo(18, 18)); // 2333606220
    }
}
