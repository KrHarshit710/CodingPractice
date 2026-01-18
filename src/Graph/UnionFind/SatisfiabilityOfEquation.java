package Graph.UnionFind;

// https://leetcode.com/problems/satisfiability-of-equality-equations/description/
public class SatisfiabilityOfEquation {
    private static int[] parent;
    private static int[] rank;
    private static int find(int i){
        if(parent[i] != i)
            parent[i] = find(parent[i]);

        return parent[i];
    }
    private static void union(int i, int j){
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
    public static boolean equationsPossible(String[] equations) {
        int n = 26;
        parent = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 0;
        }

        for(String equation : equations){
            if(equation.charAt(1) == '='){
                union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }
        for(String equation : equations){
            if(equation.charAt(1) == '!'){
                if(find(equation.charAt(0) - 'a') == find(equation.charAt(3) - 'a'))
                    return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        String[] equations = new String[]{"a==b","b!=a"};
        System.out.println(equationsPossible(equations));
    }
}
