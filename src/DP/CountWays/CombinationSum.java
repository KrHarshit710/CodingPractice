package DP.CountWays;

import java.util.Arrays;

// https://leetcode.com/problems/combination-sum-iv/description/
// https://www.youtube.com/watch?v=dw2nMCxG0ik&ab_channel=NeetCode
public class CombinationSum {
    private static int[] dp;
    private static int combinationSum4(int[] nums, int i, int target){
        if(target == 0)
            return 1;
        if(target < 0)
            return 0;
        if(dp[target] != -1)
            return dp[target];

        int count = 0;
        for(int j=0; j<nums.length; j++)
            count += combinationSum4(nums,j,target - nums[j]);

        return dp[target] = count;
    }
    public static int combinationSum4(int[] nums, int target) {
        dp = new int[1001];
        Arrays.fill(dp, -1);

        return combinationSum4(nums, 0, target);
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int target = 4;
        System.out.println(combinationSum4(nums, target));
    }
}
