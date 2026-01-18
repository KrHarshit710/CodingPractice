package Graph.UnionFind;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/number-of-provinces/description/
public class NumberOfProvince {
    private static int[] parent;
    private static int[] rank;
    private static int find(int i){
        if(parent[i] != i)
            parent[i] = find(parent[i]);

        return parent[i];
    }
    private static void combine(int i, int j){
        int iParent = find(i);
        int jParent = find(j);

        if(iParent == jParent)
            return;

        int iRank = rank[i];
        int jRank = rank[j];

        if(iRank < jRank){
            parent[iParent] = jParent;
        } else if( jRank < iRank){
            parent[jParent] = iParent;
        } else {
            parent[jParent] = iParent;
            rank[iParent]++;
        }
    }
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n+1];
        rank = new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i] = i;
            rank[i] = 0;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j] == 1){
                    combine(i+1,j+1);
                }
            }
        }
        Set<Integer> provinces = new HashSet<>();
        for(int i=1;i<=n;i++){
            provinces.add(find(i));
        }

        return provinces.size();
    }

    public static void main(String[] args) {
        int[][] isConnected = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }
}
