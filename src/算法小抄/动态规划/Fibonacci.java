package 算法小抄.动态规划;

import java.util.Arrays;

public class Fibonacci {
    public int Fibonacci(int n){
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        return process(n,memo);
    }
    public int process(int n,int[] memo){
        if (n==0) return 0;
        if (n==1) return 1;
        if (memo[n]!=-1) return memo[n];
        memo[n] = process(n-1,memo)+process(n-2,memo);
        return memo[n];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.Fibonacci(2));
    }
}
