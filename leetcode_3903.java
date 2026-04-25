public class leetcode_3903 {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            int min = nums[i];
            for (int j = 0; j <= i; j++) {
                if (max < nums[j]) {
                    max = nums[j];
                }
            }
            for (int j = i; j < n; j++) {
                if (min > nums[j]) {
                    min = nums[j];
                }
            }
            if ((max - min) <= k) {
                return i;
            }
        }
        return -1;
    }
}