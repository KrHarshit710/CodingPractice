package DP.MinimumMaximumPathToReachTarget;

// https://leetcode.com/problems/maximal-square/description/
public class MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        int maxSquare = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = Integer.min(Integer.min(dp[i-1][j-1], dp[i-1][j]),dp[i][j-1]) + 1;

                    maxSquare = Integer.max(maxSquare, dp[i][j]);
                }
            }
        }

        return maxSquare * maxSquare;
    }
    public static void main(String[] args) {

    }
}
