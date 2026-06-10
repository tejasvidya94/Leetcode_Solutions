import java.util.Stack;

public class leetcode_84 {
    class Solution {
        public int largestRectangleArea(int[] heights) {

            Stack<Integer> st = new Stack<>();
            int maxArea = 0;
            int n = heights.length;

            for (int i = 0; i < n; i++) {

                while (!st.isEmpty() &&
                        heights[st.peek()] > heights[i]) {

                    int height = heights[st.pop()];

                    int left = st.isEmpty() ? -1 : st.peek();

                    int width = i - left - 1;

                    maxArea = Math.max(maxArea,
                            height * width);
                }

                st.push(i);
            }

            while (!st.isEmpty()) {

                int height = heights[st.pop()];

                int left = st.isEmpty() ? -1 : st.peek();

                int width = n - left - 1;

                maxArea = Math.max(maxArea,
                        height * width);
            }

            return maxArea;
        }
    }
}
