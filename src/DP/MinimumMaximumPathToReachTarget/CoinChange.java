package DP.MinimumMaximumPathToReachTarget;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change/description/
//https://leetcode.com/problems/coin-change-ii/description/
public class CoinChange {
    private static int INF = 10005;
    private static int[] dp;
    private static int coinChangeUtil(int[] coins, int n, int amount){
        if(amount < 0)
            return INF;
        if(amount == 0)
            return 0;
        if(dp[amount] != -1)
            return dp[amount];
        int coinCount;
        int minCoinCount = INF;
        for(int i=0;i<n;i++){
            coinCount = 1 + coinChangeUtil(coins,n,amount-coins[i]);
            if(coinCount < minCoinCount)
                minCoinCount = coinCount;
        }
        return dp[amount] = minCoinCount;
    }
    public static int coinChange(int[] coins, int amount) {
        dp = new int[amount+1];
        Arrays.fill(dp,-1);
        int minCoinCount = coinChangeUtil(coins,coins.length,amount);
        if(minCoinCount == INF)
            return -1;
        else
            return minCoinCount;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{2,1,5};
        int amount = 100;
        System.out.println(coinChange(coins,amount)); // 20
        System.out.println(coinChangeWays(coins,amount));
    }

    private static int[][] ways;
    private static int coinChangeWays(int[] coins, int amount, int j){
        if(amount == 0)
            return 1;
        if(amount<0 || j<0)
            return 0;

        if(ways[j][amount] != -1)
            return ways[j][amount];

        return ways[j][amount] = coinChangeWays(coins, amount-coins[j], j) +
                coinChangeWays(coins, amount, j-1);
    }
    private static int coinChangeWays(int[] coins, int amount) {
        int n = coins.length;
        ways = new int[n][amount+1];
        for(int i=0;i<n;i++)
            Arrays.fill(ways[i], -1);
        return coinChangeWays(coins,amount,n-1);
    }
}
