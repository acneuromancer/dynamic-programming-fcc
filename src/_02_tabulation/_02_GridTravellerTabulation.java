package _02_tabulation;

public class _02_GridTravellerTabulation {

    public static long travel(int m, int n) {
        long[][] table = new long[m + 1][n + 1];
        table[1][1] = 1;

        for (var i = 0; i <= m; i++) {
            for (var j = 0; j <= n; j++) {
                var current = table[i][j];
                if (j + 1 <= n) table[i][j + 1] += current;
                if (i + 1 <= m)  table[i + 1][j] += current;
            }
        }

        return table[m][n];
    }
    public static void main(String[] args) {
        System.out.println(travel(1, 1)); // 1
        System.out.println(travel(2, 3)); // 3
        System.out.println(travel(3, 2)); // 3
        System.out.println(travel(3, 3)); // 6
        System.out.println(travel(18, 18)); // 2333606220
    }
}
