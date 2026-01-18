package Graph.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/time-needed-to-inform-all-employees/description/
public class TimeToInformEmployees {
    private static int[] minInformTime;
    private static int minNumOfMinutes(int managerId, int[] informTime, List<List<Integer>> adjList ){
        List<Integer> reportees = adjList.get(managerId);
        int minTime = 0;
        for(Integer reportee : reportees)
            minTime = Integer.max(minTime, informTime[managerId] + minNumOfMinutes(reportee, informTime, adjList));

        return minTime;
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        minInformTime = new int[n];
        Arrays.fill(minInformTime, Integer.MAX_VALUE);

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            if(manager[i] != -1)
                adjList.get(manager[i]).add(i);
        }

        return minNumOfMinutes(headID, informTime, adjList);
    }
    public static void main(String[] args) {

    }
}
