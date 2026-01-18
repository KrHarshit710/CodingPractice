package Array.BinarySearch;

public class BinarySearchInSortedRotatedArray {

    private static int binarySearch(int[] arr, int k, int i, int j){
        int l = i;
        int r = j;
        int m;
        while(l<=r){
            m = (l+r)/2;
            if(arr[m] == k)
                return m;
            else if(arr[m] < k){
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return -1;
    }

    private static int findPivot(int[] arr){
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        int m;
        while(l<=r){
            m = (l+r)/2;
            if(m>0 && m<n && arr[m] < arr[m-1] && arr[m] < arr[m+1]){
                return m;
            } else if(arr[m] < arr[r]){
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,6,7,1,2,3,4};
        int k = 6;
        int pivot = findPivot(arr);
        if(k > arr[0]){
            System.out.println(binarySearch(arr, k, 0, pivot-1));
        }else{
            System.out.println(binarySearch(arr, k, pivot, arr.length - 1));
        }
    }
}
