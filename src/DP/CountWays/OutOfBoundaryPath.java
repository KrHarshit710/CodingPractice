package DP.CountWays;

import java.util.Arrays;

// https://leetcode.com/problems/out-of-boundary-paths/description/
public class OutOfBoundaryPath {
    private static int[] dirX = {-1,0,1,0};
    private static int[] dirY = {0,-1,0,1};
    private static int[][][] dp;
    private static int findPathsUtil(int m, int n, int moves, int row, int col){
        if(row < 0 || row >= m || col < 0 || col >= n)
            return 1;
        if(moves<=0)
            return 0;
        if(dp[row][col][moves] != -1)
            return dp[row][col][moves];
        int count = 0;
        for(int i=0;i<4;i++)
            count = ( count + findPathsUtil(m, n, moves-1, row+dirX[i], col+dirY[i]) ) % 1000000007;

        return dp[row][col][moves] = count;
    }
    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[51][51][51];
        for(int i=0;i<51;i++)
            for(int j=0;j<51;j++)
                Arrays.fill(dp[i][j], -1);
        return findPathsUtil(m,n,maxMove,startRow,startColumn);
    }
    public static void main(String[] args) {
        System.out.println(findPaths(1,3,3,0,1));
    }
}
