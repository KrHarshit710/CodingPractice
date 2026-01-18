package Array;

import java.util.HashMap;

// https://leetcode.com/problems/subarray-sum-equals-k/description/
public class SubArraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;

        for(int i=1;i<n;i++){
            nums[i] = nums[i-1] + nums[i];
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        int countOfSubArray = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == k)
                countOfSubArray++;

            countOfSubArray += map.getOrDefault(nums[i]-k, 0);
            map.put(nums[i], 1+map.getOrDefault(nums[i], 0));
        }
        return countOfSubArray;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int k = 3;

        System.out.println(subarraySum(nums,k));

        nums = new int[]{1,-1,0};
        k = 0;

        System.out.println(subarraySum(nums,k));
    }
}
