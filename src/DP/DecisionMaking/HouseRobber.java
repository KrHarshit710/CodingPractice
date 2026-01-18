package DP.DecisionMaking;

// https://leetcode.com/problems/house-robber/
// https://leetcode.com/problems/house-robber-ii/description/
// [Revise NeetCode] https://leetcode.com/problems/house-robber-iii/description/
// [O(n^2) TLE BinarySearch] https://leetcode.com/problems/house-robber-iv/description/
public class HouseRobber {
    private static int[] dp;
    private static int util(int i, int n, int[] money){
        if(i >= n)
            return 0;
        if(dp[i] != -1)
            return dp[i];
        return dp[i] = Integer.max(money[i] + util(i+2, n, money), util(i+1, n, money));
    }
    public static int robAlternate(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        for(int i=0;i<n;i++)
            dp[i] = -1;

        return util(0, n, nums);
    }

    public static int robAlternateOptimal(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        if(nums.length == 2)
            return Integer.max(nums[0], nums[1]);

        int lastMax = Integer.max(nums[0], nums[1]);;
        int secondLastMax = nums[0];

        int max = Integer.max(lastMax, secondLastMax);

        for(int i=2; i<nums.length; i++) {
            max = Integer.max(secondLastMax + nums[i], lastMax);
            // if array contains -ve values
            // max = Integer.max(Integer.max(secondLastMax + nums[i], lastMax), nums[i]);
            secondLastMax = lastMax;
            lastMax = max;
        }
        return max;
    }

    public static int robAlternateCircular(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];

        dp = new int[n];
        for(int i=0;i<n;i++)
            dp[i] = -1;

        int first = util(0, n-1, nums);

        for(int i=0;i<n;i++)
            dp[i] = -1;
        int second = util(1, n, nums);

        return Integer.max(first, second);
    }

    public static void main(String[] args) {
        int[] house = new int[]{2,7,9,3,1};

        System.out.println(robAlternate(house));

        System.out.println(robAlternateOptimal(house));

        System.out.println(robAlternateCircular(house));
    }
}
