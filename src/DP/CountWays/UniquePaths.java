package DP.CountWays;

// https://leetcode.com/problems/unique-paths/description/
// https://leetcode.com/problems/unique-paths-ii/description/ - with obstacles
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];

        for(int i=0;i<m;i++)
            paths[i][0] = 1;
        for(int j=0;j<n;j++)
            paths[0][j] = 1;

        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                paths[i][j] = paths[i-1][j] + paths[i][j-1];
            }
        }

        return paths[m-1][n-1] ;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1)
            return 0;

        int[][] paths = new int[m][n];
        paths[0][0] = 1;
        for(int i=1;i<m;i++)
            paths[i][0] = obstacleGrid[i][0] == 1 ? 0 : paths[i-1][0];
        for(int j=1;j<n;j++)
            paths[0][j] = obstacleGrid[0][j] == 1 ? 0 : paths[0][j-1];

        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                paths[i][j] = obstacleGrid[i][j] == 1 ? 0 : paths[i-1][j] + paths[i][j-1];
            }
        }

        return paths[m-1][n-1] ;
    }
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }
}
