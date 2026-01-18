package Backtracking;

public class NQueen {
    private static int count;
    private static int n;
    private static boolean isValid(int[][] board, int row, int col)
    {
        for(int c = 0; c<n; c++)
        {
            if(board[row][c] == 1)
                return false;
        }

        for(int r = 0; r<n; r++)
        {
            if(board[r][col] == 1)
                return false;
        }

        //check diagonally above
        for(int i = row,j = col; i>=0 && j>=0; i--,j--)
        {
            if(board[i][j] == 1)
                return false;
        }

        //check diagonally down
        for(int i = row, j = col; i< n && j< n; i++,j++)
        {
            if(board[i][j] == 1)
                return false;
        }

        //check reverse diagonally up
        for(int i = row, j = col; i>=0 && j< n; i--,j++)
        {
            if(board[i][j] == 1)
                return false;
        }

        //check reverse diagonally down
        for(int i = row, j = col; i< n && j>=0; i++,j--)
        {
            if(board[i][j] == 1)
                return false;
        }

        return true;
    }

    private static void solve(int[][] board, int n)
    {
        if(n == 0)
        {
            count++;
            return;
        }

        for(int j=NQueen.n-1;j>=0;j--)
        {
            if(isValid(board, n-1, j))
            {
                board[n-1][j] = 1;
                solve(board,n-1);
                board[n-1][j] = 0;
            }
        }

    }

    public static int totalNQueens(int n) {

        int[][] chessBoard = new int[n][n];

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                chessBoard[i][j] = 0;
        NQueen.n = n;
        NQueen.count = 0;

        solve(chessBoard,n);

        return count;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
}

