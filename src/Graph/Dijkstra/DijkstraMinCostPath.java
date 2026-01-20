package Graph.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
// TODO
// TC = ?
// https://leetcode.com/discuss/interview-question/731911/please-share-dijkstras-algorithm-questions
// https://leetcode.com/problems/network-delay-time/description/
// https://leetcode.com/problems/path-with-maximum-probability/description/
class Node {
    int val;
    int weight;
    public Node(int val, int weight) {
        this.val = val;
        this.weight = weight;
    }
}
public class DijkstraMinCostPath {

    private static int[] shortestPath;
    private static void dijkstra(List<List<Node>> adjList){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            return Integer.compare(a[1], b[1]);
        });
        pq.add(new int[]{0,0});
        shortestPath[0] = 0;

        int[] top;
        while(!pq.isEmpty()){
            top = pq.remove();
            System.out.println(top[0] + " " + top[1]);
            for(Node next : adjList.get(top[0])){
                if(top[1] + next.weight < shortestPath[next.val]){
                    shortestPath[next.val] = next.weight+top[1];
                    pq.add(new int[]{next.val, shortestPath[next.val]});
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 9;
        List<List<Node>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());

        shortestPath = new int[n];
        for(int i=0;i<n;i++)
            shortestPath[i] = Integer.MAX_VALUE;

        adjList.get(0).add(new Node(1,4));
        adjList.get(0).add(new Node(7,8));
        adjList.get(1).add(new Node(2,8));
        adjList.get(1).add(new Node(7,11));
        adjList.get(2).add(new Node(3,7));
        adjList.get(2).add(new Node(8,2));
        adjList.get(2).add(new Node(5,4));
        adjList.get(3).add(new Node(5,14));
        adjList.get(3).add(new Node(4,9));
        adjList.get(4).add(new Node(5,10));
        adjList.get(5).add(new Node(6,2));
        adjList.get(6).add(new Node(7,1));
        adjList.get(6).add(new Node(8,6));
        adjList.get(7).add(new Node(8,7));
        adjList.get(7).add(new Node(6,1));

        dijkstra(adjList);

        Arrays.stream(shortestPath).forEach(System.out::println);
    }


}

