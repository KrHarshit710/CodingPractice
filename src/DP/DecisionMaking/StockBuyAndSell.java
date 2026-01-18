package DP.DecisionMaking;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/ - buy once, sell once
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/ - buy n times, sell n times
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/ - buy and sell atmost 2 times
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/ - buy and sell atmost K times
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/ - buy and cell with cool down
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
public class StockBuyAndSell {

    public static int buyOnceSellOnce(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int minEle = prices[0];
        for(int i=1;i<n;i++){
            if(prices[i]>minEle){
                maxProfit = Integer.max(maxProfit, prices[i] - minEle);
            }else{
                minEle = prices[i];
            }
        }
        return maxProfit;
    }

    private static int[][] dp;
    private static int buyAndSell(int[] prices, int i, int n, int hasBought){
        if(i==n)
            return 0;
        if(dp[i][hasBought] != -1)
            return dp[i][hasBought];
        if(hasBought == 1){
            return dp[i][hasBought] = Integer.max(prices[i] + buyAndSell(prices,i+1,n,0), buyAndSell(prices,i+1,n,1));
        }else{
            return dp[i][hasBought] = Integer.max(-prices[i] + buyAndSell(prices,i+1,n,1), buyAndSell(prices,i+1,n,0));
        }
    }

    private static int[][][] dp2;
    private static int buyAndSellTwice(int[] prices, int i, int n, int hasBought, int sellCount){
        if(i==n || sellCount >= 2)
            return 0;
        if(dp2[i][hasBought][sellCount] != -1)
            return dp2[i][hasBought][sellCount];
        if(hasBought == 1){
            return dp2[i][hasBought][sellCount] = Integer.max(prices[i] + buyAndSellTwice(prices,i+1,n,0,sellCount+1), buyAndSellTwice(prices,i+1,n,1,sellCount));
        }else{
            return dp2[i][hasBought][sellCount] = Integer.max(-prices[i] + buyAndSellTwice(prices,i+1,n,1,sellCount), buyAndSellTwice(prices,i+1,n,0,sellCount));
        }
    }

    private static int[][] dp4;
    private static int buyAndSellWithCooldown(int[] prices, int i, int n, int hasBought){
        if(i>=n)
            return 0;

        if(dp4[i][hasBought] != -1)
            return dp4[i][hasBought];

        if(hasBought == 1){
            return dp4[i][hasBought] = Integer.max(prices[i] + buyAndSellWithCooldown(prices,i+2,n,0), buyAndSellWithCooldown(prices,i+1,n,1));
        }else{
            return dp4[i][hasBought] = Integer.max(-prices[i] + buyAndSellWithCooldown(prices,i+1,n,1), buyAndSellWithCooldown(prices,i+1,n,0));
        }
    }

    private static int[][][] dp3;
    private static int buyAndSellKTimes(int[] prices, int i, int n, int k, int hasBought, int sellCount){
        if(i==n || sellCount >= k)
            return 0;
        if(dp3[i][hasBought][sellCount] != -1)
            return dp3[i][hasBought][sellCount];
        if(hasBought == 1){
            return dp3[i][hasBought][sellCount] = Integer.max(prices[i] + buyAndSellKTimes(prices,i+1,n,k,0,sellCount+1), buyAndSellKTimes(prices,i+1,n,k,1,sellCount));
        }else{
            return dp3[i][hasBought][sellCount] = Integer.max(-prices[i] + buyAndSellKTimes(prices,i+1,n,k,1,sellCount), buyAndSellKTimes(prices,i+1,n,k,0,sellCount));
        }
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,0,4};
        int n = prices.length;
        dp = new int[n][2];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], -1);
        System.out.println(buyOnceSellOnce(prices)); // maximize profit -> buy once, sell once

        System.out.println(buyAndSell(prices,0,n,0)); // maximize profit -> buy n times, sell n times

        dp2 = new int[n][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    dp2[i][j][k] = -1;
                }
            }
        }
        System.out.println(buyAndSellTwice(prices,0,n,0,0)); // maximize profit -> buy 2 times, sell 2 times

        int K = 3;
        dp3 = new int[n][2][K+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<K+1;k++){
                    dp3[i][j][k] = -1;
                }
            }
        }
        System.out.println(buyAndSellKTimes(prices,0,n,3,0,0));

        dp4 = new int[n][2];
        for(int i=0;i<n;i++)
            Arrays.fill(dp4[i], -1);

        System.out.println(buyAndSellWithCooldown(prices, 0, n, 0));


    }
}
