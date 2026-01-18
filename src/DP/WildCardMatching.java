package DP;

import java.util.Arrays;

public class WildCardMatching {

    private static int[][] dp;
    private static boolean isMatch(String str, String pattern, int m, int n){
        if(m == str.length() && n == pattern.length())
            return true;

        if(m == str.length()){
            for(int i=n; i<pattern.length(); i++){
                if(pattern.charAt(i) != '*')
                    return false;
            }
            return true;
        }

        if(n == pattern.length())
            return false;

        if(dp[m][n] != -1)
            return dp[m][n] == 1;

        if(pattern.charAt(n) >= 'a' && pattern.charAt(n) <= 'z'){
            if(str.charAt(m) == pattern.charAt(n)) {
                dp[m][n] = isMatch(str, pattern, m+1, n+1) ? 1 : 0;
            }
        } else if (pattern.charAt(n) == '?') {
            dp[m][n] = isMatch(str, pattern, m+1, n+1) ? 1 : 0;
        } else {
            dp[m][n] = isMatch(str, pattern, m+1, n) || isMatch(str, pattern, m+1, n+1) || isMatch(str, pattern, m, n+1) ? 1 : 0;
        }
        return dp[m][n] == 1;
    }
    public static void main(String[] args) {
        String str = "aa";
        String pattern = "a**";
        int m = str.length();
        int n = pattern.length();
        dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            Arrays.fill(dp[i], -1);

        System.out.println(isMatch(str, pattern, 0, 0));
    }
}
