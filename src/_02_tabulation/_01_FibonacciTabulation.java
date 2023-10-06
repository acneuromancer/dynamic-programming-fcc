package _02_tabulation;

public class _01_FibonacciTabulation {

    public static long fibonacci(int n) {
        var table = new long[n + 1];
        table[1] = 1;

        for (var i = 0; i <= n; i++) {
            if (i + 1 <= n) table[i + 1] += table[i];
            if (i + 2 <= n) table[i + 2] += table[i];
        }

        return table[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(6)); // 8
        System.out.println(fibonacci(7)); // 13
        System.out.println(fibonacci(8)); // 21
        System.out.println(fibonacci(50)); // 12586269025
    }
}
