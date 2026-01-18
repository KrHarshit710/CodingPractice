package Graph.UnionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountMutualFriends {

    public static void main(String[] args) {
        int n = 5;
        List<int[]> friends = new ArrayList<>();
        friends.add(new int[]{1, 2});
        friends.add(new int[]{2,3});
        friends.add(new int[]{4,5});
        friends.add(new int[]{2,5});

        int[] mutualFriendCount = countMutualFriends(friends, n);

        for(int i=0;i<=n;i++){
            System.out.println(mutualFriendCount[i]);
        }
    }

    private static boolean[] visited;
    private static int[] countMutual;
    private static int count;
    private static void dfs(List<List<Integer>> adjList, int i) {
        visited[i] = true;
        countMutual[i] = 0;
        count = count + 1;
        for(int next : adjList.get(i)){
            if(!visited[next]){
                dfs(adjList, next);
            }
        }
    }

    private static int[] countMutualFriends(List<int[]> friends, int n) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] pair : friends){
            adjList.get(pair[0]).add(pair[1]);
            adjList.get(pair[1]).add(pair[0]);
        }

        countMutual = new int[n+1];
        Arrays.fill(countMutual, -1);

        visited = new boolean[n+1];
        Arrays.fill(visited, false);

        for(int i=1;i<=n;i++){
            if(!visited[i]){
                count = 0;
                dfs(adjList, i);
            }
            for(int j=0; j <= n; j++){
                if(countMutual[j] == 0)
                    countMutual[j] = count;
            }
        }

        return countMutual;
    }
}
