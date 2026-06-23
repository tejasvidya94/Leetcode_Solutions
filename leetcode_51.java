import java.util.ArrayList;
import java.util.List;

public class leetcode_51 {
    List<List<String>> ans = new ArrayList<>();

    public void solver(
            char[][] board,
            int row,
            int n,
            int[] colArr,
            int[] diag,
            int[] antiDiag) {
        // base condition
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (char[] rowTemp : board) {
                temp.add(new String(rowTemp));
            }
            ans.add(new ArrayList<>(temp));
            return;
        }

        // find correct col for the current row.
        for (int col = 0; col < n; col++) {
            if (colArr[col] == 1) {
                continue;
            }
            if (diag[row - col + n - 1] == 1) {
                continue;
            }
            if (antiDiag[row + col] == 1) {
                continue;
            }
            board[row][col] = 'Q';
            colArr[col] = 1;
            diag[row - col + n - 1] = 1; // for diag shift by n-1 to the right
            antiDiag[row + col] = 1; // no need to shift

            solver(board, row + 1, n, colArr, diag, antiDiag); // forward

            board[row][col] = '.';
            colArr[col] = 0;
            diag[row - col + n - 1] = 0;
            antiDiag[row + col] = 0;
        }
        return;
    }

    public List<List<String>> solveNQueens(int n) {
        int[] colArr = new int[n];
        int[] diag = new int[2 * n - 1];
        int[] antiDiag = new int[2 * n - 1];
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solver(board, 0, n, colArr, diag, antiDiag);
        return ans;

    }
}
