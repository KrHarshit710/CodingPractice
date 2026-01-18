package DP.DPOnStrings;

//https://leetcode.com/problems/longest-common-subsequence/description/
//https://leetcode.com/problems/shortest-common-supersequence/
public class PrintLCS {

    public static void main(String[] args) {
        String str1 = "ABCDGH";
        String str2 = "ACDGHR";
        int m = 6, n = 6;

        int[][] dp = new int[m+1][n+1];

        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Integer.max(dp[i-1][j] , dp[i][j-1]);
            }
        }

        System.out.println(dp[m][n]);

        int i = m, j= n;
        String lcs = "";
        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                lcs = str1.charAt(i-1) + lcs;
                i--; j--;
            } else if(dp[i][j] == dp[i-1][j]){
                i--;
            } else {
                j--;
            }
        }

        System.out.println(lcs);
    }
}
