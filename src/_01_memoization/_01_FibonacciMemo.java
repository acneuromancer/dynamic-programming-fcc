package _01_memoization;

public class _01_FibonacciMemo {

    public static int fib(int n) {
        if (n <= 2) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static long fibMemo(int n) {
        return fibMemo(n, new long[n + 1]);
    }

    private static long fibMemo(int n, long[] memo) {
        if (memo[n] != 0) return memo[n];

        if (n <= 2) {
            memo[n] = 1;
            return 1;
        }

        memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(5)); // 5
        System.out.println(fib(13)); // 233
        System.out.println(fibMemo(100)); // 4181
    }
}
