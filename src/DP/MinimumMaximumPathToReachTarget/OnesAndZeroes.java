package DP.MinimumMaximumPathToReachTarget;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/ones-and-zeroes/description/
public class OnesAndZeroes {
    private static Map<String, Integer> dp;
    private static int findLargestSubset(String[] strs, int[] zeroes, int[] ones, int m, int n, int i){
        if(m < 0 || n < 0)
            return -5000;
        if(i<0)
            return 0;
        String key = i + "_" + m + "_" + n;
        if(dp.containsKey(key))
            return dp.get(key);

        int result = Integer.max(1+ findLargestSubset(strs, zeroes, ones, m - zeroes[i], n - ones[i], i-1),
                findLargestSubset(strs, zeroes, ones, m, n, i-1));
        dp.put(key, result);
        return result;
    }

    public static int findLargestSubset(String[] strs, int m, int n) {
        int len = strs.length;
        int[] zeroes = new int[len];
        int[] ones = new int[len];
        dp = new HashMap<>();

        for(int i=0;i<len;i++){
            for(int j=0;j<strs[i].length();j++){
                if(strs[i].charAt(j) == '0')
                    zeroes[i]++;
            }
            ones[i] = strs[i].length() - zeroes[i];
        }

        return findLargestSubset(strs, zeroes, ones, m, n, len-1);
    }
    public static void main(String[] args) {
        String[] strs = new String[]{"10","0001","111001","1","0"};
        System.out.println(findLargestSubset(strs, 5, 3));
    }
}
