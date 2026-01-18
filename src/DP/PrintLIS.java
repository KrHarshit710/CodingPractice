package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/largest-divisible-subset/description/
public class PrintLIS {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(dp,1);
        int maxLen = 1;
        int maxIndex = 0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i] % nums[j] == 0){
                    if(dp[j]+1 > dp[i]){
                        dp[i] = dp[j]+1;
                        parent[i] = j;
                        if(dp[i] > maxLen){
                            maxLen = dp[i];
                            maxIndex = i;
                        }
                    }
                }
            }
        }

        List<Integer> subset = new ArrayList<>();

        for(int i=maxIndex;i>=0;){
            subset.add(nums[i]);
            i = parent[i];
        }

        return subset;
    }

    public static void main(String[] args) {

    }
}
