package Graph.Dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/swim-in-rising-water/description/
public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dirX = {0, -1, 0, 1};
        int[] dirY = {-1, 0, 1, 0};

        int[][] shortestPath = new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(shortestPath[i], Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {return Integer.compare(a[2], b[2]);});
        pq.add(new int[]{0,0,grid[0][0]});
        shortestPath[0][0] = grid[0][0];

        int x, y, w;
        int[] node;
        while(!pq.isEmpty()){
            node = pq.poll();
            x = node[0];
            y = node[1];
            w = node[2];

            for(int i=0; i<4; i++){
                if(x+dirX[i] >= 0 && x+dirX[i] < m && y+dirY[i] >= 0 && y+dirY[i] < n &&
                        Integer.max(w , grid[x+dirX[i]][y+dirY[i]]) < shortestPath[x+dirX[i]][y+dirY[i]]){
                    shortestPath[x+dirX[i]][y+dirY[i]] = Integer.max(w , grid[x+dirX[i]][y+dirY[i]]);
                    pq.add(new int[]{x+dirX[i],y+dirY[i],shortestPath[x+dirX[i]][y+dirY[i]]});
                }
            }
        }
        return shortestPath[m-1][n-1];
    }
}
