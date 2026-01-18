package Array;

import java.util.Arrays;

public class MergeSort {
    private static void merge(int[] arr, int l, int m, int r){
        int n = r-l+1;
        int[] sortedSubArray = new int[n];
        int i = l;
        int j = m+1;
        int k = 0;
        while(i<=m && j<=r){
            if(arr[i]<arr[j]){
                sortedSubArray[k] = arr[i];
                i++;
            }else {
                sortedSubArray[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i<=m){
            sortedSubArray[k] = arr[i];
            i++;
            k++;
        }
        while(j<=r){
            sortedSubArray[k] = arr[j];
            j++;
            k++;
        }
        j = l;
        for(i=0;i<n;i++,j++){
            arr[j] = sortedSubArray[i];
        }
    }
    private static void mergeSort(int[] arr, int l, int r){
        if(l>=r)
            return;
        int m = (l+r)/2;
        mergeSort(arr,l,m);
        mergeSort(arr,m+1,r);
        merge(arr, l, m, r);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{5,9,1,23,11,15,2,7};
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("------------------");
        mergeSort(arr,0,7);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
