public class NQueenProblem {
    private int n;
    private int[][] board;

    public NQueenProblem(int n) {
        this.n = n;
        this.board = new int[n][n];
    }

    public void solveNQueens() {
        if (placeQueens(0)) {
            displayBoard();
        } else {
            System.out.println("No solution exists.");
        }
    }

    private boolean placeQueens(int column) {
        if (column >= n) {
            return true; // All queens have been successfully placed
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, column)) {
                board[row][column] = 1; // Place the queen at row, column

                if (placeQueens(column + 1)) {
                    return true; // Queen has been successfully placed in the current column
                }

                // Backtrack and remove the queen from the current position
                board[row][column] = 0;
            }
        }

        return false; // Queen cannot be placed in the current column
    }

    private boolean isSafe(int row, int column) {
        // Check if there is a queen in the same row
        for (int i = 0; i < column; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check if there is a queen in the upper diagonal
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check if there is a queen in the lower diagonal
        for (int i = row, j = column; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true; // It is safe to place a queen at the given row, column
    }

    private void displayBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 8; // Number of queens and size of the chessboard
        NQueenProblem problem = new NQueenProblem(n);
        problem.solveNQueens();
    }
}
