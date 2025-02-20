
public class Sudoku_solver {
    public boolean isSafe(char[][] board, int row, int col, int number) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == (char) (number + '0')) {
                return false;
            }
            if (board[row][i] == (char) (number + '0')) {
                return false;
            }
        }

        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == (char) (number + '0')) {
                    return false;
                }
            }
        }
        return true; // Missing return statement added
    }

    public boolean helper(char[][] board, int row, int column) {
        if (row == board.length) {
            return true; // Solved successfully
        }

        int new_row = row;
        int new_column = column + 1;
        if (column == board.length - 1) {
            new_row = row + 1;
            new_column = 0;
        }

        if (board[row][column] != '.') { // If already filled, move to the next cell
            return helper(board, new_row, new_column);
        }

        for (int i = 1; i <= 9; i++) {
            if (isSafe(board, row, column, i)) {
                board[row][column] = (char) (i + '0');
                if (helper(board, new_row, new_column)) {
                    return true;
                }
                board[row][column] = '.'; // Backtrack
            }
        }
        return false; // No valid number found
    }

    public void SolveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    public static void main(String[] args) {
        Sudoku_solver solver = new Sudoku_solver();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        solver.SolveSudoku(board);

        // Print solved Sudoku
        for (char[] row : board) {
            for (char num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
