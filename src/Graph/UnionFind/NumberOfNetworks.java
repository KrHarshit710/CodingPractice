package Graph.UnionFind;

// https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/
public class NumberOfNetworks {
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
            parent[jP] = iP;
            rank[iP]++;
        }
    }
    public static int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        rank = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        int extraConnections = 0;
        for(int[] connection : connections){
            if(find(connection[0]) == find(connection[1]))
                extraConnections++;
            union(connection[0], connection[1]);
        }

        int uniqueComponents = 0;
        for(int i=0; i<n; i++){
            if(parent[i] == i)
                uniqueComponents++;
        }

        if(uniqueComponents - 1 - extraConnections > 0)
            return -1;
        else
            return uniqueComponents - 1;
    }
    public static void main(String[] args) {
        int n =6;
        int[][] connections = new int[][]{{0,1},{0,2},{0,3},{1,2}};
        System.out.println(makeConnected(n, connections));
    }
}
