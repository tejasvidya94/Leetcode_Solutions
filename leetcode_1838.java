import java.util.Arrays;

public class leetcode_1838 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int ans = -1;
        int l = 0;
        long sum = 0;

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while ((long) (r - l + 1) * nums[r] - sum > k && l <= r) {
                sum -= nums[l];
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
