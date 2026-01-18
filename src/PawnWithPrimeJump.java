import java.util.ArrayList;
import java.util.List;

public class PawnWithPrimeJump {

    private static int[] dp;
    private static List<Integer> primes;
    private static int util(List<Integer> cells, int i, int n) {
        if(i>=n)
            return -10005;
        if(i==n-1)
            return dp[i] = cells.get(i);
        if(dp[i] != Integer.MIN_VALUE)
            return dp[i];

        int maxVal = -10005;
        for(int prime : primes){
            maxVal = Integer.max(maxVal, util(cells, i + prime, n));
        }
        maxVal = Integer.max(maxVal, util(cells, i+1, n));

        return dp[i] = maxVal + cells.get(i);
    }
    public static int pawnWithPrimeJump(List<Integer> cells){
        int n = cells.size();
        dp = new int[n+1];
        for(int i=0;i<=n;i++)
            dp[i] = Integer.MIN_VALUE;

        // Calculate Primes
        primes = new ArrayList<>();
        boolean[] isPrime = new boolean[10005];
        for(int i=0;i<10005;i++)
            isPrime[i] = true;

        for(int i=2;i<10005/2;i++){
            for(int j=2*i;j<n;j=j+i){
                isPrime[i] = false;
            }
        }

        for(int i=3;i<n;i++){
            if(isPrime[i] && i%10 == 3){
                primes.add(i);
                System.out.println(i);
            }
        }

        return util(cells, 0, n);

    }

    public static void main(String[] args) {

        List<Integer> cells = new ArrayList<>();
        cells.add(0);
        cells.add(-10);
        cells.add(100);
        cells.add(-20);

        System.out.println(pawnWithPrimeJump(cells));
    }
}
