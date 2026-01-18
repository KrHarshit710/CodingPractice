package Graph.UnionFind;

import java.util.Arrays;

// https://leetcode.com/problems/redundant-connection/description/
// Intuition : Check if there exists a path between , edge[i][0] , edge[i][1]
// If yes, then new edge creates a cycle because there are now two distinct paths between
// some pairs of nodes.
// Note : We could have used DFS as well to find path between edge[i][0] , edge[i][1]
public class RedundantConnection {
    private static int[] parent;
    private static int[] rank;
    private static int find(int i){
        if(parent[i] == i)
            return i;
        return parent[i] = find(parent[i]);
    }
    private static void union(int i, int j){
        int iP = find(i);
        int jP = find(j);

        if(iP == jP)
            return;

        if(rank[iP] > rank[jP]){
            parent[jP] = iP;
        } else if(rank[jP] > rank[iP]){
            parent[iP] = jP;
        } else {
            parent[iP] = jP;
            rank[iP]++;
        }
    }
    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        parent = new int[n];
        rank = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        int[] redundantEdge = new int[]{};
        for(int[] edge : edges){
            if(find(edge[0]) == find(edge[1]))
                redundantEdge = edge;

            union(edge[0], edge[1]);
        }

        return redundantEdge;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{1,2},{1,3},{2,3}};
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
    }
}
