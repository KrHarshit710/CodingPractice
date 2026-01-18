package Graph.DFS;

// https://leetcode.com/problems/number-of-islands
// https://leetcode.com/problems/number-of-closed-islands/description/
// https://leetcode.com/problems/flood-fill/description/
// https://leetcode.com/problems/max-area-of-island/description/
public class CountIsland {
    private final int[] dirX = new int[]{-1,0,1,0};
    private final int[] dirY = new int[]{0,1,0,-1};
    private int m , n;
    private void dfs(char[][] grid, int x, int y){
        if(x<0 || x>=m || y<0 || y>=n)
            return;
        if(grid[x][y] != '1')
            return;
        grid[x][y] = '*';
        for(int i=0;i<4;i++){
            dfs(grid,x+dirX[i], y+dirY[i]);
        }
    }
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int islands = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','1','1','0'},
                {'0','0','0','0','1'}
        };

        System.out.println(new CountIsland().numIslands(grid));
    }
}
