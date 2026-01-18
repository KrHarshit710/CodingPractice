package DP.DPOnStrings;

public class LongestCommonSubstring {
    private static int[][] dp;
    private static int longestCommonSubstring(String s1, String s2, int i, int j, int lcs){
        if(i==0 || j==0)
            return lcs;
        if(s1.charAt(i) == s2.charAt(j))
            return lcs = longestCommonSubstring(s1, s2, i-1, j-1, lcs + 1);
        else
            return lcs = Integer.max(longestCommonSubstring(s1,s2,i-1,j, 0), longestCommonSubstring(s1, s2, i, j-1, 0));
    }
    public static void main(String[] args) {
        System.out.println(longestCommonSubstring("ABCDGH", "ACDGHR", 5, 5, 0));

        String str1 = "ABCDGH";
        String str2 = "ACDGHR";
        int m = 6, n = 6;
        // Tabulation
        dp = new int[m+1][n+1];

        int lcs = 0; // NOTE : To avoid traversing the dp array again at the end
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = 0;

                lcs = Integer.max(lcs, dp[i][j]);
            }
        }

        System.out.println(lcs);
    }
}
