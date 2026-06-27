public class leetcode_268 {
    public int missingNumber(int[] nums) {
        long sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        long expectedSum = n * (n + 1) / 2;
        int ans = (int) (expectedSum - sum);
        return ans;
    }
}
