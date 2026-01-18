package Array;

import java.util.Arrays;

// https://leetcode.com/problems/boats-to-save-people/description/
public class BoatsToSavePeople {
    public static int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);

        int l = 0;
        int r = n-1;
        int boats = 0;
        while(l<=r){
            if(people[l] + people[r] <= limit){
                boats++;
                l++;
                r--;
            }else{
                boats++;
                r--;
            }
        }
        return boats;
    }
    public static void main(String[] args) {
        int[] people = new int[]{3,5,3,4};
        int limit = 5;

        System.out.println(numRescueBoats(people, limit));

    }
}
