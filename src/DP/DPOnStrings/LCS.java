package DP.DPOnStrings;

import java.util.Arrays;

//https://leetcode.com/problems/longest-common-subsequence/description/
//https://leetcode.com/problems/longest-palindromic-subsequence/description/
//https://leetcode.com/problems/delete-operation-for-two-strings/
public class LCS {
    private static int[][] dp;
    private static int lcs(String str1, String str2, int i, int j){
        if(i<0 || j<0)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(str1.charAt(i) == str2.charAt(j)){
            return dp[i][j] = 1 + lcs(str1,str2,i-1,j-1);
        }else{
            return dp[i][j] = Integer.max(lcs(str1,str2,i-1,j),lcs(str1,str2,i,j-1));
        }
    }
    public static void main(String[] args) {
        // Memoization
        String str1 = "abc";
        String str2 = "def";
        int m = str1.length();
        int n = str2.length();
        dp = new int[m+1][n+1];
        for(int i=0;i<m;i++)
            Arrays.fill(dp[i],-1);

        System.out.println(lcs(str1,str2,m-1,n-1));

        // Tabulation
        dp = new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Integer.max(dp[i][j-1],dp[i-1][j]);
            }
        }

        System.out.println(dp[m][n]);
    }
}
