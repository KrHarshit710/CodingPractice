package Graph.BFS;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/rotting-oranges/description/
public class RottingOranges {
    private static int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[] dirX = {-1,0,1,0};
        int[] dirY = {0,1,0,-1};

        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j,0});
                    visited[i][j] = true;
                }
            }
        }

        int timeToRot = 0;
        int[] top;
        while(!queue.isEmpty()){
            top = queue.poll();
            timeToRot = Integer.max(timeToRot, top[2]);
            for(int p=0;p<4;p++){
                int x = top[0] + dirX[p];
                int y = top[1] + dirY[p];

                if(x>=0 && x<m && y>=0 && y<n && !visited[x][y] && grid[x][y] == 1){
                    queue.offer(new int[]{x,y,top[2]+1});
                    visited[x][y] = true;
                    grid[x][y] = 2;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1)
                    return -1;
            }
        }

        return timeToRot;
    }

    public static void main(String[] args) {
        // [[2,1,1],[1,1,1],[0,1,2]] -> 2
        int[][] grid = new int[][]{
                {2,1,1},
                {1,1,1},
                {0,1,2}
        };

        System.out.println(orangesRotting(grid));

        // [[1]] -> -1

        grid = new int[][]{
                {1}
        };

        System.out.println(orangesRotting(grid));

    }
}
