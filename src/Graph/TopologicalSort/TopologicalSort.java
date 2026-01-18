package Graph.TopologicalSort;

import java.util.*;

// https://leetcode.com/problems/course-schedule/description/
// https://leetcode.com/problems/course-schedule-ii/description/

// Time Complexity: O(V+E)
public class TopologicalSort {

    private static Deque<Integer> stack;
    private static boolean[] visited;
    private static void topologicalOrder(List<List<Integer>> adjList, int node){
        visited[node] = true;
        for(int next : adjList.get(node)) {
            if(!visited[next])
                topologicalOrder(adjList, next);
        }
        stack.push(node);
    }

    public static void main(String[] args) {
        int n = 6;
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{4,0});
        edges.add(new int[]{5,0});
        edges.add(new int[]{5,2});
        edges.add(new int[]{2,3});
        edges.add(new int[]{4,1});
        edges.add(new int[]{3,1});


        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());

        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
        }

        visited = new boolean[n];
        Arrays.fill(visited, false);

        stack = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            if(!visited[i])
                topologicalOrder(adjList, i);
        }

        stack.forEach(System.out::println);
    }
}
