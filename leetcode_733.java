public class leetcode_733 {
    public void fill(int[][] arr, int r, int c, int orgVal, int newVal) {
        // base conditions:
        if (r < 0 || r >= arr.length || c < 0 || c >= arr[0].length || arr[r][c] == newVal || arr[r][c] != orgVal) {
            return;
        }
        arr[r][c] = newVal;
        // call recursively for adjancent places.
        fill(arr, r - 1, c, orgVal, newVal);
        fill(arr, r + 1, c, orgVal, newVal);
        fill(arr, r, c - 1, orgVal, newVal);
        fill(arr, r, c + 1, orgVal, newVal);
        return;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        fill(image, sr, sc, image[sr][sc], color);
        return image;
    }

}
