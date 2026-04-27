import java.util.ArrayList;
import java.util.List;

class leetcode_3912 {
    public List<Integer> findValidElements(int[] nums) {
        int len = nums.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = Integer.MIN_VALUE;
        rightMax[len - 1] = Integer.MIN_VALUE;

        // fill suffix and prefix
        for (int i = 1; i < len; i++) {
            leftMax[i] = (nums[i - 1] > leftMax[i - 1]) ? nums[i - 1] : leftMax[i - 1];
            rightMax[len - i - 1] = (nums[len - i] > rightMax[len - i]) ? nums[len - i] : rightMax[len - i];
        }
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (leftMax[i] < nums[i] || rightMax[i] < nums[i]) {
                answer.add(nums[i]);
            }
        }
        return answer;
    }
}