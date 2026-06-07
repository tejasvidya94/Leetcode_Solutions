import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);

            if (i >= k - 1) {
                ans[i - k + 1] = deque.peekFirst();
            }
            if (i >= k - 1 && nums[i - k + 1] == deque.peekFirst()) {
                deque.pollFirst();
            }
        }
        return ans;
    }
}