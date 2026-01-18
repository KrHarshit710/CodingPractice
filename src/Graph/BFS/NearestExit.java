package Graph.BFS;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/
public class NearestExit {
    public static int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[] dirX = new int[]{-1,0,1,0};
        int[] dirY = new int[]{0,1,0,-1};
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{entrance[0], entrance[1], 0});
        visited[entrance[0]][entrance[1]] = true;

        int[] top;
        while(!queue.isEmpty()){
            top = queue.poll();
            // If Entrance was a cell on edge , it can't also be an exit.
            if((top[0] != entrance[0] || top[1] != entrance[1]) && exit(top[0], top[1], m, n))
                return top[2];

            for(int i=0;i<4;i++){
                int x = top[0] + dirX[i];
                int y = top[1] + dirY[i];

                if(x>=0 && x<m && y>=0 && y<n && maze[x][y] == '.' && !visited[x][y]){
                    queue.offer(new int[]{x,y,top[2]+1});
                    visited[x][y] = true;
                }
            }
        }
        return -1;
    }

    private static boolean exit(int x, int y, int m, int n){
        if(x == 0 || x == m-1 || y == 0 || y == n-1)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        //[["+","+",".","+"],[".",".",".","+"],["+","+","+","."]]
        //[1,2]
        //Output : 1
        char[][] maze = new char[][]{
                {'+','+','.','+'},
                {'.','.','.','+'},
                {'+','+','+','.'}
        };
        int[] entrance = new int[]{1,2};
        System.out.println(nearestExit(maze, entrance));
    }
}
