package DP;

import java.util.Arrays;

// https://leetcode.com/problems/climbing-stairs/description/
// https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/
// https://takeuforward.org/data-structure/dynamic-programming-frog-jump-with-k-distances-dp-4/
public class FrogJump {

    private static int[] dp;

    // Can Jump 1 Step or 2 Step
    private static int jump(int i){
        if(i<0)
            return 0;
        if(i==0)
            return 1;
        if(dp[i] != -1)
            return dp[i];
        return dp[i] = jump(i-1) + jump(i-2);
    }

    // Can Jump 1 Step or 2 Step
    private static int minEnergy(int[] steps, int i){
        if(i==0)
            return 0;
        if(dp[i] != -1)
            return dp[i];
        int singleStep = minEnergy(steps, i-1) + Math.abs(steps[i-1] - steps[i]);
        int twoStep = Integer.MAX_VALUE;
        if(i>=2){
           twoStep = minEnergy(steps, i-2) + Math.abs(steps[i-2] - steps[i]);
        }
        return dp[i] = Integer.min(singleStep, twoStep);
    }

    // Can Jump 1 Step or 2 Step ... k steps
    private static int minEnergy(int[] steps,int k, int i){
        if(i==0)
            return 0;
        if(dp[i] != -1)
            return dp[i];
        int minEnergy = Integer.MAX_VALUE;
        for(int j=1;j<=k;j++){
            if(i-j>=0)
                minEnergy = Integer.min(minEnergy, minEnergy(steps, k, i-j) + Math.abs(steps[i-j] - steps[i]));
        }
        return dp[i] = minEnergy;
    }


    public static void main(String[] args) {
        int n = 5;
        dp = new int[n+1];
        Arrays.fill(dp, -1);

        System.out.println(jump(n));

        dp = new int[6];
        Arrays.fill(dp, -1);
        int[] steps = new int[]{30,10,60,10,60,50};
        System.out.println(minEnergy(steps,5));

        Arrays.fill(dp, -1);
        System.out.println(minEnergy(steps,5, 5));
    }
}
