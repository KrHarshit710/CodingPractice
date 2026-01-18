package DP;

import java.util.Arrays;

// https://leetcode.com/problems/jump-game-ii/description/
public class JumpGameII {
    private static int minJumps(int[] jump){
        int n = jump.length;
        int[] minJump = new int[n];
        // Initialize with n as max value can be n-1 , hence anything above that. INT_MAX not an option as
        // INT_MAX + 1 will become -ve.
        Arrays.fill(minJump, n);
        minJump[n-1] = 0;

        for(int i=n-2;i>=0;i--){
            for(int j=i+1; j<=i+jump[i] && j<n ;j++){
                minJump[i] = Integer.min(minJump[i], minJump[j] + 1);
            }
        }
        return minJump[0];
    }
    public static void main(String[] args) {
        int[] jump = new int[]{1,1,1,1,1};
        System.out.println(minJumps(jump));
    }
}
