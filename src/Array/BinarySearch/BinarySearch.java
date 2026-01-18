package Array.BinarySearch;

public class BinarySearch {

    private static int binarySearch(int[] arr, int l, int r, int k){
        while(l<=r){
            int m = (l + r)/2;
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

    private static int binarySearchInDecreasingArray(int[] arr, int l, int r, int k) {
        while(l<=r){
            int m = (l + r)/2;
            if(arr[m] == k)
                return m;
            else if(arr[m] > k){
                l = m+1;
            }else {
                r = m-1;
            }
        }
        return -1;
    }

    private static int binarySearchInYArray(int[] arr, int k){
        int n = arr.length;
        int l = 0;
        int r = n-1;
        int inflectionPoint = -1;
        while(l<=r){
            int m = (l+r)/2;
            if(m-1>=0 && arr[m-1] > arr[m] && m+1<n && arr[m+1] > arr[m] ){
                inflectionPoint = m;
                break;
            }else if(m-1>=0 && arr[m-1] < arr[m]){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        int index;
        if(inflectionPoint == -1){
            if(arr[0] < arr[n-1]){
                index = binarySearch(arr, 0, n-1, k);
            } else {
                index = binarySearchInDecreasingArray(arr, 0, n-1, k);
            }
        }else {
            index = binarySearch(arr,inflectionPoint,n-1,k);
            if(index == -1) {
                index = binarySearchInDecreasingArray(arr, 0, inflectionPoint, k);
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{17, 15, 13, 11, 7, 8, 9, 24, 25, 29};
        int k = 24;

        System.out.println(binarySearchInYArray(arr, k));
        System.out.println(binarySearchInYArray(arr, 15));
        System.out.println(binarySearchInYArray(arr, 5));

        arr = new int[]{1,2,3,4,5,6,7};
        k = 14;
        System.out.println(binarySearchInYArray(arr, k));

        arr = new int[]{7,6,5,4,3,2};
        k = 4;
        System.out.println(binarySearchInYArray(arr, k));
    }
}
