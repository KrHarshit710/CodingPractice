package Graph.BFS;

import java.util.*;

// Directed_graph.png
public class BFS {

    private static boolean[] visited;
    private static void bfs(List<List<Integer>> adjList, int node){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        visited[node] = true;

        while(!queue.isEmpty()){
            node = queue.poll();
            System.out.println(node);

            for (int next : adjList.get(node)) {
                if(!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 8;
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

        for(int i=0;i<n;i++){
            if(!visited[i])
                bfs(adjList, i);
        }
    }
}
