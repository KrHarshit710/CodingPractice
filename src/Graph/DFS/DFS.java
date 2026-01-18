package Graph.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Directed_graph.png
public class DFS {

    private static boolean[] visited;
    private static void dfs(List<List<Integer>> adjList, int i){
        visited[i] = true;
        System.out.println(i);

        for(int next : adjList.get(i)){
            if(!visited[next])
                dfs(adjList, next);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{0,1});
        edges.add(new int[]{0,5});
        edges.add(new int[]{1,2});
        edges.add(new int[]{1,4});
        edges.add(new int[]{2,3});
        edges.add(new int[]{3,1});
        edges.add(new int[]{3,0});
        edges.add(new int[]{4,3});
        edges.add(new int[]{5,4});

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());

        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
        }

        visited = new boolean[n];
        Arrays.fill(visited, false);

        for (int i=0; i<n; i++){
            if(!visited[i])
                dfs(adjList, i);
        }



    }
}
