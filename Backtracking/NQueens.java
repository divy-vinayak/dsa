package Backtracking;

// Place N queens on a NxN chessboard such that no queen can attack any other queen
public class NQueens {
    public static void printBoard(char board[][]){
        System.out.println("--------- Chess Board ---------");
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j] + " ");
            }System.out.println();
        }
    }

    public static boolean isSafe(char board[][], int row, int col){
        for(int i = row; i >= 0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        for(int i = row, j = col; i >= 0 && j < board[row].length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static void printNQueens(char board[][], int row){
        // base case
        if(row == board.length){
            printBoard(board);
            return;
        }
        // recursion
        for(int j = 0; j < board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                printNQueens(board, row+1);
                board[row][j] = 'x';
            }
        }
    }
    public static void main(String[] args) {
        int n = 5;
        char board[][] = new char[n][n];

        // initialize the board
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = 'x';
            }
        }

        printNQueens(board, 0);
    }
}
