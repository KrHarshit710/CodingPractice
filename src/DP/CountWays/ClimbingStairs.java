package DP.CountWays;

import java.util.Arrays;

//[Easy] https://leetcode.com/problems/climbing-stairs/description/
public class ClimbingStairs {
    private static int[] dp;
    private static int jump(int i){
        if(i<0)
            return 0;
        if(i==0)
            return 1;
        if(dp[i] != -1)
            return dp[i];
        return dp[i] = jump(i-1) + jump(i-2);
    }
    public static int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);

        return jump(n);
    }
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}
