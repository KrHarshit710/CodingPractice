package DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/longest-increasing-subsequence/description/
//https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
//https://leetcode.com/problems/longest-string-chain/description/
//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
public class LIS {
    private static int longestIncreasingSubsequence(int[] nums){
        int n = nums.length;
        List<Integer> lis = new ArrayList<>();
        lis.add(nums[0]);
        int lisLen = 1;
        for(int i=1;i<n;i++){
            if(nums[i] > lis.get(lisLen-1)){
                lis.add(nums[i]);
                lisLen++;
            }else{
                int j = Collections.binarySearch(lis,nums[i]);
                if(j<0){
                    lis.set(-1*(j+1), nums[i]);
                }
            }
        }

        return lisLen;
    }
    public static void main(String[] args) {

        int[] arr = new int[]{1,2,4,4,5,6};
        System.out.println(longestIncreasingSubsequence(arr));

    }
}
