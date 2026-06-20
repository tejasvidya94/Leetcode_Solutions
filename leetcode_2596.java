public class leetcode_2596 {
    boolean isValid(int[][] grid, int r, int c, int expectedVal) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != expectedVal) {
            return false;
        }
        if (expectedVal == grid.length * grid.length - 1)
            return true;
        return (isValid(grid, r + 1, c + 2, expectedVal + 1) ||
                isValid(grid, r - 1, c + 2, expectedVal + 1) ||
                isValid(grid, r + 1, c - 2, expectedVal + 1) ||
                isValid(grid, r - 1, c - 2, expectedVal + 1) ||
                isValid(grid, r + 2, c + 1, expectedVal + 1) ||
                isValid(grid, r + 2, c - 1, expectedVal + 1) ||
                isValid(grid, r - 2, c + 1, expectedVal + 1) ||
                isValid(grid, r - 2, c - 1, expectedVal + 1));

    }

    public boolean checkValidGrid(int[][] grid) {
        return isValid(grid, 0, 0, 0);
    }
}
