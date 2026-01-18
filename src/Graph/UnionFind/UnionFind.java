package Graph.UnionFind;

// TODO
public class UnionFind {
    private static int[] parent;
    private static int[] size;

    public static void main(String[] args) {
        int n = 10;
        int[][] friendList = new int[][]{{1,2},{2,3},{4,6},{5,6},{7,8},{1,5}};
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        union(friendList);
        System.out.println("Friends(3,6) ? " + areFriends(3,6));
        System.out.println("Friends(0,1) ? " + areFriends(0,1));
        System.out.println("Friends(4,6) ? " + areFriends(4,6));

        System.out.println("Total Friends(5) : " + findMutualFriends(5));
        System.out.println("Total Friends(9) : " + findMutualFriends(9));
        System.out.println("Total Friends(7) : " + findMutualFriends(7));
    }
    private static int find(int i){
        if(parent[i] == i)
            return i;
        else
            return parent[i] = find(parent[i]);
    }
    private static void union(int[][] friendList){
        for(int[] friend : friendList){
            int iP = find(friend[0]);
            int jP = find(friend[1]);

            if(iP != jP) {
                if(size[iP] < size[jP]) {
                    parent[jP] = iP;
                    size[iP] += size[jP];
                } else {
                    parent[iP] = jP;
                    size[jP] += size[iP];
                }
            }
        }
    }
    private static boolean areFriends(int a, int b) {
        return find(a) == find(b) ;
    }

    private static int findMutualFriends(int a) {
        return size[find(a)] ;
    }
}
