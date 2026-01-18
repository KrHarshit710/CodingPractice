package Array.BinarySearch;

// [Revise NeetCode] https://leetcode.com/problems/house-robber-iv/description/
public class HouseRobber {
    private boolean isItPossibleToRob(int[] nums, int k, int capability){
        int count = 0;
        for(int i=0;i<nums.length;){
            if(nums[i] <= capability){
                count++;
                i=i+2;
            }else{
                i=i+1;
            }
        }
        if(count >= k)
            return true;
        else
            return false;
    }
    public int minCapability(int[] nums, int k) {
        int l = 1;
        int r = 1000000009;
        int m;
        int minCapability = Integer.MAX_VALUE;
        while(l<=r){
            m = l + (r-l)/2;
            if(isItPossibleToRob(nums, k, m)){
                minCapability = Integer.min(minCapability, m);
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return minCapability;
    }

    public static void main(String[] args) {

    }
}
