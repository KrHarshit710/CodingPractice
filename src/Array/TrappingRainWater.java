package Array;

import java.util.ArrayList;

public class TrappingRainWater {

    // Optimum : TC : O(n) , SC : O(1)
    private static int trappingRainWaterIII(int[] arr){
        int n = arr.length;

        int trappedWater = 0;
        int leftMax = arr[0];
        int rightMax = arr[n-1];
        int l = 1, r = n-2;
        while(l <= r){
            if(leftMax < rightMax){
                if(leftMax > arr[l])
                    trappedWater += leftMax - arr[l];
                else
                    leftMax = arr[l];
                l++;
            } else {
                if(rightMax > arr[r])
                    trappedWater += rightMax - arr[r];
                else
                    rightMax = arr[r];
                r--;
            }
        }
        return trappedWater;
    }

    // Solution 1 : TC : O(2n) , SC : O(n)
    private static int trappingRainWaterII(int[] arr){
        int n = arr.length;
        int[] leftMax  = new int[n];
        leftMax[0] = -1;
        for(int i=1;i<n;i++)
            leftMax[i] = Integer.max(leftMax[i-1], arr[i-1]);

        int trappedWater = 0;
        int rightMax = arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(leftMax[i] > arr[i] && rightMax > arr[i]){
                trappedWater += Integer.min(leftMax[i], rightMax) - arr[i];
            }
            rightMax = Integer.max(rightMax, arr[i]);
        }
        return trappedWater;
    }

    // Solution 1 : TC : O(3n) , SC : O(2n)
    private static int trappingRainWaterI(int[] arr){
        int n = arr.length;
        int[] leftMax  = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = -1;
        for(int i=1;i<n;i++)
            leftMax[i] = Integer.max(leftMax[i-1], arr[i-1]);

        rightMax[n-1] = -1;
        for(int i=n-2;i>=0;i--)
            rightMax[i] = Integer.max(rightMax[i+1], arr[i+1]);

        int trappedWater = 0;
        for(int i=0;i<n;i++){
            if(leftMax[i] > arr[i] && rightMax[i] > arr[i]){
                trappedWater += Integer.min(leftMax[i], rightMax[i]) - arr[i];
            }
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        //int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; // Expected : 6
        //int[] arr = new int[]{3, 0, 2, 0, 4}; // Expected : 7
        //int[] arr = new int[]{2, 0, 2}; // Expected : 2
        int[] arr = new int[]{1,2,3,4,5}; // Expected : 0
        System.out.println(trappingRainWaterIII(arr));

        ArrayList<Integer> A = new ArrayList<>();
        A.stream().max(Integer::compareTo).orElse(-1);
        int sum = A.stream().map((x) -> x - 2).reduce((x,y) -> x+y).orElse(-1);
    }
}
