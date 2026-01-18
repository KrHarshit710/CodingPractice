package DP.CountWays.SubsetPartition;

import java.util.Arrays;

//https://leetcode.com/problems/partition-equal-subset-sum/description/
// https://www.youtube.com/watch?v=snue4L5WrJ4&ab_channel=NeetCodeIO
public class EqualSumPartition {
    private static Boolean[][] dp;
    private static boolean subsetSum(int[] nums, int sum, int i){
        if(sum==0)
            return true;
        if(i<0)
            return false;
        if(dp[i][sum] != null)
            return dp[i][sum];

        if(nums[i]<=sum){
            return dp[i][sum] = subsetSum(nums,sum-nums[i], i-1) || subsetSum(nums, sum, i-1);
        }else{
            return dp[i][sum] = subsetSum(nums, sum, i-1);
        }
    }
    private static boolean isEqualSumPartitionPossible(int[] nums){
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1)
            return false;

        int target = sum/2;
        dp = new Boolean[n][target+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], null);
        return subsetSum(nums, target, n-1);
    }
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 1, 1, 1};
        System.out.println(isEqualSumPartitionPossible(nums));

        nums = new int[]{3, 1, 2, 1, 1, 1, 1, 2};
        System.out.println(isEqualSumPartitionPossible(nums));
    }
}
