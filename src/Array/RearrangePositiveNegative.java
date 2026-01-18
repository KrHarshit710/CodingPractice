package Array;

import java.util.Arrays;

public class RearrangePositiveNegative {
    private static int[] rearrangePositiveNegative(int[] arr){
        int n = arr.length;
        int negPtr = 0;
        for(int i=0;i<n;i++){
            if(arr[i] < 0){
                int temp = arr[negPtr];
                arr[negPtr] = arr[i];
                arr[i] = temp;
                negPtr++;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{-2, 5, 4, 12, 15, -1, 11, -8};
        Arrays.stream(rearrangePositiveNegative(arr)).forEach(System.out::println);
    }
}
