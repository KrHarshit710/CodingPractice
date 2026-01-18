package Graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

// Wayfair OA
/*
    A NxM Maze matrix and another integer K is given ,Matrix contains only 0's and 1's.
    0=empty space while 1= obstacle . One has to move from (0,0) to (N-1,M-1) with following constraints-

    One can move from
    (i,j) to (i+k,j) if there is no obstacle between (i,j) and (i+k,j) ,
    (i,j) to (i-k,j) if there is no obstacle between (i,j) and (i-k,j) ,
    (i,j) to (i,j+k) if there is no obstacle between (i,j) and (i,j+k) ,
    (i,j) to (i,j-k) if there is no obstacle between (i,j) and (i,j-k) .
    Return minimum moves for this .
    If one cannot reach destination , return -1 .
    Constraints - (1<=N,M,k<=100)

 */
public class DPOnMazeI {

    private static boolean checkObstacle(int[][] maze, boolean row, int x, int y, int z ){
        if(row){
            int i = x;
            for(int j=y;j<=z;j++){
                if(maze[i][j] == 1)
                    return true;
            }
        }else {
            int j = x;
            for(int i=y;i<=z;i++){
                if(maze[i][j] == 1)
                    return true;
            }
        }
        return false;
    }
    private static boolean[][] visited;
    private static int minMovesToReachEnd(int[][] maze, int m, int n, int k){
        int minPath = 10001;
        Queue<QueueNode> bfs = new ArrayDeque<>();
        bfs.add(new QueueNode(0, 0, 0));
        visited[0][0] = true;
        while(!bfs.isEmpty()){
            QueueNode top = bfs.poll();
            if(top.x == m-1 && top.y == n-1){
                minPath = Integer.min(minPath, top.path);
            } else {
                // i, j+k
                if(top.y + k < n && !visited[top.x][top.y+k] && !checkObstacle(maze, true, top.x, top.y, top.y+k)) {
                    bfs.add(new QueueNode(top.x, top.y + k, top.path + 1));
                    visited[top.x][top.y+k] = true;
                }
                // i, j-k
                if(top.y - k >= 0 && !visited[top.x][top.y-k] && !checkObstacle(maze, true, top.x, top.y-k, top.y)) {
                    bfs.add(new QueueNode(top.x, top.y - k, top.path + 1));
                    visited[top.x][top.y-k] = true;
                }
                // i+k, j
                if(top.x + k < m && !visited[top.x+k][top.y]  && !checkObstacle(maze, false, top.y, top.x, top.x+k)) {
                    bfs.add(new QueueNode(top.x + k, top.y, top.path + 1));
                    visited[top.x+k][top.y] = true;
                }
                //i-k, j
                if(top.x - k >= 0 && !visited[top.x - k][top.y] && !checkObstacle(maze, false, top.y, top.x-k, top.x)) {
                    bfs.add(new QueueNode(top.x - k, top.y, top.path + 1));
                    visited[top.x - k][top.y] = true;
                }
            }
        }
        return minPath;
    }
    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {0,0,1},
                {1,0,0},
                {1,0,0}
        };
        int m = 3;
        int n = 3;
        visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(visited[i], false);
        }

        System.out.println(minMovesToReachEnd(maze, m, n, 2));

    }
    static class QueueNode{
        int x;
        int y;
        int path;
        public QueueNode(int x, int y, int path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }
}
