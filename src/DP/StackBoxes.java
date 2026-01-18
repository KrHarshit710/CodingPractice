package DP;

import java.util.Arrays;

public class StackBoxes {

    private static int findMaxHeight(int[][] boxes){
        int n = boxes.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++)
            dp[i] = boxes[i][0];
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(boxes[j][1] > boxes[i][1] && boxes[j][2] > boxes[i][2]){
                    dp[i] = Integer.max(dp[i], dp[j] + boxes[i][0]);
                }
            }
        }
        int maxHeight = -1;
        for(int i=0;i<n;i++)
            maxHeight = Integer.max(maxHeight, dp[i]);

        return maxHeight;

    }
    //h,b,l
    private static int[][] generateAllBoxesCombination(int[][] boxes){
        int n = boxes.length;
        int[][] allboxesCombination = new int[3*n][3];
        int h,b,l;
        for(int i=0;i<n;i++){
            h = boxes[i][0];
            b = Integer.min(boxes[i][1],boxes[i][2]);
            l = Integer.max(boxes[i][1],boxes[i][2]);

            allboxesCombination[3*i+0] = new int[]{h, b, l};

            h = boxes[i][1];
            b = Integer.min(boxes[i][0],boxes[i][2]);
            l = Integer.max(boxes[i][0],boxes[i][2]);

            allboxesCombination[3*i+1] = new int[]{h, b, l};

            h = boxes[i][2];
            b = Integer.min(boxes[i][0],boxes[i][1]);
            l = Integer.max(boxes[i][0],boxes[i][1]);

            allboxesCombination[3*i+2] = new int[]{h, b, l};
        }

        Arrays.sort(allboxesCombination, (x, y) -> {
            if(x[1] <= y[1]){
                if(x[2] > y[2])
                    return -1;
                else
                    return 1;
            } else {
                return -1;
            }
        });

        for(int i=0;i<3*n;i++){
            h = allboxesCombination[i][0];
            b = allboxesCombination[i][1];
            l = allboxesCombination[i][2];
            System.out.println("{ " + h + " " + b + " " + l + " }");
        }

        return allboxesCombination;
    }

    public static void main(String[] args) {

        int[][] boxes = new int[][]{
                {4,6,7},
                {1,2,3},
                {4,5,6},
                {10,12,32}
        };

        System.out.println(findMaxHeight(generateAllBoxesCombination(boxes)));
    }
}
