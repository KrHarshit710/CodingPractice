package Array.BinarySearch;

// https://leetcode.com/problems/koko-eating-bananas/
public class KokoEatingBananas {
    private static int ciel(int x, int y){
        if(x % y == 0)
            return x / y;
        else
            return x / y + 1;
    }
    private static int calculateEatingTime(int[] piles, int perHour){
        int eatingTime = 0;
        for (int pile : piles)
            eatingTime += ciel(pile, perHour);

        return eatingTime;
    }
    public static int minEatingSpeed(int[] piles, int H) {
        int maxInAnHour = 0;
        for (int pile : piles)
            maxInAnHour = Integer.max(maxInAnHour, pile);

        int l = 1;
        int r = maxInAnHour;
        int h;
        int eatingTime;
        int minPerHour = maxInAnHour;
        while(l<=r){
            h = (l + r)/2;
            eatingTime = calculateEatingTime(piles, h);
            if(eatingTime <= H){
                minPerHour = h;
                r = h-1;
            }else{
                l = h+1;
            }
        }
        return minPerHour;
    }
    public static void main(String[] args) {
        int[] piles = new int[]{3,6,7,11};
        int h = 8;

        System.out.println(minEatingSpeed(piles, h)); // Expected : 4

        piles = new int[]{30,11,23,4,20};
        h = 5;

        System.out.println(minEatingSpeed(piles, h)); // Expected : 30

        piles = new int[]{30,11,23,4,20};
        h = 6;

        System.out.println(minEatingSpeed(piles, h)); // Expected : 23

        piles = new int[]{312884470};
        h = 968709470;

        System.out.println(minEatingSpeed(piles, h)); // Expected : 1


    }
}
