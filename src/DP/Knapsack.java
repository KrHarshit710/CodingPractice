package DP;

import java.util.Arrays;

public class Knapsack {
    private static int[][] dp;

    // 0/1 knapsack
    private static int maxRobbery(int[] val, int[] wt, int W, int n){
        if(n<0 || W<=0)
            return 0;
        if(dp[n][W] != -1)
            return dp[n][W];
        if(wt[n] <= W){
            return dp[n][W] = Integer.max(val[n] + maxRobbery(val, wt, W-wt[n], n-1),maxRobbery(val, wt, W, n-1));
        } else {
            return dp[n][W] = maxRobbery(val, wt, W, n-1);
        }
    }
    // unbounded knapsack
    private static int unboundedKnapsack(int[] val, int[] wt, int W, int i){
        if(i<0 || W<0)
            return 0;
        // System.out.println(i + " " + W);
        if(dp[i][W] != -1)
            return dp[i][W];

        if(wt[i]<=W){
            return dp[i][W] = Integer.max(val[i] + unboundedKnapsack(val,wt,W-wt[i],i),
                    unboundedKnapsack(val,wt,W,i-1));
        }else{
            return dp[i][W] = unboundedKnapsack(val,wt,W,i-1);
        }
    }
    public static void main(String[] args) {
        int n = 3, W = 5;
        int[] val = new int[]{5,2,2};
        int[] wt = new int[]{2,5,1};
        dp = new int[n][W+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], -1);
        //System.out.println(maxRobbery(val,wt,W,n-1));

        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], -1);
        System.out.println(unboundedKnapsack(val,wt,W,n-1));
    }
}
