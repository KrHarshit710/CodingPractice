package Graph.BipartiteGraph;

import java.util.*;

// https://leetcode.com/problems/is-graph-bipartite/description/
// https://leetcode.com/problems/possible-bipartition/description/
public class BipartiteGraph {
    private static final int NO_COLOR = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;
    private boolean isBipartite;
    private void dfs(List<List<Integer>> adjList, int node, int parentColor){
        if(color[node] != NO_COLOR){
            if(color[node] == parentColor)
                isBipartite = false;
        } else {
            color[node] = parentColor == RED ? GREEN : RED ;
            for(int next : adjList.get(node)){
                dfs(adjList, next, color[node]);
            }
        }
    }

    private void bfs(List<List<Integer>> adjList, int node){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        color[node] = RED;

        while(!queue.isEmpty()){
            node = queue.poll();
            for(int next : adjList.get(node)){
                if(color[next] == NO_COLOR){
                    color[next] = color[node] == RED ? GREEN : RED;
                    queue.offer(next);
                } else{
                    if(color[next] == color[node])
                        isBipartite = false;
                }
            }
        }
    }

    public boolean isBipartite(int[][] graph) {

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<graph.length;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                adjList.get(i).add(graph[i][j]);
            }
        }

        color = new int[graph.length];
        Arrays.fill(color, NO_COLOR);
        isBipartite = true;
        for(int i=0;i<graph.length;i++){
            if(color[i] == NO_COLOR)
                //dfs(adjList,i,RED);
                bfs(adjList,i);
        }

        return isBipartite;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1,2,3},
                {0,2},
                {0,1,3},
                {0,2}
        };

        System.out.println(new BipartiteGraph().isBipartite(graph));
    }
}
