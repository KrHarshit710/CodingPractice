package Graph.DFS;

// https://leetcode.com/problems/surrounded-regions/description/
// https://leetcode.com/problems/number-of-enclaves/description/
public class SurroundedRegion {
    private static int[] dirX = new int[]{-1,0,1,0};
    private static int[] dirY = new int[]{0,1,0,-1};
    private static void dfs(char[][] board, int x, int y){
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            return;
        if(board[x][y] != 'O')
            return;
        board[x][y] = '*';
        for(int i=0;i<4;i++)
            dfs(board, x+dirX[i], y+dirY[i]);
    }
    public static void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;

        for(int j=0;j<c;j++){
            if(board[0][j] == 'O')
                dfs(board, 0, j);
        }

        for(int j=0;j<c;j++){
            if(board[r-1][j] == 'O')
                dfs(board, r-1, j);
        }

        for(int i=0;i<r;i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 0);
            }
        }

        for(int i=0;i<r;i++){
            if(board[i][c-1] == 'O'){
                dfs(board, i, c-1);
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }
    public static void main(String[] args) {

    }
}
