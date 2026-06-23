public class leetcode_34 {

    public boolean isSafe(char[][] board, int row, int col, char digit) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit || board[i][col] == digit) {
                return false;
            }
        }
        // check if it is inside the grid already?
        int gridRow = (row / 3) * 3;
        int gridCol = (col / 3) * 3;
        for (int i = gridRow; i < gridRow + 3; i++) {
            for (int j = gridCol; j < gridCol + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solver(char[][] board, int row, int col) {
        if (row == 9) {
            return true;
        }

        int nextRow = row;
        int nextCol = col + 1;
        if (nextCol == 9) {
            nextCol = 0;
            nextRow++;
        }

        if (board[row][col] != '.') {
            return solver(board, nextRow, nextCol);
        } else {
            // find and fit the digit.
            for (char digit = '1'; digit <= '9'; digit++) {
                if (isSafe(board, row, col, digit)) {
                    board[row][col] = digit;
                    if (solver(board, nextRow, nextCol)) {
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        solver(board, 0, 0);
        return;
    }
}
