package DP.CountWays;

import java.util.Arrays;

// https://leetcode.com/problems/knight-dialer/description/
public class KnightDialer {
    private static int[] dirX = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int[] dirY = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int[][][] dp;
    private static int knightDialer(int r, int c, int n){
        if(r<0 || r>3 || c<0 || c>2)
            return 0;
        if(r==3 && (c==0 || c==2))
            return 0;
        if(n==0)
            return 1;
        if(dp[r][c][n] != -1)
            return dp[r][c][n];
        int count = 0;
        for(int i=0;i<8;i++){
            count = ( count + knightDialer(r+dirY[i], c+dirX[i], n-1) ) % 1000000007;
        }
        return dp[r][c][n] = count;
    }
    public static int knightDialer(int n) {
        dp = new int[4][3][5001];
        for(int i=0;i<4;i++)
            for(int j=0;j<3;j++)
                Arrays.fill(dp[i][j], -1);

        int count = 0;
        for(int i=0;i<4;i++)
            for(int j=0;j<3;j++)
                count = ( count + knightDialer(i,j,n-1) ) % 1000000007;

        return count;
    }
    public static void main(String[] args) {
        System.out.println(knightDialer(1));
        System.out.println(knightDialer(2));
        System.out.println(knightDialer(3131));
    }
}
