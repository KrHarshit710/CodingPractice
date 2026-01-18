package DP.MinimumMaximumPathToReachTarget;

public class MinCostClimbingStairs {
    // TC O(n) , SC O(n)
    private static int minCostClimbingStairs(int[] cost){
        int n = cost.length;
        if(n==1)
            return cost[0];
        if(n==2)
            return Integer.min(cost[0],cost[1]);

        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i=2;i<n;i++){
            dp[i] = Integer.min(dp[i-1], dp[i-2]) + cost[i];
        }

        return Integer.min(dp[n-1], dp[n-2]);
    }
    // TC O(n) , SC O(n)
    private static int minCostClimbingStairsSpaceOptimized(int[] cost){
        int n = cost.length;
        if(n==1)
            return cost[0];
        if(n==2)
            return Integer.min(cost[0],cost[1]);

        int a, b, c;
        a = cost[0];
        b = cost[1];

        for(int i=2;i<n;i++){
            c = cost[i] + Integer.min(a,b);
            a = b;
            b= c;
        }

        return Integer.min(a, b);
    }
    public static void main(String[] args) {
        int[] cost = new int[]{10,15,20};
        System.out.println(minCostClimbingStairs(cost));
        System.out.println(minCostClimbingStairsSpaceOptimized(cost));
    }
}
