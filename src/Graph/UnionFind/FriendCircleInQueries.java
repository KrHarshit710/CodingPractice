package Graph.UnionFind;

import java.util.*;

// https://www.hackerrank.com/challenges/friend-circle-queries/problem
public class FriendCircleInQueries {
    static Map<Integer, Integer> parent;
    static Map<Integer, Integer> size;

    static int find(int i){
        if(parent.get(i) == i)
            return i;
        else {
            int p = find(parent.get(i));
            parent.put(i, p);
            return p;
        }
    }
    static void union(int i, int j){
        int iP = find(i);
        int jP = find(j);

        if(iP != jP) {
            if(size.get(iP) < size.get(jP)) {
                parent.put(jP, iP);
                size.put(iP, size.get(iP) + size.get(jP));
            } else {
                parent.put(iP, jP);
                size.put(jP, size.get(iP) + size.get(jP));
            }
        }
    }
    // Complete the maxCircle function below.
    static int[] maxCircle(int[][] queries) {

        parent = new HashMap<>();
        size = new HashMap<>();

        List<Integer> maxCircleResult = new ArrayList<>();
        int maxCircl = 0;
        for(int[] query : queries){
            parent.putIfAbsent(query[0], query[0]);
            size.putIfAbsent(query[0], 1);
            parent.putIfAbsent(query[1], query[1]);
            size.putIfAbsent(query[1], 1);
            union(query[0],query[1]);
            maxCircl = Integer.max(maxCircl, size.get(find(query[0])));
            maxCircleResult.add(maxCircl);
        }
        return maxCircleResult.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[][] queries = new int[][]{
                {6,4}, {5,9}, {8,5}, {4,1}, {1,5}, {7,2}, {4,2}, {7,6}
        };
        //Output : 2 2 3 3 6 6 8 8
        int[] maxCircleResult = maxCircle(queries);
        Arrays.stream(maxCircleResult).forEach(System.out::println);
    }

}
