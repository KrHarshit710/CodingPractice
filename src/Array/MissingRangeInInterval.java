package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Write a code to find missing interval ranges given a request interval  { start, end }
    Input: List of Intervals, Request Interval
    Output: List of Intervals

    Input:
    {5, 10}, { 15 , 18} , { 20, 25}
    Request : { 2 , 30}

    Output: There are section in request interval that are not covered
    {2, 5} { 10, 15} { 18,20} {25,30}
*/
public class MissingRangeInInterval {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {20,25},
                {5,10},
                {10,15},
                {15, 18}

        };
        int[] range = new int[]{2,30};
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] < b[0])
                return 1;
            else
                return -1;
        });
        int n = 100;
        int[] filled = new int[n];
        for(int[] interval : intervals){
            filled[interval[0]+1] = 1;
            filled[interval[1]] = -1;
        }

        for(int i=1;i<n;i++){
            filled[i] = filled[i-1] + filled[i];
        }
        int l = -1;
        int r = -1;
        List<int[]> freeIntervals = new ArrayList<>();
        for(int i=range[0]; i<=range[1]; i++){
            if(filled[i] == 0){
                if(l == -1)
                    l = i;
            }else {
                if(l != -1){
                    r = i-1;
                    freeIntervals.add(new int[]{l,r});
                    l = -1;
                }
            }
        }
        for(int[] freeInterval : freeIntervals){
            System.out.println("{ " + freeInterval[0] + " , " + freeInterval[1] + " }");
        }
    }
}
