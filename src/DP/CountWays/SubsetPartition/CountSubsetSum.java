package DP.CountWays.SubsetPartition;

import java.util.Arrays;

public class CountSubsetSum {
    private static int[][] dp;
    private static int countSubsetSum(int[] nums, int sum, int i){
        if(sum==0)
            return 1;
        if(i<0)
            return 0;
        if(dp[i][sum] != -1)
            return dp[i][sum];

        if(nums[i] <= sum){
            return dp[i][sum] = countSubsetSum(nums, sum-nums[i], i-1) + countSubsetSum(nums, sum, i-1);
        } else {
            return dp[i][sum] = countSubsetSum(nums, sum, i-1);
        }
    }
    public static void main(String[] args) {
        int n = 7;
        int[] nums = new int[]{4,3,2,3,5,2,1};
        int target = 5;

        dp = new int[n][target+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], -1);
        System.out.println(countSubsetSum(nums, target, n-1));
    }
}
