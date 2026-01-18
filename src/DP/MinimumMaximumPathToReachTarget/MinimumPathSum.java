package DP.MinimumMaximumPathToReachTarget;

public class MinimumPathSum {
    // TC O(m*n) , SC O(m*n)
    private static int minimumPathSum(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0)
                    dp[0][0] = grid[0][0];
                else if(i==0)
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                else if(j==0)
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                else
                    dp[i][j] = Integer.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}};

        System.out.println(minimumPathSum(grid));

        grid = new int[][]{{1,2,3},{4,5,6}};
        System.out.println(minimumPathSum(grid));
    }
}
