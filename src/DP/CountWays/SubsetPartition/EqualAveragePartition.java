package DP.CountWays.SubsetPartition;

import java.util.Arrays;

public class EqualAveragePartition {
    private static boolean findSubsetWithAverage(int[] nums, double targetAverage, int i, double subsetSum, int subsetSize ){
        if(subsetSize != 0 && subsetSum/subsetSize == targetAverage && subsetSize != nums.length)
            return true;
        if(i<0)
            return false;

        return findSubsetWithAverage(nums, targetAverage, i-1 , subsetSum + nums[i], subsetSize + 1)
                || findSubsetWithAverage(nums, targetAverage, i-1, subsetSum, subsetSize);
    }
    private static boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        double sum = Arrays.stream(nums).sum();
        return findSubsetWithAverage(nums, sum/n, n-1, 0, 0);
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        System.out.println(splitArraySameAverage(nums));
    }
}
