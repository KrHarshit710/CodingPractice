package Array;

//https://leetcode.com/problems/increasing-triplet-subsequence/description/
public class IncreasingTripletSequence {
    public static boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        leftMin[0]=Integer.MAX_VALUE;
        rightMax[n-1]=Integer.MIN_VALUE;

        for(int i=1;i<n;i++){
            leftMin[i] = Integer.min(leftMin[i-1],nums[i-1]);
        }

        for(int i=n-2;i>=0;i--)
            rightMax[i] = Integer.max(rightMax[i+1],nums[i+1]);

        for(int i=1;i<=n-2;i++){
            if(leftMin[i] < nums[i] && nums[i] < rightMax[i])
                return true;
        }

        return false;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5}; // Expected : True
        System.out.println(increasingTriplet(nums));

        nums = new int[]{5,4,3,2,1}; // Expected: False
        System.out.println(increasingTriplet(nums));

        nums = new int[]{2,1,5,0,4,6}; // Expected : True
        System.out.println(increasingTriplet(nums));
    }
}
