package DP.CountWays;

import java.util.Arrays;

// https://leetcode.com/problems/knight-probability-in-chessboard/
public class KnightProbability {
    private static int[] dirX = {1,2,2,1,-1,-2,-2,-1};
    private static int[] dirY = {-2,-1,1,2,2,1,-1,-2};
    private static double[][][] dp;
    private static double countInsideBoard(int n, int k, int r, int c){
        if(r>=0 && r<n && c>=0 && c<n)
            if(k == 0)
                return 1;
        if(r<0 || r>=n || c<0 || c>=n)
            return 0;
        if(dp[r][c][k] != -1)
            return dp[r][c][k];
        double count = 0;
        for(int i=0;i<8;i++)
            count += countInsideBoard(n,k-1,r+dirY[i], c+dirX[i] );

        return dp[r][c][k] = count;
    }
    public static double knightProbability(int n, int k, int row, int column) {
        dp = new double[26][26][101];
        for(int i=0;i<26;i++)
            for(int j=0;j<26;j++)
                Arrays.fill(dp[i][j], -1);
        return countInsideBoard(n,k,row,column) / Math.pow(8,k);
    }
    public static void main(String[] args) {
        System.out.println(knightProbability(3,2,0,0));
    }
}
