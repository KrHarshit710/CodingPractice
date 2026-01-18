package DP.CountWays;

import java.util.Arrays;

// https://leetcode.com/problems/target-sum/description/
public class TargetSum {
    private static int[][] dp;
    private static int findTargetSumWays(int[] nums, int i, int target){
        if(i==0 && target == 0 && nums[i] == 0)
            return 2;
        if(i== 0 && (target - nums[i] == 0 || target + nums[i] == 0))
            return 1;
        if(i < 0)
            return 0;
        if(dp[i][target+20000] != -1)
            return dp[i][target+20000];
        return dp[i][target+20000] = findTargetSumWays(nums, i-1, target - nums[i]) + findTargetSumWays(nums, i-1, target + nums[i]);
    }
    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        dp = new int[21][30001];
        for(int i=0;i<21;i++)
            Arrays.fill(dp[i], -1);
        return findTargetSumWays(nums, n-1, target);

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }
}
