package Tree;

public class CountNodes {


    // 22 : 15
    // n -> 1 - n -> 1 Times
    // n-1 -> 1 - n-1 -> 1 Times
    // n-2 -> 1 - n-2

    // 1 -> 1
    // 2 -> 1, 1

    // 2 -> 1, 1
    // 3 -> 2, 1, 1

    // 3 -> 2, 1, 1
    // 4 -> 3, 2, 1, 1

    // 5 -> 5, 3, 2, 1, 1


     //                                           5
    /*
                            4                                       3
                3                         2
        2            1           1            0
    1      0      0     -1    0     -1   -1      -2

     */
    private static void countNodes(int n){
        long[][] N = new long[65][65];
        N[0][0] = 1;
        N[1][0] = 1; N[1][1] = 1;

        for(int i=2;i<n;i++){
            for(int j=0;j<n;j++){
                N[i][j] = N[i-1][j] + N[i-2][j];
            }
            N[i][i] = 1;
        }
        for(int i=0;i<n;i++)
            System.out.print(N[n-1][i] + " ");

        System.out.println();
    }
    public static void main(String[] args) {
        countNodes(4);
        countNodes(5);
        countNodes(6);
        countNodes(62);
    }
}
