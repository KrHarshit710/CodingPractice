package DP.DPOnStrings;

import java.util.Arrays;

//https://leetcode.com/problems/interleaving-string/
public class InterleavingString {
    private static Boolean[][] dp;
    private static boolean isInterleaveUtil(String s1, String s2, String s3, int i, int j, int k){
        if(k==s3.length() && i==s1.length() && j==s2.length())
            return true;
        else if(k==s3.length())
            return false;

        if(dp[i][j] != null)
            return dp[i][j];

        boolean selectCharFromS1 = false;
        boolean selectCharFromS2 = false;
        if(i<s1.length() && j<s2.length()){
            if(s1.charAt(i) == s3.charAt(k)){
                selectCharFromS1 = isInterleaveUtil(s1,s2,s3,i+1,j,k+1);
            }
            if(s2.charAt(j) == s3.charAt(k)){
                selectCharFromS2 = isInterleaveUtil(s1,s2,s3,i,j+1,k+1);
            }
        } else if(i<s1.length()){
            if(s1.charAt(i) == s3.charAt(k)){
                selectCharFromS1 = isInterleaveUtil(s1,s2,s3,i+1,j,k+1);
            }
        } else if(j<s2.length()){
            if(s2.charAt(j) == s3.charAt(k)){
                selectCharFromS1 = isInterleaveUtil(s1,s2,s3,i,j+1,k+1);
            }
        }
        return dp[i][j] = selectCharFromS1 || selectCharFromS2 ;
    }
    private static boolean isInterleave(String s1, String s2, String s3) {
        dp = new Boolean[s1.length()+1][s2.length()+1];
        for(int i=0;i<s1.length()+1;i++)
            Arrays.fill(dp[i],null);
        return isInterleaveUtil(s1,s2,s3,0,0,0);
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("a","b","a"));
        System.out.println(isInterleave("aabcc","dbbca","aadbbcbcac"));
        System.out.println(isInterleave("","",""));
    }
}
