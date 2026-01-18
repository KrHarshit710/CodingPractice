package Backtracking;

//https://leetcode.com/problems/sudoku-solver/
public class SudokuSolver {

    private static boolean validateRow(String[][] sudoku, int row, int num){
        for(int i=0;i<9;i++) {
            if (!sudoku[row][i].equals(".") && Integer.parseInt(sudoku[row][i]) == num)
                return false;
        }
        return true;
    }

    private static boolean validateCol(String[][] sudoku, int col, int num){
        for(int i=0;i<9;i++) {
            if (!sudoku[i][col].equals(".") && Integer.parseInt(sudoku[i][col]) == num)
                return false;
        }
        return true;
    }

    private static boolean validateSquare(String[][] sudoku,int row, int col, int num){
        for(int i = row/3 * 3; i < row/3 * 3 + 3; i++) {
            for(int j = col/3 * 3; j < col/3 * 3 + 3; j++){
                if(!sudoku[i][j].equals(".") && Integer.parseInt(sudoku[i][j]) == num)
                        return false;
            }
        }
        return true;
    }

    private static boolean isSolved(String[][] sudoku){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(sudoku[i][j].equals("."))
                    return false;
            }
        }
        return true;
    }

    private static boolean solveSudoku(String[][] sudoku){
        if(isSolved(sudoku))
            return true;

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(sudoku[i][j].equals(".")){
                    for(int k=1;k<=9;k++){
                        if(validateRow(sudoku, i, k) && validateCol(sudoku, j, k) && validateSquare(sudoku, i, j, k)){
                            sudoku[i][j] = String.valueOf(k);
                            if(solveSudoku(sudoku))
                                return true;
                            sudoku[i][j] = ".";
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String[][] board = new String[][]
                {{"5","3",".",".","7",".",".",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}};


        solveSudoku(board);

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
