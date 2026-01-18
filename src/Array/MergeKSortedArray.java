package Array;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArray {

    private static ArrayList<Integer> mergeKSortedArray(int[][] arrays, int m, int n){
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>((a,b) -> {
            if(a.val < b.val)
                return -1;
            else
                return 1;
        });

        for(int i=0;i<m;i++)
            minHeap.offer(new HeapNode(arrays[i][0], i, 0));

        ArrayList<Integer> mergedArray = new ArrayList<>();
        while(!minHeap.isEmpty()){
            HeapNode node = minHeap.poll();
            mergedArray.add(node.val);
            if(node.j + 1 < n){
                minHeap.offer(new HeapNode(arrays[node.i][node.j+1], node.i, node.j + 1));
            }
        }

        return mergedArray;
    }
    public static void main(String[] args) {
        int[][] arrays = new int[][]{
                {1,2,3,44,55},
                {12,13,14,15,16},
                {21,22,23,24,25},
                {17,18,28,32,44}
        };
        int m = 4;
        int n = 5;

        ArrayList<Integer> mergedKSortedArray = mergeKSortedArray(arrays, m, n);

        mergedKSortedArray.stream().forEach(e -> System.out.print(e + " "));

    }
    static class HeapNode{
        int val;
        int i;
        int j;

        HeapNode(int val, int i, int j){
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }
}
