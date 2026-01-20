package Graph.TopologicalSort;

import java.util.*;

// Kahn's Algorithm
public class TopologicalSortBFS
{
    private static Deque<Integer> queue;
    private static boolean[] visited;
    private static int[] inDegree;
    private static List<Integer> topologicalOrder;
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
        inDegree = new int[n];
        visited = new boolean[n];
        Arrays.fill(visited, false);

        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        topologicalOrder = new ArrayList<>();
        queue = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
                visited[i] = true;
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            topologicalOrder.add(node);
            for(int next : adjList.get(node)){
                inDegree[next]--;
                if(inDegree[next] == 0 && !visited[next]){
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }

        for(int i=0; i<n; i++)
        {
            if (inDegree[i] != 0)
            {
                System.out.println("Graph has a cycle, topological sort not possible");
                break;
            }
        }

        topologicalOrder.forEach(System.out::println);

        // Convert List<Integer> to int[]
        topologicalOrder.stream().mapToInt(Integer::intValue).toArray();

        // Convert List<Integer> to Integer[]
        topologicalOrder.toArray(new Integer[0]);
    }
}
