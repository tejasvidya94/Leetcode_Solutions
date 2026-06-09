public class leetcode_3689 {
    public long maxTotalValue(int[] nums, int k) {
        int GlobalMax = Integer.MIN_VALUE;
        int GlobalMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (GlobalMax < nums[i]) {
                GlobalMax = nums[i];
            }
            if (GlobalMin > nums[i]) {
                GlobalMin = nums[i];
            }
        }
        long sol = (long) k * (GlobalMax - GlobalMin);
        return sol;
    }
}