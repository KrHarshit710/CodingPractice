package Graph.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/network-delay-time/
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        n = n+1;
        List<List<int[]>> adjLists = new ArrayList<>();
        for(int i=0; i<n; i++)
            adjLists.add(new ArrayList<>());

        for(int i=0; i<times.length; i++){
            adjLists.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }

        int[] shortestPath = new int[n];
        Arrays.fill(shortestPath, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {return Integer.compare(a[1], b[1]);});
        pq.add(new int[]{k, 0});
        shortestPath[k] = 0;

        int[] node;
        int u, w, v, d;
        while(!pq.isEmpty()){
            node = pq.poll();
            u = node[0];
            w = node[1];

            for(int[] adjNode : adjLists.get(u)){
                v = adjNode[0];
                d = adjNode[1];

                if(w+d < shortestPath[v]){
                    shortestPath[v] = w+d ;
                    pq.offer(new int[]{v, shortestPath[v]});
                }
            }
        }
        int minTime = Integer.MIN_VALUE;
        for(int i=1; i<n; i++){
            if(shortestPath[i] == Integer.MAX_VALUE)
                return -1;
            else
                minTime = Integer.max(minTime, shortestPath[i]);
        }
        return minTime;
    }
}
