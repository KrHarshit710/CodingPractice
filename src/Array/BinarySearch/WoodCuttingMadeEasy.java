package Array.BinarySearch;
import java.util.ArrayList;
import java.util.List;

/*
    Problem Description

    There is given an integer array A of size N denoting the heights of N trees. Lumberjack Ojas needs to
    chop down B metres of wood. It is an easy job for him since he has a nifty new woodcutting machine that
    can take down forests like wildfire. However, Ojas is only allowed to cut a single row of trees.
    Ojas's machine works as follows: Ojas sets a height parameter H (in metres), and the machine raises a giant
    sawblade to that height and cuts off all tree parts higher than H (of course, trees not higher than H meters
    remain intact). Ojas then takes the parts that were cut off. For example, if the tree row contains trees with
    heights of 20, 15, 10, and 17 metres, and Ojas raises his sawblade to 15 metres, the remaining tree heights
    after cutting will be 15, 15, 10, and 15 metres, respectively, while Ojas will take 5 metres off the first
    tree and 2 metres off the fourth tree (7 metres of wood in total).

    Ojas is ecologically minded, so he doesn't want to cut off more wood than necessary. That's why he wants to
    set his sawblade as high as possible. Help Ojas find the maximum integer height of the sawblade that still
    allows him to cut off at least B metres of wood.

    NOTE:
    The sum of all heights will exceed B, thus Ojas will always be able to obtain the required amount of wood.

    Problem Constraints
    1 <= N <= 10^6
    1 <= A[i] <= 10^6
    1 <= B <= 2106

 */




public class WoodCuttingMadeEasy {
    // note return type is long
    private static long findWood(ArrayList<Integer> A, int h){
        int n = A.size();
        long woodCollected = 0;
        for(int i=0;i<n;i++){
            woodCollected += Integer.max(A.get(i) - h, 0);
        }
        return woodCollected;
    }
    private static int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int maxHeightOfTree = -1;
        for(int i=0;i<n;i++)
            maxHeightOfTree = Integer.max(maxHeightOfTree, A.get(i));

        int l = 0;
        int r = maxHeightOfTree;
        int h;
        long woodCollected;
        int optimumHeight = 0;
        while(l <= r){
            h = (l + r) /2;

            woodCollected = findWood(A,h);

            if(woodCollected >= (long)B) {
                optimumHeight = h;
                l = h + 1;
            } else {
                r = h-1;
            }
        }

        return optimumHeight;

    }
    public static void main(String[] args) {
//        ArrayList<Integer> A = new ArrayList<>(List.of(20, 15, 10, 17));
//        int B = 7;
//        System.out.println(solve(A, B)); // Expected : 15

        ArrayList<Integer> A = new ArrayList<>(List.of(4, 42, 40, 26, 46));
        int B = 20;
        System.out.println(solve(A, B)); // Expected : 36
    }


}
