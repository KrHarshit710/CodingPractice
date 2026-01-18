package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/course-schedule/description/
public class DetectCycleInDirectedGraph {

    private static boolean[] visited;
    private static boolean[] path;
    private static boolean cycleDetected;
    private static void dfs(List<List<Integer>> adjList, int i){

        if(visited[i]){
            if(path[i])
                cycleDetected = true;
        }else{
            visited[i] = true;
            path[i] = true;

            for(int next : adjList.get(i))
                dfs(adjList, next);

            path[i] = false;
        }
    }

    private static void detectCycle(List<List<Integer>> adjList, int i){
        dfs(adjList, i);
    }

    public static void main(String[] args) {
        int n = 6;
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{0,1});
        edges.add(new int[]{0,5});
        edges.add(new int[]{1,2});
        edges.add(new int[]{1,4});
        edges.add(new int[]{2,3});
        // edges.add(new int[]{3,1});
        // edges.add(new int[]{3,0});
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

        path = new boolean[n];
        Arrays.fill(path, false);

        cycleDetected = false;

        for(int i=0;i<n;i++){
            if(!visited[i])
                detectCycle(adjList, i);
        }

        System.out.println("Cycle Detected : " + cycleDetected);
    }
}
