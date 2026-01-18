package Graph.BFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

// https://leetcode.com/problems/keys-and-rooms/description/
public class KeysAndRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        queue.offer(0);
        visited[0] = true;

        int room;
        while(!queue.isEmpty()){
            room = queue.poll();
            for(int j : rooms.get(room)){
                if(!visited[j])
                    queue.offer(j);
                visited[j] = true;
            }
        }

        for(int i=0;i<n;i++){
            if(!visited[i])
                return false;
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(canVisitAllRooms(List.of(List.of(1),List.of(2),List.of(3),List.of())));
        System.out.println(canVisitAllRooms(List.of(List.of(1,3),List.of(3,0,1),List.of(2),List.of(0))));
    }
}
