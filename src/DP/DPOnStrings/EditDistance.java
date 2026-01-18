package DP.DPOnStrings;

import java.util.Arrays;

// https://workat.tech/problem-solving/practice/edit-distance
public class EditDistance {
    int[][] dp;
    int minOperations(String s1, String s2, int i, int j){
        if(i<0)
            return j+1;

        if(j<0)
            return i+1;

        if(dp[i][j] != -1)
            return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = minOperations(s1, s2, i-1, j-1);
        else
            return dp[i][j] = Integer.min(Integer.min(1+minOperations(s1,s2,i-1,j-1), 1+minOperations(s1,s2,i,j-1)),1+minOperations(s1,s2,i-1,j));
    }
    int minOperations(String s1, String s2) {
        // add your logic here
        int m = s1.length();
        int n = s2.length();
        dp = new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(dp[i], -1);
        return minOperations(s1,s2,m-1,n-1);
    }

    public static void main(String[] args) {
        System.out.println(new EditDistance().minOperations("hello", "seldom")); // 3
    }
}
