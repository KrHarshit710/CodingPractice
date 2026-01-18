package DP.CountWays;

import java.util.Arrays;

// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
public class NumberOfDiceRollsWithTargetSum {
    private static int[][] dp;
    private static int numRollsToTargetUtil(int n, int k, int target){
        if(n == 0 && target == 0)
            return 1;
        if(n < 0 || target < 0)
            return 0;
        if(dp[n][target] != -1)
            return dp[n][target];
        int ways = 0;
        for(int i=1;i<=k;i++){
            ways = ( ways + numRollsToTargetUtil(n-1, k, target-i) )  % 1000000007;
        }
        return dp[n][target] = ways;
    }
    public static int numRollsToTarget(int n, int k, int target) {
        dp = new int[n+1][target+1];
        for(int i=0;i<=n;i++)
            Arrays.fill(dp[i], -1);

        return numRollsToTargetUtil(n,k,target);
    }
    public static void main(String[] args) {
        System.out.println(numRollsToTarget(30, 30, 500));
    }
}
